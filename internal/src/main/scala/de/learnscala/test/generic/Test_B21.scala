package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_B21[T: TypeTag] extends BaseTest[T]() {

  override def twoPass = false // StackOverflow simulated ...

  override val fs =
    task(1)("gcd", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(2) {
              mustReturn(2, 2, 4) ^
                mustReturn(3, 6, 9) ^
                mustReturn(8, 8, 16)
            }
        }
    } ^ task(2)("sumDouble", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) {
              mustReturn(5, List(1, 2)) ^
                mustReturn(1, List(1)) ^
                mustReturn(14, List(1, 2, 3)) ^
                mustReturn(14, 1 to 100000)
            }
        }
    } ^ task(3)("fib", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) {
              mustReturn(0, 0) ^
                mustReturn(1, 1) ^
                mustReturn(1, 2) ^
                mustReturn(2, 3) ^
                mustReturn(3, 4) ^
                mustReturn(BigInt("12586269025"), 50)
            }
        }
    }
}