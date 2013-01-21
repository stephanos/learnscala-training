package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_data_a[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("Task #1") {
      implicit ctx =>
        mustReturnMethod("r1", true) ^
          mustReturnMethod("r2", true) ^
          mustReturnMethod("r3", true) ^
          mustReturnMethod("r4", true) ^
          mustReturnMethod("r5", true) ^
          mustReturnMethod("r6", true)
    } ^ task(2)("Seasons") {
      implicit ctx =>
        mustReturnMethod("t1", 0)
        mustReturnMethod("t2", 1)
        mustReturnMethod("t3", 3)
        mustReturnMethod("t4", "Herbst")
    } ^ task(3)("Quiz #2") {
      implicit ctx =>
        mustReturnMethod("r1", true) ^
          mustReturnMethod("r2", true) ^
          mustReturnMethod("r3", true)
    } ^ task(4)("swap", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn((1, 5), (5, 1)) ^
              mustReturn((1, 1), (1, 1))
        }
    } ^ task(5)("charWithCode", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn((97 -> 'a'), 'a') ^
              mustReturn((122 -> 'z'), 'z')
        }
    } ^ task(6)("sum", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturn(5, (true, 2, 3)) ^
              mustReturn(2, (true, 1, 1)) ^
              mustReturn(-1, (false, 2, 3)) ^
              mustReturn(1, (false, 9, 8))
        }
    }
}