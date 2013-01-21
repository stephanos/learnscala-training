package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._
import java.util.Date

abstract class Test_B22[T: TypeTag] extends BaseTest[T]() {

  override def twoPass = false

  override def fs =
    task(1)("Bruch") {
      implicit ctx =>
        mustHaveMethod("r", true) {
          implicit m =>
            mustHaveParams() {
              "result must be '1/2'" ! {
                Option(m.invoke()).map(_.toString).getOrElse(null) === "1/2"
              }
            }
        }
    } ^ task(2)("+%") {
      implicit ctx =>
        mustHaveMethod("r", true) {
          implicit m =>
            mustHaveParams() {
              "operator must increase value of '150' by 50%" ! {
                m.invoke() === 225
              }
            }
        }
    } ^ task(3)("time") {
      implicit ctx =>
        mustHaveMethod("r", true) {
          implicit m =>
            mustHaveParams(classOf[String]) {
              "result for 'now' must be time of now" ! {
                setSecToZero(m.invoke("now")) must beEqualTo(nowMinusHours())
              } ^
              "result for 'yesterday' must be time of now minus 24 hours" ! {
                setSecToZero(m.invoke("yesterday")) must beEqualTo(nowMinusHours(24))
              } ^
              "result for '1 hour ago' must be time of now minus 1 hour" ! {
                setSecToZero(m.invoke("1 hour ago")) must beEqualTo(nowMinusHours(1))
              } ^
              "result for '24 hours ago' must be time of now minus 24 hours" ! {
                setSecToZero(m.invoke("24 hours ago")) must beEqualTo(nowMinusHours(24))
              }
            }
        }
    }

  def nowMinusHours(h: Int = 0) = {
    val now = new Date
    now.setTime(now.getTime - h * 60 * 60 * 1000)
    setSecToZero(now).toString
  }

  def setSecToZero(v: Any) = {
    v match {
      case d: Date =>
        d.setSeconds(0)
        d.toString
      case _ => v
    }
  }
}