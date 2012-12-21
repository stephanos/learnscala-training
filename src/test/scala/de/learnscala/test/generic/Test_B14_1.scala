package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_B14_1[T: TypeTag] extends BaseTest[T] {

    task(1)("theAnswerToLifeTheUniverseAndEverything", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must return '42'" >> {
                        invoke(target, m) === 42
                    }
            }
    }

    task(2)("signum", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, classOf[Int])

                    "must return '0' for zero" >> {
                        invoke(target, m, 0) === 0
                    }
                    "must return '-1' for negative numbers" >> {
                        invoke(target, m, -1) === -1
                        invoke(target, m, -10) === -1
                    }
                    "must return '1' for positive numbers" >> {
                        invoke(target, m, 1) === 1
                        invoke(target, m, 10) === 1
                    }
            }
    }

    task(3)("absMax", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, classOf[Int], classOf[Int])

                    "must return bigger one of 2 positive numbers" >> {
                        invoke(target, m, 5, 2) === 5
                        invoke(target, m, 2, 5) === 5
                    }
                    "must return bigger one of 1 positive and 1 negative" >> {
                        invoke(target, m, -2, 5) === 5
                        invoke(target, m, 2, -5) === -5
                    }
                    "must return bigger one of 2 negative numbers" >> {
                        invoke(target, m, -2, -5) === -5
                        invoke(target, m, -5, -2) === -5
                    }
            }
    }

    task(4)("countingOut", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must print numbers from 1 to 10" >> {
                        captureOutput(invoke(target, m))._2.trim === "1 2 3 4 5 6 7 8 9 10"
                    }
            }
    }

    task(5)("count10s", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "must print multiples of 10 between 10 and 100" >> {
                        captureOutput(invoke(target, m))._2.trim === "10 20 30 40 50 60 70 80 90 100"
                    }
            }
    }

    task(6)("countMod", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, classOf[Int])

                    "must print only even numbers for argument '2'" >> {
                        captureOutput(invoke(target, m, 2))._2.trim === "2 4 6 8 10"
                    }
                    "must print only numbers divisible by 3 for argument '3'" >> {
                        captureOutput(invoke(target, m, 3))._2.trim === "3 6 9"
                    }
            }
    }
}