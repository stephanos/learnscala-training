package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_B14_2[T: TypeTag] extends BaseTest[T] {

    task(1)("countingOut", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, List())

                    "must print numbers from 1 to 10" >> {
                        captureOutput(invoke(target, m))._2.trim === "1 2 3 4 5 6 7 8 9 10"
                    }
            }
    }

    task(2)("count10s", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, List())

                    "must print multiples of 10 between 10 and 100" >> {
                        captureOutput(invoke(target, m))._2.trim === "10 20 30 40 50 60 70 80 90 100"
                    }
            }
    }

    task(3)("countMod", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, List(Int))

                    "must print only even numbers for argument '2'" >> {
                        captureOutput(invoke(target, m, 2))._2.trim === "2 4 6 8 10"
                    }
                    "must print only numbers divisible by 3 for argument '3'" >> {
                        captureOutput(invoke(target, m, 3))._2.trim === "3 6 9"
                    }
            }
    }
}