package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F11[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("negate", "method") {
      implicit ctx =>
        mustHaveMethod("f1") {
          implicit m =>
            mustHaveParams() ^
              "f1 must be '-5.0'" ! {
                m.invoke() === -5.0f
              }
        }
    } ^ task(2)("half", "method") {
      implicit ctx =>
        mustHaveMethod("f2") {
          implicit m =>
            mustHaveParams() ^
              "f2 must be '1.0'" ! {
                m.invoke() === 1.0
              }
        }
    } ^ task(3)("printReverse", "method") {
      implicit ctx =>

        mustHaveMethod("f3") {
          implicit m =>
            mustHaveParams() ^
              "f3 must output 'cba'" ! {
                m.invoke() === "cba"
              }
        }
    } ^ task(4)("repeat", "method") {
      implicit ctx =>

        mustHaveMethod("f4") {
          implicit m =>
            mustHaveParams() ^
              "f4 must be '123123123'" ! {
                m.invoke() === "123123123"
              }
        }
    }
}