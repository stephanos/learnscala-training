package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F12[T: TypeTag] extends BaseTest[T] {

    //        "shout must print '#SCALA#'" >> {
    //            captureOutput(shout())._2.trim === "#SCALA#"
    //        }
    //
    //        "google must print '[http://google.com]'" >> {
    //            captureOutput(google())._2.trim === "[http://google.com]"
    //        }
}