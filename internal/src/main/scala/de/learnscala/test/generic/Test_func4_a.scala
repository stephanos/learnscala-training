package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_func4_a[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("sum", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustNotBeLongerThan(1) ^
              mustReturn(6, List(1, 2, 3)) ^
              mustReturn(0, List())
        }
    } ^ task(2)("product", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustNotBeLongerThan(1) ^
              mustReturn(6, List(1, 2, 3)) ^
              mustReturn(27, List(3, 3, 3)) ^
              mustReturn(1, List())
        }
    } ^ task(3)("count", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustNotBeLongerThan(1) ^
              mustReturn(3, List(1, 2, 3)) ^
              mustReturn(0, List())
        }
    } ^ task(4)("contains", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustNotBeLongerThan(1) ^
              mustReturn(true, List(1, 2, 3), 3) ^
              mustReturn(false, List(1, 2, 3), 9) ^
              mustReturn(false, List(), 3)
        }
    } ^ task(5)("reverse", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustNotBeLongerThan(1) ^
              mustReturn(List(3, 2, 1), List(1, 2, 3)) ^
              mustReturn(List(), List())
        }
    }
}