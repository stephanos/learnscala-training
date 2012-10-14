package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F11[T: TypeTag] extends BaseTest[T] {

    task(1)("negate", "method") {
        (_, target) =>

            mustHaveMethod("f1") {
                m =>
                    mustHaveParams(m)

                    "f1 must be '-5.0'" >> {
                        invoke(target, m) === -5.0f
                    }
            }
    }

    task(2)("half", "method") {
        (_, target) =>

            mustHaveMethod("f2") {
                m =>
                    mustHaveParams(m)

                    "f2 must be '1.0'" >> {
                        invoke(target, m) === 1.0
                    }
            }
    }

    task(3)("printReverse", "method") {
        (_, target) =>

            mustHaveMethod("f3") {
                m =>
                    mustHaveParams(m)

                    "f3 must output 'cba'" >> {
                        invoke(target, m) === "cba"
                    }
            }
    }

    task(4)("repeat", "method") {
        (_, target) =>

            mustHaveMethod("f4") {
                m =>
                    mustHaveParams(m)

                    "f4 must be '123123123'" >> {
                        invoke(target, m) === "123123123"
                    }
            }
    }
}