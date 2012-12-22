package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_B25[T: TypeTag] extends BaseTest[T] {

    task(1)("fib", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, 1)

                    "first fibonacci number must be 0" ! {
                        invoke(target, m, 0) === 0
                    }
                    "second fibonacci number must be 1" ! {
                        invoke(target, m, 1) === 1
                    }
                    "third fibonacci number must be 1" ! {
                        invoke(target, m, 2) === 1
                    }
                    "fourth fibonacci number must be 2" ! {
                        invoke(target, m, 3) === 2
                    }
                    "fifth fibonacci number must be 3" ! {
                        invoke(target, m, 4) === 3
                    }
                    "50th fibonacci number test" ! {
                        invoke(target, m, 50) === BigInt("12586269025")
                    }
            }
    }
}