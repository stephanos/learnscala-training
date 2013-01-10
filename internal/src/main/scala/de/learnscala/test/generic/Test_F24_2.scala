package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F24_2[T: TypeTag] extends BaseTest[T] {

    val forbiddenMethods = List("map", "filter", "flatMap")


}