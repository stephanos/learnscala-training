package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F32[T: TypeTag] extends BaseTest[T] {

    override def fs =
        task(1)("incr", "method") {
            implicit ctx =>
                mustHaveMethod {
                    implicit m =>
                        mustHaveParams() ^
                            "must return '10'" ! {
                                m.invoke() === 10
                            }
                }
        } ^
            task(2)("print2Digits", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            mustHaveParams(1) ^
                                "must print '60' for '60'" ! {
                                    captureOutput(m.invoke(60))._2 === "60"
                                } ^
                                "must print '05' for '5'" ! {
                                    captureOutput(m.invoke(5))._2 === "05"
                                }
                    }
            }
}