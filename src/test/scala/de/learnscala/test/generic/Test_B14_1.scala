package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import org.specs2.execute.Pending
import scala.reflect.runtime.universe._

abstract class Test_B14_1[T: TypeTag] extends BaseTest[T] {

    task(1)("answer to life") {
        target =>
            implicit val stop = WhenFail()
            val name = "isTheAnswerToLifeTheUniverseAndEverything"

            getMethod[T](name) match {
                case Some(m) =>
                    "have 0 arguments" >> {
                        getParams(m) must haveSize(0)
                    }
                    "return '42'" >> {
                        invoke(target, m) === 42
                    }
                case _ =>
                    "have a method called '" + name + "'" >> {
                        Pending()
                    }
            }
    }

    task(2)("signum") {
        target =>

            implicit val stop = WhenFail()
            val name = "signum"

            getMethod[T](name) match {
                case Some(m) =>
                    "have 1 argument" >> {
                        getParams(m) must haveSize(1)
                    }
                    "return '-1' for negative numbers" >> {
                        invoke(target, m, -1) === -1
                        invoke(target, m, -10) === -1
                    }
                    "return '1' for positive numbers" >> {
                        invoke(target, m, 1) === 1
                        invoke(target, m, 10) === 1
                    }
                    "return '0' for zero" >> {
                        invoke(target, m, 0) === 0
                    }
                case _ =>
                    "have a method called '" + name + "'" >> {
                        Pending()
                    }
            }
    }

    task(3)("absMax") {
        target =>

            implicit val stop = WhenFail()
            val name = "absMax"

            getMethod[T](name) match {
                case Some(m) =>
                    "have 2 arguments" >> {
                        getParams(m) must haveSize(2)
                    }
                    "return bigger one of 2 positive numbers" >> {
                        invoke(target, m, 5, 2) === 5
                        invoke(target, m, 2, 5) === 5
                    }
                    "return bigger one of 1 positive and 1 negative" >> {
                        invoke(target, m, -2, 5) === 5
                        invoke(target, m, 2, -5) === -5
                    }
                    "return bigger one of 2 negative numbers" >> {
                        invoke(target, m, -2, -5) === -5
                        invoke(target, m, -5, -2) === -5
                    }
                case _ =>
                    "have a method called '" + name + "'" >> {
                        Pending()
                    }
            }
    }
}