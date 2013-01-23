package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_func3_a[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("r", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            val exp = "1\n2\n3"
            s"must print '$exp'" ! {
              captureOutput(m.invoke())._2.trim === exp
            }
        }
    } ^ task(2)("r", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            val exp = "Mary\nBarry"
            s"must print '$exp'" ! {
              captureOutput(m.invoke())._2.trim === exp
            }
        }
    } ^ task(3)("r", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List(2, 4))
        }
    } ^ task(4)("r", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List(1, 9))
        }
    } ^ task(5)("r", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List(("Piraten", 4)))
        }
    } ^ task(6)("r", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List(2, 4, 6, 8))
        }
    } ^ task(7)("r", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(Some("ABC"), Some("abc")) ^
              mustReturn(None, None)
        }
    } ^ task(8)("r", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List("Jimmy", "Bobby", "Johnny"))
        }
    } ^ task(9)("r", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List("o", "u", "i", "e", "a", "ü", "ä", "ö"))
        }
    } ^ task(10)("r", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn((List("Anna", "Maria"),List("John", "Adam")))
        }
    } ^ task(11)("r", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(true, List(1, 3, 7)) ^
            mustReturn(false, List(4, 8, 12))
        }
    }
}