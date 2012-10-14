package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F32[T: TypeTag] extends BaseTest[T] {

    //        "print2Digits" >> {
    //            "must print '10' for 10" >> {
    //                val (r, out) = captureOutput(print2Digits(10))
    //                out.trim === "10"
    //            }
    //            "must print '05' for 5" >> {
    //                val (r, out) = captureOutput(print2Digits(5))
    //                out.trim === "05"
    //            }
    //        }
}