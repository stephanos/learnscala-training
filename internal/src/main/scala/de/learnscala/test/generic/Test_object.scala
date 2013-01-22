package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_object[T: TypeTag] extends BaseTest[T](continuous = true) {

  override val fs =
    test(1)("t1", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturnAsString("[5,5]")
        }
    } ^ test(2)("t2", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturnAsString("[5,5]")
        }
    } ^ test(3)("t3", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustThrow[Throwable]()
        }
    } ^ test(4)("t4", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustThrow[Throwable]()
        }
    } ^ test(5)("t5", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(2)
        }
    }
}