package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_B22[T: TypeTag] extends BaseTest[T] {

    override def fs =
    task(1)("r1", "method") {
        implicit ctx =>
            mustHaveMethod {
              implicit m =>
                    mustHaveParams() ^
                    "must return '1/2'" ! {
                        Option(m.invoke()).map(_.toString).getOrElse("TODO") === "1/2"
                    }
            }
    } ^
    task(2)("r2", "method") {
        implicit ctx =>
            mustHaveMethod {
              implicit m =>
                    mustHaveParams() ^
                    "must return '1/4'" ! {
                        Option(m.invoke()).map(_.toString).getOrElse("TODO") === "1/4"
                    }
            }
    } ^
    task(3)("r3", "method") {
        implicit ctx =>
            mustHaveMethod {
              implicit m =>
                    mustHaveParams() ^
                    "must return '1/2'" ! {
                        Option(m.invoke()).map(_.toString).getOrElse("TODO") === "1/4"
                    }
            }
    }
    task(4)("r4", "method") {
        implicit ctx =>
            mustHaveMethod {
              implicit m =>
                    mustHaveParams() ^
                    "must return '7/12'" ! {
                        Option(m.invoke()).map(_.toString).getOrElse("TODO") === "7/12"
                    }
            }
    } ^
    task(5)("r5", "method") {
        implicit ctx =>
            mustHaveMethod {
              implicit m =>
                    mustHaveParams() ^
                    "must return '2/1'" ! {
                        Option(m.invoke()).map(_.toString).getOrElse("TODO") === "2/1"
                    }
            }
    }
}
