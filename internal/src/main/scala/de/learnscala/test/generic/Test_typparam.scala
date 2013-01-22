package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_typparam[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    test(1)("p1", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturnAsString("(1, 1)")
        }
    } ^ test(2)("p2", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturnAsString("(true, false)")
        }
    } ^ test(3)("p3", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturnAsString("(Bob, Babe)")
        }
    } ^ test(4)("p4", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustReturnAsString("(male, true)")
        }
    }

  /*
    "p1" ! {
      checkType[Pair](p1, "p1", enabled) {
        item =>
          "must return swap" ! {
            val _item = item.swap
            item.t == _item.s
            item.s == _item.t
          }
          "must have same types" ! {
            item.bothHaveSameType == true
          }
      }
    } ^ "p2" ! {
      checkType[Pair](p2, "p2", enabled) {
        item =>
          "must return swap" ! {
            val _item = item.swap
            item.t == _item.s
            item.s == _item.t
          }
          "must have same types" ! {
            item.bothHaveSameType == true
          }
      }
    } ^ "p3" ! {
      checkType[Pair](p3, "p3", enabled) {
        item =>
          "must return swap" ! {
            val _item = item.swap
            item.t == _item.s
            item.s == _item.t
          }
          "must have same types" ! {
            item.bothHaveSameType == true
          }
      }
    } ^ "p4" ! {
      checkType[Pair](p4, "p4", enabled) {
        item =>
          "must return swap" ! {
            val _item = item.swap
            item.t == _item.s
            item.s == _item.t
          }
          "must have same types" ! {
            item.bothHaveSameType == false
          }
      }
    }
}
*/

}

