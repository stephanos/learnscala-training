package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_B14_2[T: TypeTag] extends BaseTest[T] {

    task(1)("nameOfSymbol", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, classOf[Char])

                    "must be 'Unbekannt' for value '?'" >> {
                        invoke(target, m, '?') === "Unbekannt"
                    }
                    "must be 'Kreiszahl' for value 'Π'" >> {
                        invoke(target, m, 'Π') === "Kreiszahl"
                    }
                    "must be 'Wurzel' for value '√'" >> {
                        invoke(target, m, '√') === "Wurzel"
                    }
                    "must be 'Fakultät' for value '!'" >> {
                        invoke(target, m, '!') === "Fakultät"
                    }
                    "must be 'Summe' for value '∑'" >> {
                        invoke(target, m, '∑') === "Summe"
                    }
            }
    }

    task(2)("isWorkingDay", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, classOf[String])

                    "must be 'false' for value 'Sunday'" >> {
                        invoke(target, m, "Sunday") === false
                    }
                    "must be 'false' for value 'Saturay'" >> {
                        invoke(target, m, "Saturay") === false
                    }
                    "must be 'true' for value 'Monday'" >> {
                        invoke(target, m, "Monday") === true
                    }
                    "must be 'true' for value 'Tuesday'" >> {
                        invoke(target, m, "Tuesday") === true
                    }
                    "must be 'true' for value 'Wednesday'" >> {
                        invoke(target, m, "Wednesday") === true
                    }
                    "must be 'true' for value 'Thursday'" >> {
                        invoke(target, m, "Thursday") === true
                    }
                    "must be 'true' for value 'Friday'" >> {
                        invoke(target, m, "Friday") === false
                    }
            }
    }

    task(3)("nameOfType", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, classOf[Any])

                    "must be 'Boolean' for value true" >> {
                        invoke(target, m, true) === "Boolean"
                    }
                    "must be 'Char' for value 'c'" >> {
                        invoke(target, m, 'c') === "Char"
                    }
                    "must be 'Int' for value 42" >> {
                        invoke(target, m, 42) === "Int"
                    }
                    "must be 'Float' for value 3.14f" >> {
                        invoke(target, m, 3.14f) === "Float"
                    }
                    "must be 'String' for value \"String\"" >> {
                        invoke(target, m, "String") === "String"
                    }
                    "must be 'Unbekannt' for value 1000L" >> {
                        invoke(target, m, 1000L) === "Unbekannt"
                    }
                    "must be 'Unbekannt' for value 1000.0" >> {
                        invoke(target, m, 1000.0) === "Unbekannt"
                    }
            }
    }

    task(4)("half", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, classOf[Int])

                    "must calculate half of 10" >> {
                        invoke(target, m, 10) === 5
                    }
                    "must calculate half of 100" >> {
                        invoke(target, m, 100) === 50
                    }
                    "must calculate half of -10" >> {
                        invoke(target, m, -10) === -5
                    }
                    "must throw Exception for 3" >> {
                        invoke(target, m, 3) must throwA[Throwable]
                    }
                    "must throw Exception for 5" >> {
                        invoke(target, m, 5) must throwA[Throwable]
                    }
            }
    }

    task(5)("getSize", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, classOf[Char])

                    "must return 'a' for 'abc'" >> {
                        invoke(target, m, "abc") === 'a'
                    }
                    "must return '1' for '123'" >> {
                        invoke(target, m, "123") === '1'
                    }
                    "must return '' for ''" >> {
                        invoke(target, m, "") === ' '
                    }
                    "must return '' for null" >> {
                        invoke(target, m, null) === ' '
                    }
            }
    }

    import java.io._

    task(5)("readCharFromFile", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, classOf[FileReader])

                    "must return '@' for '1' and close connection" >> {
                        val f = getMock
                        invoke(target, m, f) === '@'
                        there was one(f).close()
                    }
                    "must print 'not found' if 'FileNotFoundException' is thrown, close connection and return 0" >> {
                        val f = getMock
                        f.read() throws new FileNotFoundException()
                        val (r, out) = captureOutput(invoke(target, m, f))
                        r.getOrElse(null) === 0
                        out.trim === "not found"
                        there was one(f).close()
                    }
                    "must print 'cannot read' if 'IOException' is thrown, close connection and return 0" >> {
                        val f = getMock
                        f.read() throws new IOException()
                        val (r, out) = captureOutput(invoke(target, m, f))
                        r.getOrElse(null) === 0
                        out.trim === "cannot read"
                        there was one(f).close()
                    }
                    "must print 'unknown error' if 'RuntimeException' is thrown; and return 0" >> {
                        val f = getMock
                        f.read() throws new RuntimeException()
                        val (r, out) = captureOutput(invoke(target, m, f))
                        r.getOrElse(null) === 0
                        out.trim === "unknown error"
                        there was one(f).close()
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