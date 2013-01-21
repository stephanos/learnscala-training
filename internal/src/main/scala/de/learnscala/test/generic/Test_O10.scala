package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O10[T: TypeTag] extends BaseTest[T](continuous = true) {

  override val fs =
    test(0)("Time", "class", descr = "Requirements") {
      implicit ctx =>
      //mustHaveClass("Time") {
        mustNotContain(VAR)
    } ^ test(1)("t1", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              mustReturnAsString("13:37")
            }
        }
    } ^ test(2)("t2", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              mustReturnAsString("20:00")
            }
        }
    } ^ test(3)("t3", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              mustReturnAsString("0:00")
            }
        }
    } ^ test(4)("t4", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              mustReturnAsString("14:00")
            }
        }
    } ^ test(5)("t5", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              mustReturnAsString("0:01")
            }
        }
    } ^ test(6)("t6", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              mustReturnAsString("2:00")
            }
        }
    } ^ test(7)("t7", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              mustThrow[Exception]()
            }
        }
    }
}

