package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_data1_a[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("swap", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(classOf[Tuple2[Int, Int]]) {
              "must return (5,1) for (1,5)" ! {
                m.invoke((5, 1)) ===(1, 5)
              } ^
              "must return (1,1) for (1,1)" ! {
                m.invoke((1, 1)) ===(1, 1)
              }
            }
        }
    } ^ task(2)("sum", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(classOf[Tuple3[Boolean, Int, Int]]) {
              "must return 5 for (true,2,3)" ! {
                m.invoke((true, 2, 3)) === 5
              } ^
              "must return 2 for (true,1,1)" ! {
                m.invoke((true, 1, 1)) === 2
              } ^
              "must return -1 for (true,2,3)" ! {
                m.invoke((false, 2, 3)) === -1
              } ^
              "must return 1 for (true,9,8)" ! {
                m.invoke((false, 9, 8)) === 1
              }
            }
        }
    }
}