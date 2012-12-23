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
                    //mustHaveParams(m, classOf[Char])

                        mustReturn("pi", "Π") ^
                            mustReturn("root", "√") ^
                            mustReturn("factorial", "!") ^
                            mustReturn("sum", "∑") ^
                            mustReturn("unknown", "?")
                }
        } ^ p ^
            task2(2)("isWorkingDay", "method") {
                implicit ctx =>
                    mustHaveMethod2 {
                        implicit m =>
                        //mustHaveParams(m, classOf[String])

                            mustReturn(false, "Sunday") ^
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
            } ^ p ^
            task2(3)("describeValue", "method") {
                implicit ctx =>
                    mustHaveMethod2 {
                        m =>
                        //mustHaveParams(m, classOf[Any])

                            "must work for empty String" ! {
                                m.invoke("") === "empty string"
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
            } ^ p ^
            task2(4)("half", "method") {
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
            } ^ p ^
            task2(5)("getSize", "method") {
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
            } ^ p ^
            task2(6)("readCharFromFile", "method") {
                implicit ctx =>
                    mustHaveMethod2 {
                        m =>
                        //mustHaveParams(m, classOf[FileReader])

                            println("Ifs: " + ctx.task._noOfIfs)
                            println("Trys: " + ctx.task._noOfTrys)
                            println("Vals: " + ctx.task._noOfVals)
                            println("Vars: " + ctx.task._noOfVars)
                            println("Defs: " + ctx.task._noOfDefs)
                            println("Rets: " + ctx.task._noOfReturns)
                            println("Fors " + ctx.task._noOfFors)
                            println("Lines: " + ctx.task._noOfLines)
                            println("Nulls: " + ctx.task._noOfNulls)
                            println("Whiles: " + ctx.task._noOfWhiles)
                            println("Annots: " + ctx.task._listOfAnnot)
                            println("Finallys: " + ctx.task._noOfFinallys)
                            println("Classes: " + ctx.task._listOfCalls)

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

    println(is)

    private def getMock = {
        val m = mock[FileReader]
        m.read() returns '@'
        m.ready() returns true
        m
    }
}