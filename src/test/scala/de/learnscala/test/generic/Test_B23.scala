package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_B23[T: TypeTag] extends BaseTest[T] {

    override def fs =
    task(1)("r1", "method") {
        implicit ctx =>
            mustHaveMethod {
              implicit m =>
                    "(1 * 1/2) must be '1/2'" ! {
                        Option(m.invoke()).map(_.toString).getOrElse("TODO") === "1/2"
                    }
            }
    } ^
    task(2)("r2", "method") {
        implicit ctx =>
            mustHaveMethod {
              implicit m =>
                    "must increase value of '150' by 50 %" ! {
                        m.invoke() === 225
                    }
            }
    }
}