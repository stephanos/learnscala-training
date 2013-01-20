package de.learnscala.base

import reflect.macros.Context

class QuizMacro[C <: Context](val c: C) {

  import c.universe._
  import Flag._

  private def apply(num: c.Expr[Int], text: c.Expr[String], code: c.Expr[Any]): c.Expr[Any] = {

    val Literal(Constant(n: Int)) = num.tree

    val userCode: List[Tree] =
      code.tree match {
        case Block(uc, _) =>
          uc
        case _ =>
          List(Literal(Constant((null)))) // no content, create stub
      }

    //val test = showRaw { reify { Tuple4(5, "text", false, code) } }
    //Expr(Apply(Select(Select(Ident(scala), newTermName("Tuple4")), newTermName("apply")), List(Literal(Constant(5)), Literal(Constant("text")), Literal(Constant(false)), Ident(newTermName("code")))))
    //println(test)

    val quiz =
      Block(
        List(
          // anonymous class
          ClassDef(Modifiers(FINAL), newTypeName("$anon"), List(), Template(List(Ident(newTypeName("Qiz"))), emptyValDef,
            List(
              DefDef(Modifiers(), nme.CONSTRUCTOR, List(), List(List()), TypeTree(), Block(
                List(
                  Apply(Select(Super(This(tpnme.EMPTY), tpnme.EMPTY), nme.CONSTRUCTOR), List())
                ),
                Literal(Constant(()))
              )) //constructor
            ) ::: List(
              ValDef(Modifiers(OVERRIDE), newTermName("_num"), TypeTree(), num.tree),
              ValDef(Modifiers(OVERRIDE), newTermName("_text"), TypeTree(), text.tree),
              ValDef(Modifiers(OVERRIDE), newTermName("_source"), TypeTree(), Literal(Constant(code.tree.toString()))),
              ValDef(Modifiers(OVERRIDE), newTermName("_raw"), TypeTree(), Literal(Constant(showRaw(code.tree))))
            ) ::: userCode
          ))
        ),
        Apply(Select(New(Ident(newTypeName("$anon"))), nme.CONSTRUCTOR), List())
      )

    c.Expr {
      c.resetAllAttrs {
        Block(List(
          Apply(Select(This(tpnme.EMPTY), newTermName("registerQuiz")), List(Literal(Constant(n)), quiz))
        ), Literal(Constant(())))
      }
    }
  }
}

object QuizMacro {


  def quiz(c: Context)(num: c.Expr[Int])(text: c.Expr[String])(answer: c.Expr[Any]): c.Expr[Any] = {
    import c.universe._
    new QuizMacro[c.type](c).apply(num, text, answer)
  }
}