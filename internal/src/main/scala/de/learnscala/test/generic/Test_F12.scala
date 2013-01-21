package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._
import org.specs2.execute.{Pending, Result}

abstract class Test_F12[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("union", "method") {
      implicit ctx =>
        mustHaveMethod("u1") {
          implicit m =>
            mustHaveParams() {
              "u1 must contain '1'" ! {
                tryOrPending {
                  m.invoke() === true
                }
              }
            }
        } ^ mustHaveMethod("u2") {
          implicit m =>
            mustHaveParams() {
              "u2 must contain '2'" ! {
                tryOrPending {
                  m.invoke() === true
                }
              }
            }
        } ^ mustHaveMethod("u3") {
          implicit m =>
            mustHaveParams() {
              "u3 must NOT contain '3'" ! {
                tryOrPending {
                  m.invoke() === false
                }
              }
            }
        }
    } ^ task(2)("intersect", "method") {
      implicit ctx =>
        mustHaveMethod("i1") {
          implicit m =>
            mustHaveParams() {
              "i1 must contain '1'" ! {
                tryOrPending {
                  m.invoke() === true
                }
              }
            }
        } ^ mustHaveMethod("i2") {
          implicit m =>
            mustHaveParams() {
              "i2 must NOT contain '2'" ! {
                tryOrPending {
                  m.invoke() === false
                }
              }
            }
        } ^mustHaveMethod("i3") {
          implicit m =>
            mustHaveParams() {
              "i3 must NOT contain '3'" ! {
                tryOrPending {
                  m.invoke() === false
                }
              }
            }
        }
    } ^ task(3)("intersect", "method") {
      implicit ctx =>
        mustHaveMethod("d1") {
          implicit m =>
            mustHaveParams() {
              "d1 must NOT contain '1'" ! {
                tryOrPending {
                  m.invoke() === false
                }
              }
            }
        } ^ mustHaveMethod("d2") {
          implicit m =>
            mustHaveParams() {
              "d2 must contain '2'" ! {
                tryOrPending {
                  m.invoke() === true
                }
              }
            }
        } ^ mustHaveMethod("d3") {
          implicit m =>
            mustHaveParams() {
              "d3 must NOT contain '3'" ! {
                tryOrPending {
                  m.invoke() === false
                }
              }
            }
        }
    }

  private def tryOrPending(fn: => Result) = {
    try {
      fn
    } catch {
      case th: Throwable =>
        println(th.getCause)
        th.getCause match {
          case e: NotImplementedError =>
            Pending()
          case _ =>
            throw th
        }
    }
  }
}