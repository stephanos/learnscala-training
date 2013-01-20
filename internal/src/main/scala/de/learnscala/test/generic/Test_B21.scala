package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_B21[T: TypeTag] extends BaseTest[T]() {

  override val fs =
    task(1)("gcd", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(2) ^
              mustReturn(0, 0, 0, 0)
        }
    } ^ task(2)("fib", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn(0, 0) ^
              mustReturn(1, 1) ^
              mustReturn(1, 2) ^
              mustReturn(2, 3) ^
              mustReturn(3, 4) ^
              mustReturn(BigInt("12586269025"), 50)
        }
    }
}