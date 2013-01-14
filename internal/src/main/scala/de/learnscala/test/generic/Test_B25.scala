package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_B25[T: TypeTag] extends BaseTest[T]() {

  override val fs =
    task(1)("fib", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              "1st fibonacci number must be 0" ! {
                m.invoke(0) === 0
              } ^
              "2nd fibonacci number must be 1" ! {
                m.invoke(1) === 1
              } ^
              "3rd fibonacci number must be 1" ! {
                m.invoke(2) === 1
              } ^
              "4th fibonacci number must be 2" ! {
                m.invoke(3) === 2
              } ^
              "5th fibonacci number must be 3" ! {
                m.invoke(4) === 3
              } ^
              "50th fibonacci number test" ! {
                m.invoke(50) === BigInt("12586269025")
              }
        }
    }
}