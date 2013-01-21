package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._
import java.io.{IOException, File, FileReader}

abstract class Test_F30[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("count", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(classOf[Int]) {
              "must print numbers from 1 to 9" ! {
                captureOutput(m.invoke(10))._2.trim === "1 2 3 4 5 6 7 8 9"
              }
            }
        }
    } ^ task(2)("convertToInt", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(classOf[String]) {
              """must convert "42" to Some(42)""" ! {
                m.invoke("42") === Some(42)
              } ^ """must convert "abc" to None""" ! {
                m.invoke("abc") === None
              }
            }
        }
    } ^ task(3)("readFile", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            val f = new File(this.getClass().getResource("/hello.txt").toURI)
            mustHaveParams(classOf[File]) {
              "must read file content 'hello.txt'" ! {
                m.invoke(f) === Some("Hello World!")
              } ^ "must handle read file error" ! {
                val mf = spy(f)
                mf.length throws new RuntimeException("read error")
                m.invoke(mf) === None
              }
            }
        }
    } ^ task(4)("printTime", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(classOf[Int], classOf[Int]) {
              "must print '13:37' for hour = 13 & min = 37" ! {
                captureOutput(m.invoke(13,37))._2 === "13:37"
              } ^
              "must print '00:00' for hour = 0 & min = 0" ! {
                captureOutput(m.invoke(0, 0))._2 === "00:00"
              }
            }
        }
    }
}