package de.learnscala.base

import reflect.macros.Context

class Macro[C <: Context](val c: C) {

    import c.universe._

    def apply(num: c.Expr[Int], code: c.Expr[Any]): c.Expr[Any] = {

        implicit val impl_code = code
        val Literal(Constant(n: Int)) = num.tree

        def addMeta(name: String, value: Int) =
            ValDef(Modifiers(), newTermName(name), TypeTree(typeOf[Int]), Literal(Constant(value)))

        def checkIfs()(implicit code: c.Expr[Any]): (String, Int) = {
            val ifs = code.tree.collect {
                case If(_) => true
            }
            ("if_" + n, ifs.size)
        }

        val vals: List[ValDef] =
            List[(String, Int)](checkIfs()).map {
                kv => addMeta(kv._1, kv._2)
            }

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
        code
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
}

object Macro {

    def apply(c: Context)(num: c.Expr[Int])(code: c.Expr[Any]): c.Expr[Any] = {
        new Macro[c.type](c).apply(num, code)
    }
}