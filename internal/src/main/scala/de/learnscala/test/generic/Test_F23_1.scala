package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F23_1[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("r1", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) {
              "must return (2,3,4) for (1,2,3)" ! {
                m.invoke(List(1, 2, 3)) === List(2, 3, 4)
              }
            }
        }
    } ^ task(2)("r2", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) {
              "must return (4,6,8) for (1,2,3)" ! {
                m.invoke(List(1, 2, 3)) === List(4, 6, 8)
              }
            }
        }
    } ^ task(3)("r3", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) {
              "must return (3,5,6) for (1,2,3)" ! {
                m.invoke(List(1, 2, 3)) === List(3, 5, 7)
              }
            }
        }
    } ^ task(4)("r4", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) {
              "must return (3,5,6) for (1,2,3)" ! {
                m.invoke(List(1, 2, 3)) === List(3, 5, 7)
              }
            }
        }
    } ^ task(5)("r5", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) {
              "must return ((2, 2), (3, 3), (4, 4)) for ((1,3),(2,4),(3,5))" ! {
                m.invoke(List((1, 3), (2, 4), (3, 5))) === List((2, 2), (3, 3), (4, 4))
              }
            }
        }
    }
}