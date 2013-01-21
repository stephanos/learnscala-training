package de.learnscala.base

import reflect.macros.Context

class TaskMacro[C <: Context](val c: C) {

  import c.universe._
  import Flag._

  private def apply(n: Int, code: c.Expr[Any]): c.Expr[Any] = {
    implicit val impl_code = code

    code.tree.collect {
      case cls@ClassDef(mods, _, _, _) if (mods.hasFlag(IMPLICIT)) =>
        c.abort(c.enclosingPosition, s"Bitte definieren Sie die 'implicit class' außerhalb des task-Blocks")
    }

    object WorkaroundTransformer extends Transformer {

      val DEFAULTPARAM = reflect.internal.ModifierFlags.DEFAULTPARAM

      override def transform(tree: Tree): Tree = {
        tree match {
          case Template(parents, self, stats) =>
            Template(parents map transform, transform(self).asInstanceOf[ValDef],
              stats filter {
              case dd0: DefDef =>
                //println(dd0)
                val dd = dd0.asInstanceOf[reflect.internal.Trees#DefDef]
                (dd.symbol.flags & DEFAULTPARAM) != DEFAULTPARAM
              case _ =>
                true
            } map transform)
          /*case cd@ClassDef(mods, name, tparams, impl) =>
            println(tparams)
            super.transform {
              ClassDef(mods, name, tparams.map {
                p =>
                  println(p)
                  //Option(p.asInstanceOf[TypeTree].original).getOrElse(p)
                  p
              }, impl)
            }
          */
          case dd@DefDef(mods, name, para, vpara, tpt, rhs) =>
            DefDef(mods, name, para, vpara.map(_.map(_ match {
              case vd@ValDef(mods2, name2, tpt2, rhs2) =>
                Option(tpt2.asInstanceOf[TypeTree].original).map {
                  //println(dd)
                  ValDef(mods2, name2, _, rhs2)
                }.getOrElse(vd)
              case v => v
            })), tpt match {
              case v: TypeTree =>
                Option(v.asInstanceOf[TypeTree].original).getOrElse(v)
            }, rhs)
          /*case dd0: DefDef =>
            val dd = dd0.asInstanceOf[reflect.internal.Trees#DefDef]
            if((dd.symbol.flags & DEFAULTPARAM) == DEFAULTPARAM) {
              Literal(Constant(()))
            } else {
              println(dd)
              dd0
            }*/
          case _ =>
            super.transform(tree)
        }
      }
    }

    // generate: create 'Task' instance
    val task =
      WorkaroundTransformer.transform(code.tree) match {
        case Block(userCode, _) =>
          pimpUserCode(userCode)
        case _ =>
          Literal(Constant((null))) // no content, create stub
      }

    // generate: call 'register' with 'Task' instance
    c.Expr {
      c.resetAllAttrs {
        Block(List(
          Apply(Select(This(tpnme.EMPTY), newTermName("registerTask")), List(Literal(Constant(n)), task))
        ), Literal(Constant(())))
      }
    }
  }

  private def pimpUserCode(codeTree: List[Tree])(implicit code: c.Expr[Any]): Block = {
    implicit val impl_code = codeTree

    // gather meta fields
    val meta: List[ValDef] =
      serialize :::
        List(countIfs, countDefs, countVals, countNulls, countTrys, countFinallys, countWhiles, countFors, countLines, countVars, countReturns).map {
          kv => metaField(kv._1, kv._2)
        }

    // assemble meta fields with user's code
    Block(
      List(
        // anonymous class
        ClassDef(Modifiers(FINAL), newTypeName("$anon"), List(), Template(List(Ident(newTypeName("Tsk"))), emptyValDef,
          List(
            DefDef(Modifiers(), nme.CONSTRUCTOR, List(), List(List()), TypeTree(), Block(
              List(
                Apply(Select(Super(This(tpnme.EMPTY), tpnme.EMPTY), nme.CONSTRUCTOR), List())
              ),
              Literal(Constant(()))
            )) //constructor
          ) ::: meta // meta info
            ::: codeTree // user code
        ))
      ),
      Apply(Select(New(Ident(newTypeName("$anon"))), nme.CONSTRUCTOR), List())
    )
  }

  private def countIfs(implicit codeTree: List[Tree]): (String, Int) =
    ("noOfIfs", codeTree.collect {
      case e: If => true
    }.size)

  private def countVars(implicit codeTree: List[Tree]): (String, Int) =
    ("noOfVars", codeTree.collect {
      case e: ValDef if (e.mods.hasFlag(MUTABLE)) => true
    }.size)

  private def countVals(implicit codeTree: List[Tree]): (String, Int) =
    ("noOfVals", codeTree.collect {
      case e: ValDef if (!e.mods.hasFlag(MUTABLE) && !e.mods.hasFlag(PARAM)) => true
    }.size)

  private def countWhiles(implicit codeTree: List[Tree]): (String, Int) =
    ("noOfWhiles", codeTree.collect {
      case e: LabelDef => true
    }.size)

  private def countFors(implicit codeTree: List[Tree]): (String, Int) =
    ("noOfFors", 0) // TODO

  private def countTrys(implicit codeTree: List[Tree]): (String, Int) =
    ("noOfTrys", codeTree.collect {
      case e: Try => true
    }.size)

  private def countFinallys(implicit codeTree: List[Tree]): (String, Int) =
    ("noOfFinallys", codeTree.collect {
      case e: Try if (!e.finalizer.isEmpty) => true
    }.size)

  private def countDefs(implicit codeTree: List[Tree]): (String, Int) =
    ("noOfDefs", codeTree.collect {
      case e: DefDef => true
    }.size)

  private def countNulls(implicit codeTree: List[Tree]): (String, Int) =
    ("noOfNulls", codeTree.collect {
      case Literal(Constant(null)) => true
    }.size)

  private def countLines(implicit code: c.Expr[Any]): (String, Int) = {

    var limits = (Integer.MAX_VALUE, Integer.MIN_VALUE)
    code.tree.foreach {
      case e: SymTree =>
        val pos = e.pos
        try
          Option(pos.focusStart.line).foreach(s => if (s < limits._1) limits = (s, limits._2))
        catch {
          case e =>
        }
        try
          Option(pos.focusEnd.line).foreach(s => if (s > limits._2) limits = (limits._1, s))
        catch {
          case e =>
        }
      case _ =>
    }

    var empty = 0
    val source = code.tree.pos.source
    for (i <- limits._1 to limits._2)
      if (source.lineToString(i).isEmpty) empty += 1

    ("noOfLines", 1 + limits._2 - limits._1 - empty)
  }

  private def countReturns(implicit codeTree: List[Tree]): (String, Int) =
    ("noOfReturns", codeTree.collect {
      case e: Return => true
    }.size)

  private def metaField(name: String, value: Int) =
    ValDef(Modifiers(OVERRIDE), newTermName("_" + name), TypeTree(), Literal(Constant(value)))

  private def serialize(implicit code: c.Expr[Any]) =
    List(
      ValDef(Modifiers(OVERRIDE), newTermName("_raw"), TypeTree(), Literal(Constant(showRaw(code.tree)))),
      ValDef(Modifiers(OVERRIDE), newTermName("_source"), TypeTree(), Literal(Constant(code.tree.toString())))
    )

  /*
  val tree = code.tree

  val defs =
      tree.collect {
          case d: DefDef => d
      }

  println(tree.children)
  //println(defs)

  val ifs =
      tree.collect {
          case If(_) => c
      }

  //println(ifs)
  */

  /*
  def withoutIf_impl(c: Context)(code: c.Expr[Any]): c.Expr[Any] = {
      import c.universe._

      code.tree match {
          case b: Block =>
              val newChild: List[Tree] =
                  b.children.map {
                      case d: DefDef =>
                          val hasIf = d.exists { case If(_) => true; case _ => false }
                          val excp = reify { sys.error ("NO IF/ELSE!") }.tree
                          if (hasIf)
                              DefDef(Modifiers(), d.name, d.tparams, d.vparamss, d.tpt, excp)
                          else
                              d
                      case c => c
                  }
              c.Expr(Block(newChild: _*))
          case _ => code
      }
  }
   */

  /*
  val pubCode: c.Expr[_] = c.Expr(Block((code.tree.children map {
      _ match {
          case d: DefDef => d
              DefDef(d.mods, d.name, d.tparams, d.vparamss, d.tpt, d.rhs)
          case c => c
      }
  }): _*))
  */

  /*
  println { showRaw { code } }
      println { showRaw { reify { object Test { def task = "task" } } } }
  c.Expr(Block(List(wrapper).map(_.tree), Literal(Constant(()))))
  */

  //val tree: List[Tree] = code.tree :: vals
  //c.Expr(Block(vals, Literal(Constant(()))))
  //c.Expr(Block(List(wrapper).map(_.tree), Literal(Constant(()))))

  //wrapper

  //c.Expr(Block(vals, Literal(Constant(()))))
}

object TaskMacro {

  def singleTask(c: Context)(code: c.Expr[Any]): c.Expr[Any] = {
    new TaskMacro[c.type](c).apply(1, code)
  }

  def task(c: Context)(num: c.Expr[Int])(code: c.Expr[Any]): c.Expr[Any] = {
    import c.universe._
    val Literal(Constant(n: Int)) = num.tree
    new TaskMacro[c.type](c).apply(n, code)
  }
}