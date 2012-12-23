package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

class Test_B14_2[T: TypeTag] extends BaseTest[T] {

    import java.io._

    override def is =
        task2(1)("nameOfSymbol", "method") {
            implicit ctx =>
                mustHaveMethod2 {
                    implicit m =>
                        mustHaveParams2(classOf[Char]) ^
                            mustReturn("pi", 'Π') ^
                            mustReturn("root", '√') ^
                            mustReturn("factorial", '!') ^
                            mustReturn("sum", '∑') ^
                            mustReturn("unknown", '?')
                }
        } ^ p ^
            task2(2)("isWorkingDay", "method") {
                implicit ctx =>
                    mustHaveMethod2 {
                        implicit m =>
                            mustHaveParams2(classOf[String]) ^
                                mustReturn(false, "Sunday") ^
                                mustReturn(false, "Saturday") ^
                                mustReturn(true, "Monday") ^
                                mustReturn(true, "Tuesday") ^
                                mustReturn(true, "Wednesday") ^
                                mustReturn(true, "Thursday") ^
                                mustReturn(true, "Friday")
                    }
            } ^ p ^
            task2(3)("describeValue", "method") {
                implicit ctx =>
                    mustHaveMethod2 {
                        implicit m =>
                            mustHaveParams2(classOf[Any]) ^
                                mustReturn("empty string", "") ^
                                mustReturn("string of size 11", "Hello World") ^
                                mustReturn("positive integer", 5) ^
                                mustReturn("negative integer", -5) ^
                                mustReturn("unknown", true) ^
                                mustReturn("unknown", 5.0f) ^
                                mustReturn("unknown", '$')
                    }
            } ^ p ^
            task2(4)("half", "method") {
                implicit ctx =>
                    mustHaveMethod2 {
                        implicit m =>
                            mustHaveParams2(classOf[Int]) ^
                                mustReturn(5, 10) ^
                                mustReturn(50, 100) ^
                                mustReturn(-5, -10) ^
                                mustThrow[Throwable](3) ^
                                mustThrow[Throwable](5)
                    }
            } ^ p ^
            task2(5)("getSize", "method") {
                implicit ctx =>
                    mustHaveMethod2 {
                        implicit m =>
                            mustHaveParams2(classOf[Char]) ^
                                mustReturn(3, "abc") ^
                                mustReturn(5, "12345") ^
                                mustReturn(0, "") ^
                                mustReturn(0, null)
                    }
            } ^ p ^
            task2(6)("readCharFromFile", "method") {
                implicit ctx =>
                    mustHaveMethod2 {
                        implicit m =>
                            mustHaveParams2(classOf[FileReader]) ^
                                "must return '@' and close connection" ! {
                                    val f = getMock
                                    m.invoke(f) === '@'
                                    there was one(f).close()
                                } ^
                                "must print 'not found' if 'FileNotFoundException' is thrown, close connection and return 0" ! {
                                    val f = getMock
                                    f.read() throws new FileNotFoundException()
                                    val (r, out) = captureOutput(m.invoke(f))
                                    r.getOrElse(null) === 0
                                    out.trim === "not found"
                                    there was one(f).close()
                                } ^
                                "must print 'cannot read' if 'IOException' is thrown, close connection and return 0" ! {
                                    val f = getMock
                                    f.read() throws new IOException()
                                    val (r, out) = captureOutput(m.invoke(f))
                                    r.getOrElse(null) === 0
                                    out.trim === "cannot read"
                                    there was one(f).close()
                                } ^
                                "must print 'unknown error' if 'RuntimeException' is thrown; and return 0" ! {
                                    val f = getMock
                                    f.read() throws new RuntimeException()
                                    val (r, out) = captureOutput(m.invoke(f))
                                    r.getOrElse(null) === 0
                                    out.trim === "unknown error"
                                    there was one(f).close()
                                }
                    }
            } ^ end

    private def getMock = {
        val m = mock[FileReader]
        m.read() returns '@'
        m.ready() returns true
        m
    }
}