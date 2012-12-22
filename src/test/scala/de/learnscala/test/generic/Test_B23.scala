package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_B23[T: TypeTag] extends BaseTest[T] {

    task(1)("r1", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    "(1 * 1/2) must be '1/2'" ! {
                        Option(invoke(target, m)).map(_.toString).getOrElse("TODO") === "1/2"
                    }
            }
    }

    task(2)("r2", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    "must increase value of '150' by 50 %" ! {
                        invoke(target, m) === 225
                    }
            }
    }
}