package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F20_2[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(3)("doYouBuyTheCar", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(classOf[Option[Boolean]]) ^
              "must print 'yes' for Some(true)" ! {
                captureOutput(m.invoke(Some(true)))._2.trim === "yes"
              } ^
              "must print 'no' for Some(false)" ! {
                captureOutput(m.invoke(Some(false)))._2.trim === "no"
              } ^
              "must print 'not sure' for None" ! {
                captureOutput(m.invoke(None))._2.trim === "not sure"
              }
        }
    } ^ task(4)("convertToInt", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(classOf[String]) ^
              "must return 'Some(5)' for '5'" ! {
                m.invoke("5") === Some(5)
              } ^
              "must return 'Some(-5)' for '-5'" ! {
                m.invoke("-5") === Some(-5)
              } ^
              "must return 'None' for 'a'" ! {
                m.invoke("a") === None
              }
        }
    }
}