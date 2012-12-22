package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

class Test_B14_2[T: TypeTag] extends BaseTest[T] {

    import java.io._

    override def is =
        (task2(1)("nameOfSymbol", "method") {
            implicit ctx =>
                mustHaveMethod2 {
                    m =>
                    //mustHaveParams(m, classOf[Char])

                        "must be 'Unbekannt' for value '?'" ! {
                            m.invoke('?') === "Unbekannt"
                        } ^
                            "must be 'Kreiszahl' for value 'Π'" ! {
                                m.invoke('Π') === "Kreiszahl"
                            } ^
                            "must be 'Wurzel' for value '√'" ! {
                                m.invoke('√') === "Wurzel"
                            } ^
                            "must be 'Fakultät' for value '!'" ! {
                                m.invoke('!') === "Fakultät"
                            } ^
                            "must be 'Summe' for value '∑'" ! {
                                m.invoke('∑') === "Summe"
                            }
                }
        }) ^ (task2(2)("isWorkingDay", "method") {
            implicit ctx =>
                mustHaveMethod2 {
                    m =>
                    //mustHaveParams(m, classOf[String])

                        "must be 'false' for value 'Sunday'" ! {
                            m.invoke("Sunday") === false
                        } ^
                            "must be 'false' for value 'Saturday'" ! {
                                m.invoke("Saturday") === false
                            } ^
                            "must be 'true' for value 'Monday'" ! {
                                m.invoke("Monday") === true
                            } ^
                            "must be 'true' for value 'Tuesday'" ! {
                                m.invoke("Tuesday") === true
                            } ^
                            "must be 'true' for value 'Wednesday'" ! {
                                m.invoke("Wednesday") === true
                            } ^
                            "must be 'true' for value 'Thursday'" ! {
                                m.invoke("Thursday") === true
                            } ^
                            "must be 'true' for value 'Friday'" ! {
                                m.invoke("Friday") === true
                            }
                }
        }) ^ task2(3)("nameOfType", "method") {
            implicit ctx =>
                mustHaveMethod2 {
                    m =>
                    //mustHaveParams(m, classOf[Any])

                        "must work for empty String" ! {
                            m.invoke("") === "leerer String"
                        } ^
                            "must work for non-empty String" ! {
                                m.invoke("Hello World") === "String mit der Länge 11"
                            } ^
                            "must work for positiver integer" ! {
                                m.invoke(5) === "ein positiver Integer"
                            } ^
                            "must work for negative integer" ! {
                                m.invoke(-5) === "ein negativer Integer"
                            } ^
                            "must work for aynthing else" ! {
                                m.invoke(true) === "Unbekannt"
                                m.invoke(5.0f) === "Unbekannt"
                                m.invoke('$') === "Unbekannt"
                            }
                }
        } ^ task2(4)("half", "method") {
            implicit ctx =>
                mustHaveMethod2 {
                    m =>
                    //mustHaveParams(m, classOf[Int])

                        "must calculate half of 10" ! {
                            m.invoke(10) === 5
                        } ^
                            "must calculate half of 100" ! {
                                m.invoke(100) === 50
                            } ^
                            "must calculate half of -10" ! {
                                m.invoke(-10) === -5
                            } ^
                            "must throw Exception for 3" ! {
                                m.invoke(3) must throwA[Throwable]
                            } ^
                            "must throw Exception for 5" ! {
                                m.invoke(5) must throwA[Throwable]
                            }
                }
        } ^ task2(5)("getSize", "method") {
            implicit ctx =>
                mustHaveMethod2 {
                    m =>
                    //mustHaveParams(m, classOf[Char])

                        "must return '3' for 'abc'" ! {
                            m.invoke("abc") === 3
                        } ^
                            "must return '5' for '12345'" ! {
                                m.invoke("12345") === 5
                            } ^
                            "must return '0' for empty String" ! {
                                m.invoke("") === 0
                            } ^
                            "must return '0' for null" ! {
                                m.invoke(null) === 0
                            }
                }
        } ^ task2(5)("readCharFromFile", "method") {
            implicit ctx =>
                mustHaveMethod2 {
                    m =>
                    //mustHaveParams(m, classOf[FileReader])

                        "must return '@' for '1' and close connection" ! {
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
        }

    private def getMock = {
        val m = mock[FileReader]
        m.read() returns '@'
        m.ready() returns true
        m
    }
}