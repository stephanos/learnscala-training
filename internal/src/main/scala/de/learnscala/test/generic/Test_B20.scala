package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_B20[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    test()("r1", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "result must be '1/2'" ! {
                Option(m.invoke()).map(_.toString).getOrElse("<missing>").aka("Bruch") must beEqualTo("1/2")
              }
            }
        }
    } ^ test()("r2", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "result must be '1/4'" ! {
                Option(m.invoke()).map(_.toString).getOrElse("<missing>").aka("Bruch") must beEqualTo("1/4")
              }
            }
        }
    } ^ test()("r3", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "result must be '1/4'" ! {
                Option(m.invoke()).map(_.toString).getOrElse("<missing>").aka("Bruch") must beEqualTo("1/4")
              }
            }
        }
    } ^ test()("r4", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "result must be '7/12'" ! {
                Option(m.invoke()).map(_.toString).getOrElse("<missing>").aka("Bruch") must beEqualTo("7/12")
              }
            }
        }
    } ^ test()("r5", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "result must be '2/1'" ! {
                Option(m.invoke()).map(_.toString).getOrElse("<missing>").aka("Bruch") must beEqualTo("2/1")
              }
            }
        }
    }
}

