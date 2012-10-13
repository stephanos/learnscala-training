package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_B23[T: TypeTag] extends BaseTest[T] {

    task(1)("+%", "operator") {
        (_, target) =>
            implicit val t = target

            mustHaveMethod("plus50p") {
                m =>
                    "must increase value of '150' by 50 %" >> {
                        invoke(target, m) === 225
                    }
            }
    }

    task(2)("-%", "operator") {
        (_, target) =>
            mustHaveMethod("minus50p") {
                m =>
                    "must decrease value of '150' by 50 %" >> {
                        invoke(target, m) === 75
                    }
            }
    }
}