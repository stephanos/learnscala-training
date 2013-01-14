package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O11[T: TypeTag] extends BaseTest[T](continuous = true) {

  override def fs =
    task(1)("butter", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() ^
              "must be 'Butter for 0.95€'" ! {
                m.invoke().toString === "Butter for 0.95€"
              }
        }
    } ^ task(2)("milk", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() ^
              "must be 'Milk for 0.99€'" ! {
                // TODO: WRONG ?!
                m.invoke().toString === "Milk for 0.99€"
              }
        }
    } ^ task(3)("butterAndMilk", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() ^
              "must be 'Butter & Milk for 1.94€'" ! {
                m.invoke().toString === "Butter & Milk for 1.94€"
              }
        }
    } ^ task(4)("apple5kg", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() ^
              "must be '5kg Apples for 1.0€'" ! {
                m.invoke().toString === "5kg Apples for 1.0€"
              }
        }
    } ^ task(5)("butterMilkAndApples", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() ^
              "must be '5kg Apples & Butter & Milk for 2.94€'" ! {
                m.invoke().toString === "5kg Apples & Butter & Milk for 2.94€"
              }
        }
    }
}

