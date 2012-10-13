package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import org.specs2.execute.Pending
import scala.reflect.runtime.universe._

abstract class Test_B14_1[T: TypeTag] extends BaseTest[T] {

    task(1)("theAnswerToLifeTheUniverseAndEverything", "method") {
        (mn, target) =>
            //implicit val stop = WhenFail()

            getMethod[T](mn) match {
                case Some(m) =>
                    haveSignature(m, List())
                    "must return '42'" >> {
                        invoke(target, m) === 42
                    }
                case _ =>
                    "must be defined" >> {
                        Pending()
                    }
            }
    }

    task(2)("signum", "method") {
        (mn, target) =>

            getMethod[T](mn) match {
                case Some(m) =>
                    haveSignature(m, List(Int))
                    "must return '-1' for negative numbers" >> {
                        invoke(target, m, -1) === -1
                        invoke(target, m, -10) === -1
                    }
                    "must return '1' for positive numbers" >> {
                        invoke(target, m, 1) === 1
                        invoke(target, m, 10) === 1
                    }
                    "must return '0' for zero" >> {
                        invoke(target, m, 0) === 0
                    }
                case _ =>
                    "must be defined" >> {
                        Pending()
                    }
            }
    }

    task(3)("absMax", "method") {
        (mn, target) =>

            getMethod[T](mn) match {
                case Some(m) =>
                    haveSignature(m, List(Int, Int))
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
                case _ =>
                    "must be defined" >> {
                        Pending()
                    }
            }
    }
}