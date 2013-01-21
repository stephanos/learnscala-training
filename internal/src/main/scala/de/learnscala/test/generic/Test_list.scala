package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_list[T: TypeTag] extends BaseTest[T]() {

  override def fs =
    task(1)("Quiz") {
      implicit ctx =>
        mustReturnMethod("r1", true) ^
          mustReturnMethod("r2", true) ^
          mustReturnMethod("r3", true) ^
          mustReturnMethod("r4", true) ^
          mustReturnMethod("r5", true) ^
          mustReturnMethod("r6", true) ^
          mustReturnMethod("r7", true) ^
          mustReturnMethod("r8", true)
    } ^ task(2)("days of the week") {
      implicit ctx =>
        mustHaveMethod("weekDays", true) {
          implicit m =>
            mustReturnList() {
              ls =>
                "must contain the 5 German days of the week" ! {
                  ls must containAllOf(Seq("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag"))
                }
            }
        } ^ mustHaveMethod("weekendDays", true) {
          implicit m =>
            mustReturnList() {
              ls =>
                "must contain the 2 German days of the weekend" ! {
                  ls.toSeq must containAllOf(Seq("Sonntag", "Samstag"))
                }
            }
        } ^ mustHaveMethod("days", true) {
          implicit m =>
            mustReturnList() {
              ls =>
                "must contain all 7 German days of the week" ! {
                  ls.toSeq must containAllOf(Seq("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Sonntag", "Samstag"))
                }
            }
        }
    } ^ task(3)("lastElem", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) {
              mustReturn(Some(1), List(1)) ^
                mustReturn(Some(3), List(1, 2, 3)) ^
                mustReturn(Some(5), List(1, 2, 3, 4, 5)) ^
                mustReturn(None, List())
            }
        }
    } ^ task(4)("thirdElem", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) {
              mustReturn(Some(3), List(1, 2, 3)) ^
                mustReturn(Some(3), List(1, 2, 3, 4, 5)) ^
                mustReturn(None, List(1, 2)) ^
                mustReturn(None, List(1)) ^
                mustReturn(None, List())
            }
        }
    }


  //
  //        "palindrome" ! {
  //            "must return 'false' for List(1,2,3)" ! {
  //                palindrome(List(1, 2, 3)) === false
  //            }
  //            "must return 'false' for List(1,2,1,2)" ! {
  //                palindrome(List(1, 2, 1, 2)) === false
  //            }
  //            "must return 'true' for List(1,2,1)" ! {
  //                palindrome(List(1, 2, 1)) === true
  //            }
  //            "must return 'true' for List(1)" ! {
  //                palindrome(List(1)) === true
  //            }
  //            "must return 'true' for List(1,2,3,2,1)" ! {
  //                palindrome(List(1, 2, 3, 2, 1)) === true
  //            }
  //            "must return 'true' for List()" ! {
  //                palindrome(List()) === true
  //            }
  //        }
}