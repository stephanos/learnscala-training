package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F33[T: TypeTag] extends BaseTest[T]() {

}