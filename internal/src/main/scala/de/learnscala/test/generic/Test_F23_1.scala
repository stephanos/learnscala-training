package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F23_1[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("r1", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List(2, 3, 4), List(1, 2, 3))
        }
    } ^ task(2)("r2", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List(4, 6, 8), List(1, 2, 3))
        }
    } ^ task(3)("r3", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List(3, 5,7), List(1, 2, 3))
        }
    } ^ task(4)("r4", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List(3, 5, 7), List(1, 2, 3))
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