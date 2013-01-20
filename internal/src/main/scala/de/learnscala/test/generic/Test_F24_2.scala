package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F24_2[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("printAllTitles", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams()
        }
    }

}