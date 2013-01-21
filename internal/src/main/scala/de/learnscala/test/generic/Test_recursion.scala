package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_recursion[T: TypeTag] extends BaseTest[T]() {

  override def twoPass = false // StackOverflow simulated ...

  override val fs =
    task(1)("quadSum", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(5, List(1, 2)) ^
              mustReturn(1, List(1)) ^
              mustReturn(14, List(1, 2, 3))

        }
    } ^ task(2)("fib", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(0, 0) ^
              mustReturn(1, 1) ^
              mustReturn(1, 2) ^
              mustReturn(2, 3) ^
              mustReturn(3, 4)
        }
    }
}