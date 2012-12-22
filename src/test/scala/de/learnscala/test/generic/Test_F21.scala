package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F21[T: TypeTag] extends BaseTest[T] {

    test("toString", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, 1)

                    mn + " must return '[1,2,3]' for (1,2,3)" ! {
                        invoke(target, m, List(1, 2, 3)) === "[1,2,3]"
                    }
            }
    }

    test("join", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, 2)

                    mn + " must return '(1,2,3,4)' for (1,2) and (3,4)" ! {
                        invoke(target, m, List(1, 2), List(3, 4)) === List(1, 2, 3, 4)
                    }
            }
    }

    test("first2", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, 1)

                    mn + " must return '(1,2)' for (1,2,3,4)" ! {
                        invoke(target, m, List(1, 2, 3, 4)) === List(1, 2)
                    }
            }
    }

    test("sumOf", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, 1)

                    mn + " must return '6' for (1,2,3)" ! {
                        invoke(target, m, List(1, 2, 3)) === 6
                    }
            }
    }

    test("withoutFirst", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, 1)

                    mn + " must return '(2, 3)' for (1,2,3)" ! {
                        invoke(target, m, List(1, 2, 3)) === List(2, 3)
                    }
            }
    }

    test("biggest", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, 1)

                    mn + " must return '3' for (1,2,3)" ! {
                        invoke(target, m, List(1, 2, 3)) === 3
                    }
            }
    }

    /////////////////////////////////////////////////////////
    // List

    test("makeList", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, 3)

                    mn + " must return (1,2,3) for 1, 2 and 3" ! {
                        invoke(target, m, 1, 2, 3) === List(1, 2, 3)
                    }
            }
    }

    test("unique", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, 1)

                    mn + " must return (1,2,3) for (1,2,2,3,3)" ! {
                        invoke(target, m, List(1, 2, 2, 3, 3)) === List(1, 2, 3)
                    }
            }
    }

    test("backwards", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, 1)

                    mn + " must return (3,2,1) for (1,2,3)" ! {
                        invoke(target, m, List(1, 2, 3)) === List(3, 2, 1)
                    }
            }
    }

    /////////////////////////////////////////////////////////
    // Set

    test("has42and101", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, 1)

                    mn + " must return 'true' for (1,42,101)" ! {
                        invoke(target, m, Set(1, 42, 101)) === true
                    }
                    mn + " must return 'false' for (1,42)" ! {
                        invoke(target, m, Set(1, 42)) === false
                    }
                    mn + " must return false' for (1,101)" ! {
                        invoke(target, m, Set(1, 101)) === false
                    }
            }
    }

    test("mergeSet", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, 2)

                    mn + " must return (1,2,3,4) for (1,2) and (3,4)" ! {
                        invoke(target, m, Set(1, 2), Set(3, 4)) === Set(1, 2, 3, 4)
                    }
            }
    }

    /////////////////////////////////////////////////////////
    // Map

    test("withoutKey42", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, 1)

                    mn + " must return '(101 -> false)' for (42 -> true, 101 -> false)" ! {
                        invoke(target, m, Map(42 -> true, 101 -> false)) === Map(101 -> false)
                    }
            }
    }

    test("hasKey42", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m, 1)

                    mn + " must return 'true' for (42 -> true, 101 -> false)" ! {
                        invoke(target, m, Map(42 -> true, 101 -> false)) === true
                    }
                    mn + " must return 'false' for (43 -> true, 101 -> false)" ! {
                        invoke(target, m, Map(43 -> true, 101 -> false)) === false
                    }
            }
    }
}