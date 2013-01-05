package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O10[T: TypeTag] extends BaseTest[T] {

    test("t1", "method") {
        implicit ctx =>
            mustHaveMethod {
                implicit m =>
                    mustHaveParams() ^ {
                        val t = m.invoke()
                        m.name + " must be '13:37'" ! {
                            t must not(beNull)
                            t.toString === "13:37"
                        }
                    }
            }
    } ^
        test("t2", "method") {
            implicit ctx =>
                mustHaveMethod {
                    implicit m =>
                        mustHaveParams() ^ {
                            val t = m.invoke()
                            m.name + " must be '20:00'" ! {
                                t must not(beNull)
                                t.toString === "20:00"
                            }
                        }
                }
        } ^
        test("t3", "method") {
            implicit ctx =>
                mustHaveMethod {
                    implicit m =>
                        mustHaveParams() ^ {
                            val t = m.invoke()
                            m.name + " must be '0:00'" ! {
                                t must not(beNull)
                                t.toString === "0:00"
                            }
                        }
                }
        }
    test("t4", "method") {
        implicit ctx =>
            mustHaveMethod {
                implicit m =>
                    mustHaveParams() ^ {
                        val t = m.invoke()
                        m.name + " must be '14:00'" ! {
                            t must not(beNull)
                            t.toString === "14:00"
                        }
                    }
            }
    } ^
        test("t5", "method") {
            implicit ctx =>
                mustHaveMethod {
                    implicit m =>
                        mustHaveParams() ^ {
                            val t = m.invoke()
                            m.name + " must be '0:01'" ! {
                                t must not(beNull)
                                t.toString === "0:01"
                            }
                        }
                }
        } ^
        test("t6", "method") {
            implicit ctx =>
                mustHaveMethod {
                    implicit m =>
                        mustHaveParams() ^ {
                            val t = m.invoke()
                            m.name + " must be '2:00'" ! {
                                t must not(beNull)
                                t.toString === "2:00"
                            }
                        }
                }
        }
}

