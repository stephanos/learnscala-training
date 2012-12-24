package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F23_2[T: TypeTag] extends BaseTest[T] {

    override def is =
        task(1)("sum", "method") {
            implicit ctx =>
                mustHaveMethod {
                    implicit m =>
                        "must return '6' for (1,2,3)" ! {
                            m.invoke(List(1, 2, 3)) === 6
                        } ^
                            "must return '0' for ()" ! {
                                m.invoke(List()) === 0
                            }
                }
        } ^
            task(2)("product", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            "must return '6' for (1,2,3)" ! {
                                m.invoke(List(1, 2, 3)) === 6
                            } ^
                                "must return '27' for (3,3,3)" ! {
                                    m.invoke(List(3, 3, 3)) === 27
                                } ^
                                "must return '1' for ()" ! {
                                    m.invoke(List()) === 1
                                }
                    }
            } ^
            task(3)("count", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            "must return '3' for (1,2,3)" ! {
                                m.invoke(List(1, 2, 3)) === 3
                            } ^
                                "must return '0' for ()" ! {
                                    m.invoke(List()) === 0
                                }
                    }
            } ^
            task(4)("last", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            "must return 'Some(3)' for (1,2,3)" ! {
                                m.invoke(List(1, 2, 3)) === Some(3)
                            } ^
                                "must return 'None' for ()" ! {
                                    m.invoke(List()) === None
                                }
                    }
            } ^
            task(5)("reverse", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            "must return '(3,2,1)' for (1,2,3)" ! {
                                m.invoke(List(1, 2, 3)) === List(3, 2, 1)
                            } ^
                                "must return '()' for ()" ! {
                                    m.invoke(List()) === List()
                                }
                    }
            } ^
            task(6)("contains", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            "must return 'true' for (1,2,3) and 3" ! {
                                m.invoke(List(1, 2, 3), 3) === true
                            } ^
                                "must return 'true' for (1,2,3) and 9" ! {
                                    m.invoke(List(1, 2, 3), 9) === false
                                } ^
                                "must return 'false' for () and 3" ! {
                                    m.invoke(List[Int](), 3) === false
                                }
                    }
            } ^
            task(7)("map", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            "must return '(2,4,6)' for (1,2,3)" ! {
                                m.invoke(List(1, 2, 3), (i: Int) => i * 2) === List(2, 4, 6)
                            } ^
                                "must return '()' for ()" ! {
                                    m.invoke(List[Int](), (i: Int) => i * 2) === List()
                                }
                    }
            } ^
            task(8)("filter", "method") {
                implicit ctx =>
                    mustHaveMethod {
                        implicit m =>
                            "must return even numbers from (1,2,3,4)" ! {
                                m.invoke(List(1, 2, 3, 4), (i: Int) => i % 2 == 0) === List(2, 4)
                            } ^
                                "must return even numbers from (1,3,5)" ! {
                                    m.invoke(List(1, 3, 5), (i: Int) => i % 2 == 0) === List()
                                } ^
                                "must return '()' for ()" ! {
                                    m.invoke(List[Int](), (i: Int) => i % 2 == 0) === List()
                                }
                    }
            }
}