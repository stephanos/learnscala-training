package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O11[T: TypeTag] extends BaseTest[T](continuous = true) {

  override def fs =
    test(1)("butter", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              mustHaveResult() {
                r =>
                  "must be 'Butter for 0.95€'" ! {
                    r.toString === "Butter for 0.95€"
                  }
              }
            }
        }
    } ^ test(2)("milk", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              mustHaveResult() {
                r =>
                  "must be 'Milk for 0.99€'" ! {
                    r.toString === "Milk for 0.99€"
                  }
              }
            }
        }
    } ^ test(3)("butterAndMilk", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              mustHaveResult() {
                r =>
                  "must be 'Butter & Milk for 1.94€'" ! {
                    r.toString === "Butter & Milk for 1.94€"
                  }
              }
            }
        }
    } ^ test(4)("apple5kg", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              mustHaveResult() {
                r =>
                  "must be '5kg Apples for 1.0€'" ! {
                    r.toString === "5kg Apples for 1.0€"
                  }
              }
            }
        }
    } ^ test(5)("butterMilkAndApples", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              mustHaveResult() {
                r =>
                  "must be '5kg Apples & Butter & Milk for 2.94€'" ! {
                    r.toString === "5kg Apples & Butter & Milk for 2.94€"
                  }
              }
            }
        }
    }
}

