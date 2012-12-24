package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_B14_1[T: TypeTag] extends BaseTest[T] {

    override def fs =
        task2(1)("theAnswerToLifeTheUniverseAndEverything", "method") {
            implicit ctx =>
                mustHaveMethod2 {
                    implicit m =>
                        mustHaveParams2() ^
                            mustReturn(42)
                }
        } ^
            task2(2)("signum", "method") {
                implicit ctx =>

                    mustHaveMethod2 {
                        implicit m =>
                            mustHaveParams2(classOf[Int]) ^
                                "must return '0' for zero" ! {
                                    m.invoke(0) === 0
                                } ^
                                "must return '-1' for negative numbers" ! {
                                    m.invoke(-1) === -1
                                    m.invoke(-10) === -1
                                } ^
                                "must return '1' for positive numbers" ! {
                                    m.invoke(1) === 1
                                    m.invoke(10) === 1
                                }
                    }
            } ^
            task2(3)("absMax", "method") {
                implicit ctx =>
                    mustHaveMethod2 {
                        implicit m =>
                            mustHaveParams2(classOf[Int], classOf[Int]) ^
                                "must return bigger one of 2 positive numbers" ! {
                                    m.invoke(5, 2) === 5
                                    m.invoke(2, 5) === 5
                                } ^
                                "must return bigger one of 1 positive and 1 negative" ! {
                                    m.invoke(-2, 5) === 5
                                    m.invoke(2, -5) === -5
                                } ^
                                "must return bigger one of 2 negative numbers" ! {
                                    m.invoke(-2, -5) === -5
                                    m.invoke(-5, -2) === -5
                                }
                    }
            } ^
            task2(4)("countingOut", "method") {
                implicit ctx =>
                    mustHaveMethod2 {
                        implicit m =>
                            mustHaveParams2() ^
                                "must print numbers from 1 to 10" ! {
                                    captureOutput(m.invoke())._2.trim === "1 2 3 4 5 6 7 8 9 10"
                                }
                    }
            } ^
            task2(5)("count10s", "method") {
                implicit ctx =>
                    mustHaveMethod2 {
                        implicit m =>
                            mustHaveParams2() ^
                                "must print multiples of 10 between 10 and 100" ! {
                                    captureOutput(m.invoke())._2.trim === "10 20 30 40 50 60 70 80 90 100"
                                }
                    }
            } ^
            task2(6)("countMod", "method") {
                implicit ctx =>
                    mustHaveMethod2 {
                        implicit m =>
                            mustHaveParams2(classOf[Int]) ^
                                "must print only even numbers for argument '2'" ! {
                                    captureOutput(m.invoke(2))._2.trim === "2 4 6 8 10"
                                } ^
                                "must print only numbers divisible by 3 for argument '3'" ! {
                                    captureOutput(m.invoke(3))._2.trim === "3 6 9"
                                }
                    }
            }
}