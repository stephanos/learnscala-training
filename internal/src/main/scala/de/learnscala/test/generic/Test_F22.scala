package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F22[T: TypeTag] extends BaseTest[T]() {


  override def fs =
    task(1)("Quiz") {
      implicit ctx =>
        mustHaveMethod("r1", true) {
          implicit m =>
            m.invoke() must beTrue
        } ^ mustHaveMethod("r2", true) {
          implicit m =>
            m.invoke() must beTrue
        } ^ mustHaveMethod("r3", true) {
          implicit m =>
            m.invoke() must beTrue
        } ^ mustHaveMethod("r4", true) {
          implicit m =>
            m.invoke() must beTrue
        } ^ mustHaveMethod("r5", true) {
          implicit m =>
            m.invoke() must beTrue
        } ^ mustHaveMethod("r6", true) {
          implicit m =>
            m.invoke() must beTrue
        } ^ mustHaveMethod("r7", true) {
          implicit m =>
            m.invoke() must beTrue
        } ^ mustHaveMethod("r8", true) {
          implicit m =>
            m.invoke() must beTrue
        }
    } ^ task(2)("days of the week") {
      implicit ctx =>
        mustHaveMethod("weekDays", true) {
          implicit m =>
            withList(m.invoke()) {
              ls =>
                ls must containAllOf(Seq("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag"))
            }
        } ^ mustHaveMethod("weekendDays", true) {
          implicit m =>
            withList(m.invoke()) {
              ls =>
                ls must containAllOf(Seq("Sonntag", "Samstag"))
            }
        } ^ mustHaveMethod("days", true) {
          implicit m =>
            withList(m.invoke()) {
              ls =>
                ls must containAllOf(Seq("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Sonntag", "Samstag"))
            }
        }
    } ^ task(3)("lastElem", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn(Some(1), List(1)) ^
              mustReturn(Some(3), List(1, 2, 3)) ^
              mustReturn(Some(5), List(1, 2, 3, 4, 5)) ^
              mustReturn(None, List())
        }
    } ^ task(4)("thirdElem", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) ^
              mustReturn(Some(3), List(1, 2, 3)) ^
              mustReturn(Some(3), List(1, 2, 3, 4, 5)) ^
              mustReturn(None, List(1, 2)) ^
              mustReturn(None, List(1)) ^
              mustReturn(None, List())
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