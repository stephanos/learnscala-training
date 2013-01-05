package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F21[T: TypeTag] extends BaseTest[T] {

    override def fs =
        task(1)("toString", "method") {
            implicit ctx =>
                mustHaveMethod {
                    implicit m =>
                        mustHaveParams(1)
                        m.name + " must return '[1,2,3]' for (1,2,3)" ! {
                            m.invoke(List(1, 2, 3)) === "[1,2,3]"
                        }
                }
        } ^
            task(2)("join", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            mustHaveParams(2) ^
                                m.name + " must return '(1,2,3,4)' for (1,2) and (3,4)" ! {
                                    m.invoke(List(1, 2), List(3, 4)) === List(1, 2, 3, 4)
                                }
                    }
            } ^
            task(3)("first2", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            mustHaveParams(1) ^
                                m.name + " must return '(1,2)' for (1,2,3,4)" ! {
                                    m.invoke(List(1, 2, 3, 4)) === List(1, 2)
                                }
                    }
            } ^
            task(4)("sumOf", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            mustHaveParams(1) ^
                                m.name + " must return '6' for (1,2,3)" ! {
                                    m.invoke(List(1, 2, 3)) === 6
                                }
                    }
            } ^
            task(5)("withoutFirst", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            mustHaveParams(1) ^
                                m.name + " must return '(2, 3)' for (1,2,3)" ! {
                                    m.invoke(List(1, 2, 3)) === List(2, 3)
                                }
                    }
            } ^
            task(6)("biggest", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            mustHaveParams(1) ^
                                m.name + " must return '3' for (1,2,3)" ! {
                                    m.invoke(List(1, 2, 3)) === 3
                                }
                    }
            } ^
            task(7)("makeList", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            mustHaveParams(3) ^
                                m.name + " must return (1,2,3) for 1, 2 and 3" ! {
                                    m.invoke(1, 2, 3) === List(1, 2, 3)
                                }
                    }
            } ^
            task(8)("unique", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            mustHaveParams(1) ^
                                m.name + " must return (1,2,3) for (1,2,2,3,3)" ! {
                                    m.invoke(List(1, 2, 2, 3, 3)) === List(1, 2, 3)
                                }
                    }
            } ^
            task(9)("backwards", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            mustHaveParams(1) ^
                                m.name + " must return (3,2,1) for (1,2,3)" ! {
                                    m.invoke(List(1, 2, 3)) === List(3, 2, 1)
                                }
                    }
            } ^
            task(10)("has42and101", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            mustHaveParams(1) ^
                                m.name + " must return 'true' for (1,42,101)" ! {
                                    m.invoke(Set(1, 42, 101)) === true
                                } ^
                                m.name + " must return 'false' for (1,42)" ! {
                                    m.invoke(Set(1, 42)) === false
                                } ^
                                m.name + " must return false' for (1,101)" ! {
                                    m.invoke(Set(1, 101)) === false
                                }
                    }
            } ^
            task(11)("mergeSet", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            mustHaveParams(2) ^
                                m.name + " must return (1,2,3,4) for (1,2) and (3,4)" ! {
                                    m.invoke(Set(1, 2), Set(3, 4)) === Set(1, 2, 3, 4)
                                }
                    }
            } ^
            task(12)("withoutKey42", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            mustHaveParams(1) ^
                                m.name + " must return '(101 -> false)' for (42 -> true, 101 -> false)" ! {
                                    m.invoke(Map(42 -> true, 101 -> false)) === Map(101 -> false)
                                }
                    }
            } ^
            task(13)("hasKey42", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            mustHaveParams(1) ^
                                m.name + " must return 'true' for (42 -> true, 101 -> false)" ! {
                                    m.invoke(Map(42 -> true, 101 -> false)) === true
                                } ^
                                m.name + " must return 'false' for (43 -> true, 101 -> false)" ! {
                                    m.invoke(Map(43 -> true, 101 -> false)) === false
                                }
                    }
            }
}