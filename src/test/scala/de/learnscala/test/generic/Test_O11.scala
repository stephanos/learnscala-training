package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O11[T: TypeTag] extends BaseTest[T] {

    test("butter", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must be 'Butter for 0.95€'" ! {
                        invoke(target, m).toString === "Butter for 0.95€"
                    }
            }
    }

    test("milk", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must be 'Milk for 0.99€'" ! { // TODO: WRONG ?!
                        invoke(target, m).toString === "Milk for 0.99€"
                    }
            }
    }

    test("butterAndMilk", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must be 'Butter & Milk for 1.94€'" ! {
                        invoke(target, m).toString === "Butter & Milk for 1.94€"
                    }
            }
    }

    test("apple5kg", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must be '5kg Apples for 1.0€'" ! {
                        invoke(target, m).toString === "5kg Apples for 1.0€"
                    }
            }
    }

    test("butterMilkAndApples", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must be '5kg Apples & Butter & Milk for 2.94€'" ! {
                        invoke(target, m).toString === "5kg Apples & Butter & Milk for 2.94€"
                    }
            }
    }
}

