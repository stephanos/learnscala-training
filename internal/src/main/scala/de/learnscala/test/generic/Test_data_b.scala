package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_data_b[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("doYouBuyTheCar", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn("yes", Some(true)) ^
              mustReturn("no", Some(false)) ^
              mustReturn("not sure", None)
        }
    } ^ task(2)("convertToInt", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(Some(5), "5") ^
              mustReturn(Some(-5), "-5") ^
              mustReturn(None, "a")
        }
    } ^ task(3)("addLeftAndRight", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(5, Some(3), Some(2)) ^
              mustReturn(2, Some(2), None) ^
              mustReturn(3, None, Some(3)) ^
              mustReturn(0, None, None)
        }
    }
}