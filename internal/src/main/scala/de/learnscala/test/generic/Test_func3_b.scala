package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_func3_b[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("m1", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List(2, 4), List(1,2,3,4)) ^
              mustNotBeLongerThan(2) 
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