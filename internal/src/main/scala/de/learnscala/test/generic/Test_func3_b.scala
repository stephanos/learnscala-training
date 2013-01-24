package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_func3_b[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("m", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List(2, 3, 4), List(1, 2, 3)) ^
              mustNotBeLongerThan(3)
        }
    } ^ task(2)("m", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List("anna", "otto"), List("Anna", "OTTO", "Hans")) ^
              mustNotBeLongerThan(3)
        }
    } ^ task(3)("m", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            val exp = "sell BP"
            val inp = List(("GOOG", 0.04f), ("ORCL", 0.02f), ("BP", 0.1f))
            s"must print '$exp' for input '$inp'" ! {
              captureOutput(m.invoke(inp))._2.trim === exp
            } ^ mustNotBeLongerThan(3)
        }
    } ^ task(4)("m", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturnList() {
              l =>
                val exp = List("cat", "bird")
                s"must only contain 'exp'" ! {
                  l.asInstanceOf[Traversable[String]] must contain("cat", "bird").only
                }
            }  ^ mustNotBeLongerThan(3)
        }
    }
}