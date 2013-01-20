package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F21[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("toString", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn("[1,2,3]", Traversable(1, 2, 3))
        }
    } ^ task(2)("join", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(2) ^
              mustReturn(List(1, 2, 3, 4), List(1, 2), List(3, 4))
        }
    } ^ task(3)("first2", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn(List(1, 2), List(1, 2, 3, 4))
        }
    } ^ task(4)("sumOf", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn(6, List(1, 2, 3))
        }
    } ^ task(5)("length", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn(3, List(1, 2, 3))
        }
    } ^ task(6)("withoutFirst", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn(List(2, 3), List(1, 2, 3))
        }
    } ^ task(7)("biggest", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn(3, List(1, 2, 3))
        }
    } ^ task(8)("makeList", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(3) ^
              mustReturn(List(1, 2, 3), 1, 2, 3)
        }
    } ^ task(9)("unique", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn(List(1, 2, 3), List(1, 2, 2, 3, 3))
        }
    } ^ task(10)("backwards", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn(List(3, 2, 1), List(1, 2, 3))
        }
    } ^ task(11)("has42and101", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn(true, Set(1, 42, 101))  ^
              mustReturn(false, Set(1, 42)) ^
              mustReturn(false, Set(1, 101))
        }
    } ^ task(12)("mergeSet", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(2) ^
              mustReturn(Set(1, 2, 3, 4), Set(1, 2), Set(3, 4))
        }
    } ^ task(13)("withoutKey42", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn(Map(101 -> false), Map(42 -> true, 101 -> false))
        }
    } ^ task(14)("hasKey42", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn(true, Map(42 -> true, 101 -> false)) ^
              mustReturn(false,  Map(43 -> true, 101 -> false))
        }
    } ^ task(15)("allKeys", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn(Set(42, 101), Map(42 -> true, 101 -> false))
        }
    }
}