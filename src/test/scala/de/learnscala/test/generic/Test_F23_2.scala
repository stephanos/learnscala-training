package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F23_2[T: TypeTag] extends BaseTest[T] {

    task(1)("sum", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>


                    "must return '6' for (1,2,3)" >> {
                        invoke(target, m, List(1, 2, 3)) === 6
                    }
                    "must return '0' for ()" >> {
                        invoke(target, m, List()) === 0
                    }
            }
    }

    task(2)("product", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>


                    "must return '6' for (1,2,3)" >> {
                        invoke(target, m, List(1, 2, 3)) === 6
                    }
                    "must return '27' for (3,3,3)" >> {
                        invoke(target, m, List(3, 3, 3)) === 27
                    }
                    "must return '1' for ()" >> {
                        invoke(target, m, List()) === 1
                    }
            }
    }

    task(3)("count", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>


                    "must return '3' for (1,2,3)" >> {
                        invoke(target, m, List(1, 2, 3)) === 3
                    }
                    "must return '0' for ()" >> {
                        invoke(target, m, List()) === 0
                    }
            }
    }

    task(4)("last", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>


                    "must return 'Some(3)' for (1,2,3)" >> {
                        invoke(target, m, List(1, 2, 3)) === Some(3)
                    }
                    "must return 'None' for ()" >> {
                        invoke(target, m, List()) === None
                    }
            }
    }

    task(5)("reverse", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>


                    "must return '(3,2,1)' for (1,2,3)" >> {
                        invoke(target, m, List(1, 2, 3)) === List(3, 2, 1)
                    }
                    "must return '()' for ()" >> {
                        invoke(target, m, List()) === List()
                    }
            }
    }

    task(6)("contains", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>


                    "must return 'true' for (1,2,3) and 3" >> {
                        invoke(target, m, List(1, 2, 3), 3) === true
                    }
                    "must return 'true' for (1,2,3) and 9" >> {
                        invoke(target, m, List(1, 2, 3), 9) === false
                    }
                    "must return 'false' for () and 3" >> {
                        invoke(target, m, List[Int](), 3) === false
                    }
            }
    }

    task(7)("map", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>


                    "must return '(2,4,6)' for (1,2,3)" >> {
                        invoke(target, m, List(1, 2, 3), (i: Int) => i * 2) === List(2, 4, 6)
                    }
                    "must return '()' for ()" >> {
                        invoke(target, m, List[Int](), (i: Int) => i * 2) === List()
                    }
            }
    }

    task(8)("filter", "method") {
        (mn, target) =>

            mustHaveMethod(mn) {
                m =>


                    "must return even numbers from (1,2,3,4)" >> {
                        invoke(target, m, List(1, 2, 3, 4), (i: Int) => i % 2 == 0) === List(2, 4)
                    }
                    "must return even numbers from (1,3,5)" >> {
                        invoke(target, m, List(1, 3, 5), (i: Int) => i % 2 == 0) === List()
                    }
                    "must return '()' for ()" >> {
                        invoke(target, m, List[Int](), (i: Int) => i % 2 == 0) === List()
                    }
            }
    }
}