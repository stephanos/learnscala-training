package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O22[T: TypeTag] extends BaseTest[T] {

    task(1)("s1", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must return '5'" ! {
                        invoke(target, m) === 5
                    }
            }
    }

    task(2)("s2", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must return '10'" ! {
                        invoke(target, m) === 10
                    }
            }
    }

    task(3)("s3", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must return '25'" ! {
                        invoke(target, m) === 25
                    }
            }
    }

    task(4)("s4", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must return '1'" ! {
                        invoke(target, m) === 1
                    }
            }
    }

    task(5)("s5", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must return '0'" ! {
                        invoke(target, m) === 0
                    }
            }
    }

    task(6)("s6", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must return '33'" ! {
                        invoke(target, m) === 33
                    }
            }
    }
}

