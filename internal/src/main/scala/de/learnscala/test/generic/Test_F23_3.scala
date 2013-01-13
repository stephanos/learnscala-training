package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F23_3[T: TypeTag] extends BaseTest[T] {

  override def fs =
    task(1)("m1", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            "must return '6' for (1,2,3)" ! {
              m.invoke(List(1, 2, 3)) === 6
            } ^
              "must return '0' for ()" ! {
                m.invoke(List()) === 0
              } ^
              mustNotBeLongerThan(1)
        }
    } ^
      task(2)("m2", "method") {
        implicit ctx =>
          mustHaveMethod {
            implicit m =>
              mustNotBeLongerThan(1)
          }
      } ^
      task(3)("m3", "method") {
        implicit ctx =>
          mustHaveMethod {
            implicit m =>
              mustNotBeLongerThan(1)
          }
      } ^
      task(4)("m4", "method") {
        implicit ctx =>
          mustHaveMethod {
            implicit m =>
              mustNotBeLongerThan(1)
          }
      } ^
      task(5)("m5", "method") {
        implicit ctx =>
          mustHaveMethod {
            implicit m =>
              mustNotBeLongerThan(1)
          }
      }
}