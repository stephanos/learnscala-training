package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F22[T: TypeTag] extends BaseTest[T] {

    task(1)("swap", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, classOf[Tuple2[Int, Int]])

                    "must return (5,1) for (1,5)" >> {
                        invoke(target, m, (5, 1)) ===(1, 5)
                    }
                    "must return (1,1) for (1,1)" >> {
                        invoke(target, m, (1, 1)) ===(1, 1)
                    }
            }
    }

    task(2)("sum", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, classOf[Tuple3[Boolean, Int, Int]])

                    "must return 5 for (true,2,3)" >> {
                        invoke(target, m, (true, 2, 3)) === 5
                    }
                    "must return 2 for (true,1,1)" >> {
                        invoke(target, m, (true, 1, 1)) === 2
                    }
                    "must return -1 for (true,2,3)" >> {
                        invoke(target, m, (false, 2, 3)) === -1
                    }
                    "must return 1 for (true,9,8)" >> {
                        invoke(target, m, (false, 9, 8)) === 1
                    }
            }
    }

    task(3)("doYouBuyTheCar", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, classOf[Option[Boolean]])

                    "must print 'yes' for Some(true)" >> {
                        captureOutput(invoke(target, m, Some(true)))._2.trim === "yes"
                    }
                    "must print 'no' for Some(false)" >> {
                        captureOutput(invoke(target, m, Some(false)))._2.trim === "no"
                    }
                    "must print 'not sure' for None" >> {
                        captureOutput(invoke(target, m, None))._2.trim === "not sure"
                    }
            }
    }

    task(4)("convertToInt", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, classOf[String])

                    "must return 'Some(5)' for '5'" >> {
                        invoke(target, m, "5") === Some(5)
                    }
                    "must return 'Some(-5)' for '-5'" >> {
                        invoke(target, m, "-5") === Some(-5)
                    }
                    "must return 'None' for 'a'" >> {
                        invoke(target, m, "a") === None
                    }
            }
    }
}