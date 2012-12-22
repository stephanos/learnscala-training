package de.learnscala.base

import reflect.macros.Context

class Macro[C <: Context](val c: C) {

    import c.universe._
    import Flag._

    private def apply(num: c.Expr[Int], code: c.Expr[Any]): c.Expr[Any] = {

        implicit val impl_code = code
        val Literal(Constant(n: Int)) = num.tree

        val meta: List[ValDef] =
            List[(String, Int)](checkIfs()).map {
                kv => metaField(kv._1, kv._2)
            }

        /*
        println(showRaw {
            reify {
                class Ex1 extends Testable {

                    this.register(0, new Tsk {
                        override val _noOfIfs = 0
                    })
                }
            }
        })
        */

        c.Expr(Block(
            List(
                Apply(Select(This(tpnme.EMPTY), newTermName("register")),
                    List(Literal(Constant(n)), Block(
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
                                    ::: List(code.tree) // user code
                            ))
                        ),
                        Apply(Select(New(Ident(newTypeName("$anon"))), nme.CONSTRUCTOR), List()))
                    )
                )
            ),
            Literal(Constant(()))
        ))
    }

    def checkIfs()(implicit code: c.Expr[Any]): (String, Int) = {
        val ifs = code.tree.collect {
            case If(_) => true
        }
        ("noOfIfs", ifs.size)
    }

    private def metaField(name: String, value: Any) = {
        ValDef(Modifiers(OVERRIDE), newTermName("_" + name), TypeTree(typeOf[Int]), Literal(Constant(value)))
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

    def apply(c: Context)(num: c.Expr[Int])(code: c.Expr[Any]): c.Expr[Any] = {
        new Macro[c.type](c).apply(num, code)
    }
}