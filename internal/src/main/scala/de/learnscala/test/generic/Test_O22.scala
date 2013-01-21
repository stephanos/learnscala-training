package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O22[T: TypeTag] extends BaseTest[T](continuous = true) {

  override def fs =
    task(1)("s1", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "must return '5'" ! {
                m.invoke() === 5
              }
            }
        }
    } ^ task(2)("s2", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "must return '10'" ! {
                m.invoke() === 10
              }
            }
        }
    } ^ task(3)("s3", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "must return '25'" ! {
                m.invoke() === 25
              }
            }
        }
    } ^ task(4)("s4", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "must return '1'" ! {
                m.invoke() === 1
              }
            }
        }
    } ^ task(5)("s5", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "must return '0'" ! {
                m.invoke() === 0
              }
            }
        }
    } ^ task(6)("s6", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "must return '33'" ! {
                m.invoke() === 33
              }
            }
        }
    }
}

