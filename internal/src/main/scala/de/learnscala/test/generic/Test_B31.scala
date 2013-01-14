package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_B31[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("printAd", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(5) ^
              mustReturn("Hi, my name is Martin. I'm 42 years old, weighing 80 kg at 1.80 meters. My hobbies are Scala and soccer.",
                "Martin", 42, 1.8f, 80, List("Scala", "soccer"))
        }
    } ^ task(2)("list123", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List(1, 2, 3))
        }
    } ^ task(3)("list123", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(List(1, 2, 3))
        }
    }
}

