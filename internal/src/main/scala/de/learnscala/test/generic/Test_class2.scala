package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_class2[T: TypeTag] extends BaseTest[T](continuous = true) {

  override def fs =
    test(1)("s1", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(5)
        }
    } ^ test(2)("s2", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(10)
        }
    } ^ test(3)("s3", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(24)
        }
    } ^ test(4)("s4", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(1)
        }
    } ^ test(5)("s5", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(0)
        }
    } ^ test(6)("s6", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(33)
        }
    }
}

