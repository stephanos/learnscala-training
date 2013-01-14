package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F23_2[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("sum", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustNotBeLongerThan(1) ^
              "must return '6' for (1,2,3)" ! {
                m.invoke(List(1, 2, 3)) === 6
              } ^
              "must return '0' for ()" ! {
                m.invoke(List()) === 0
              }
        }
    } ^
      task(2)("product", "method") {
        implicit ctx =>
          mustHaveMethod {
            implicit m =>
              mustNotBeLongerThan(1) ^
                "must return '6' for (1,2,3)" ! {
                  m.invoke(List(1, 2, 3)) === 6
                } ^
                "must return '27' for (3,3,3)" ! {
                  m.invoke(List(3, 3, 3)) === 27
                } ^
                "must return '1' for ()" ! {
                  m.invoke(List()) === 1
                }
          }
      } ^
      task(3)("count", "method") {
        implicit ctx =>
          mustHaveMethod {
            implicit m =>
              mustNotBeLongerThan(1) ^
                "must return '3' for (1,2,3)" ! {
                  m.invoke(List(1, 2, 3)) === 3
                } ^
                "must return '0' for ()" ! {
                  m.invoke(List()) === 0
                }
          }
      } ^
      task(4)("contains", "method") {
        implicit ctx =>
          mustHaveMethod {
            implicit m =>
              mustNotBeLongerThan(1) ^
                "must return 'true' for (1,2,3) and 3" ! {
                  m.invoke(List(1, 2, 3), 3) === true
                } ^
                "must return 'true' for (1,2,3) and 9" ! {
                  m.invoke(List(1, 2, 3), 9) === false
                } ^
                "must return 'false' for () and 3" ! {
                  m.invoke(List[Int](), 3) === false
                }
          }
      } ^
      task(5)("reverse", "method") {
        implicit ctx =>
          mustHaveMethod {
            implicit m =>
              mustNotBeLongerThan(1) ^
                "must return '(3,2,1)' for (1,2,3)" ! {
                  m.invoke(List(1, 2, 3)) === List(3, 2, 1)
                } ^
                "must return '()' for ()" ! {
                  m.invoke(List()) === List()
                }
          }
      } ^
      task(5)("reverse", "method") {
        implicit ctx =>
          mustHaveMethod {
            implicit m =>
              mustNotBeLongerThan(1) ^
                "must return '(3,2,1)' for (1,2,3)" ! {
                  m.invoke(List(1, 2, 3)) === List(3, 2, 1)
                } ^
                "must return '()' for ()" ! {
                  m.invoke(List()) === List()
                }
          }
      }
}