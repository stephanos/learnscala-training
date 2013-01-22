package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_control_b[T: TypeTag] extends BaseTest[T]() {

  import java.io._

  override def fs =
    task(1)("nameOfSymbol", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(classOf[Char]) {
              mustNotContain(VAR) ^
              mustReturn("pi", 'Π') ^
              mustReturn("root", '√') ^
              mustReturn("factorial", '!') ^
              mustReturn("sum", '∑') ^
              mustReturn("unknown", '?')
            }
        }
    } ^ task(2)("isWorkingDay", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(classOf[String]) {
              mustNotContain(VAR) ^
              mustReturn(false, "Sunday") ^
              mustReturn(false, "Saturday") ^
              mustReturn(true, "Monday") ^
              mustReturn(true, "Tuesday") ^
              mustReturn(true, "Wednesday") ^
              mustReturn(true, "Thursday") ^
              mustReturn(true, "Friday") ^
              mustNotBeLongerThan(5)
            }
        }
    } ^ task(3)("describeValue", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(classOf[Any]) {
              mustNotContain(VAR) ^
              mustReturn("empty string", "") ^
              mustReturn("string of size 11", "Hello World") ^
              mustReturn("positive integer", 5) ^
              mustReturn("negative integer", -5) ^
              mustReturn("unknown: $", '$')
              mustReturn("unknown: false", false)
            }
        }
    } ^ task(4)("half", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(classOf[Int]) {
              mustNotContain(VAR) ^
              mustReturn(5, 10) ^
              mustReturn(50, 100) ^
              mustReturn(-5, -10) ^
              mustThrow[Throwable](3) ^
              mustThrow[Throwable](1337)
            }
        }
    } ^ task(5)("getSize", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(classOf[Char]) {
              mustNotContain(VAR) ^
              mustReturn(3, "abc") ^
              mustReturn(5, "12345") ^
              mustReturn(0, "") ^
              mustReturn(0, null)
            }
        }
    } ^ task(6)("readCharFromFile", "method") {
      implicit ctx => // TODO: does not really check anything :(  !
        mustHaveMethod {
          implicit m =>
            mustHaveParams(classOf[FileReader]) {
              mustNotContain(VAR) ^
              "must return '@' and close connection" ! {
                val f = getMock
                m.invoke(f) === '@'
                there was one(f).close()
              } ^
              "must print 'not found' for 'FileNotFoundException', close connection and return 0" ! {
                val f = getMock
                f.read() throws new FileNotFoundException()
                val (r, out) = captureOutput(m.invoke(f))
                r.getOrElse(null) === 0
                out.trim === "not found"
                there was one(f).close()
              } ^
              "must print 'cannot read' for 'IOException', close connection and return 0" ! {
                val f = getMock
                f.read() throws new IOException()
                val (r, out) = captureOutput(m.invoke(f))
                r.getOrElse(null) === 0
                out.trim === "cannot read"
                there was one(f).close()
              } ^
              "must print 'unknown error' for 'RuntimeException', close connection and return 0" ! {
                val f = getMock
                f.read() throws new RuntimeException()
                val (r, out) = captureOutput(m.invoke(f))
                r.getOrElse(null) === 0
                out.trim === "unknown error"
                there was one(f).close()
              }
            }
        }
    }

  private def getMock = {
    val m = mock[FileReader]
    m.read() returns '@'
    m.ready() returns true
    m
  }
}