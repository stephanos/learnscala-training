package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_object[T: TypeTag] extends BaseTest[T](continuous = true) {

  override val fs =
    test(1)("p2", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturnAsString("[5,5]")
        }
    } ^ test(2)("p2", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturnAsString("[5,5]")
        }
    } ^ test(3)("p3", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustThrow[Throwable]()
        }
    } ^ test(4)("p4", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustThrow[Throwable]()
        }
    }^ test(5)("p5", "method") {
          implicit ctx =>
            mustHaveMethod {
              implicit m =>
                mustReturn(2)
            }
        }
}