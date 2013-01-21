package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_func1[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("negate") {
      implicit ctx =>
        mustReturnMethod("t", -5.0f)
    } ^ task(2)("half") {
      implicit ctx =>
        mustReturnMethod("t", 1.0f)
    } ^ task(3)("printReverse") {
      implicit ctx =>
        mustReturnMethod("t", "cba")
    } ^ task(4)("drive") {
      implicit ctx =>
        mustReturnMethod("t1", false) ^
          mustReturnMethod("t2", true) ^
          mustReturnMethod("t3", true) ^
          mustThrowMethod[Exception]("t4")
    } ^ task(5)("repeat") {
      implicit ctx =>
        mustReturnMethod("t", "123123123")
    }
}