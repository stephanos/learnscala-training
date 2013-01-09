package de.learnscala.base

import reflect.macros.Context

class Macro[C <: Context](val c: C) {

    import c.universe._
    import Flag._

    private def apply(n: Int, code: c.Expr[Any]): c.Expr[Any] = {
        implicit val impl_code = code

        val task =
            c.resetAllAttrs(code.tree) match {
                case Block(userCode, _) =>
                    pimpUserCode(userCode)
                case _ =>
                    Literal(Constant((null))) // no content, create stub
            }

        c.Expr(Block(List(
            Apply(Select(This(tpnme.EMPTY), newTermName("register")), List(Literal(Constant(n)), task))
        ), Literal(Constant(()))))
    }

    private def pimpUserCode(codeTree: List[Tree])(implicit code: c.Expr[Any]): Block = {
        implicit val impl_code = codeTree

        val meta: List[ValDef] =
            List(countIfs, countDefs, countVals, countNulls, countTrys, countFinallys, countWhiles, countFors, countLines, countVars, countReturns).map {
                kv => metaField(kv._1, kv._2)
            } ::: List(listAnnotations, listCalls).map {
                kv => metaField(kv._1, kv._2)
            }

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
        ("noOfIfs", codeTree.collect { case e: If => true }.size)

    private def countVars(implicit codeTree: List[Tree]): (String, Int) =
        ("noOfVars", codeTree.collect { case e: ValDef if(e.mods.hasFlag(MUTABLE)) => true }.size)

    private def countVals(implicit codeTree: List[Tree]): (String, Int) =
        ("noOfVals", codeTree.collect { case e: ValDef if(!e.mods.hasFlag(MUTABLE) && !e.mods.hasFlag(PARAM)) => true }.size)

    private def countWhiles(implicit codeTree: List[Tree]): (String, Int) =
        ("noOfWhiles", codeTree.collect { case e: LabelDef => true }.size)

    private def countFors(implicit codeTree: List[Tree]): (String, Int) =
        ("noOfFors", 0) // TODO

    private def countTrys(implicit codeTree: List[Tree]): (String, Int) =
        ("noOfTrys", codeTree.collect { case e: Try => true }.size)

    private def countFinallys(implicit codeTree: List[Tree]): (String, Int) =
        ("noOfFinallys", codeTree.collect { case e: Try if(!e.finalizer.isEmpty) => true }.size)

    private def countDefs(implicit codeTree: List[Tree]): (String, Int) =
        ("noOfDefs", codeTree.collect { case e: DefDef => true }.size)

    private def countNulls(implicit codeTree: List[Tree]): (String, Int) =
        ("noOfNulls", codeTree.collect { case Literal(Constant(null)) => true }.size)

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
        for(i <- limits._1 to limits._2)
            if (source.lineToString(i).isEmpty) empty += 1

        ("noOfLines", 1 + limits._2 - limits._1 - empty)
    }

    private def countReturns(implicit codeTree: List[Tree]): (String, Int) =
        ("noOfReturns", codeTree.collect { case e: Return => true }.size)

    private def listAnnotations(implicit codeTree: List[Tree]): (String, List[String]) =
        ("listOfAnnot", List[String]("")) // TODO

    private def listCalls(implicit codeTree: List[Tree]): (String, List[String]) =
        ("listOfCalls", codeTree.collect {
            case a: Apply =>
                println("A", a)
                a.toString()
            case s: DefDef =>
                //println("S", s)
                s.toString()
        })

    private def metaField(name: String, value: Int) =
        ValDef(Modifiers(OVERRIDE), newTermName("_" + name), TypeTree(), Literal(Constant(value)))

    private def metaField(name: String, value: List[String]) = {
        val params = value.map(v => Literal(Constant(v)))
        ValDef(Modifiers(OVERRIDE), newTermName("_" + name), TypeTree(),
            Apply(Select(Select(Select(Select(Ident("scala"), newTermName("collection")), newTermName("immutable")), newTermName("List")), newTermName("apply")), params)
        )
    }

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

object Macro {

    def singleTask(c: Context)(code: c.Expr[Any]): c.Expr[Any] = {
        new Macro[c.type](c).apply(0, code)
    }

    def task(c: Context)(num: c.Expr[Int])(code: c.Expr[Any]): c.Expr[Any] = {
        import c.universe._
        val Literal(Constant(n: Int)) = num.tree
        new Macro[c.type](c).apply(n, code)
    }

}