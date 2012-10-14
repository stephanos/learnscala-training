package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O12[T: TypeTag] extends BaseTest[T] {

    val objn = "Point"

    test("p1") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must create instance for coordinates (5,5)" >> {
                        invoke(target, m).toString === "[5,5]"
                    }
            }
    }

    test("p2") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must create instance for coordinates (5,5) for parameter '5'" >> {
                        invoke(target, m).toString === "[5,5]"
                    }
            }
    }

    test("p3") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must throw exception for 2 negative coordinates" >> {
                        invoke(target, m) must throwA[Throwable]
                    }
            }
    }

    test("p4") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must throw exception for 1 negative coordinate" >> {
                        invoke(target, m) must throwA[Throwable]
                    }
            }
    }
}