package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O24[T: TypeTag] extends BaseTest[T] {

}

