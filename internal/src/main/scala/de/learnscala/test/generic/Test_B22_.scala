//package de.learnscala.test.generic
//
//import de.learnscala.test.base.BaseTest
//import scala.reflect.runtime.universe._
//
//abstract class Test_B22_[T: TypeTag] extends BaseTest[T] {
//
//  val clsName = "Bruch"
//
//  override def fs =
//    test(1)(clsName, "class") {
//      implicit ctx =>
//        mustHaveClass {
//          implicit c =>
//            1 === 1
//        }
//    } ^ test(2)("toString") {
//      implicit ctx =>
//        mustHaveMethod {
//          implicit m =>
//            mustHaveParams() ^
//              "must return '1/2'" ! {
//                Option(m.invoke()).map(_.toString).getOrElse("TODO") === "1/2"
//              }
//        }
//    } ^ test(3)("r2", "method") {
//      implicit ctx =>
//        mustHaveMethod {
//          implicit m =>
//            mustHaveParams() ^
//              "must return '1/4'" ! {
//                Option(m.invoke()).map(_.toString).getOrElse("TODO") === "1/4"
//              }
//        }
//    } ^ test(4)("r3", "method") {
//      implicit ctx =>
//        mustHaveMethod {
//          implicit m =>
//            mustHaveParams() ^
//              "must return '1/2'" ! {
//                Option(m.invoke()).map(_.toString).getOrElse("TODO") === "1/4"
//              }
//        }
//    } ^ test(5)("r4", "method") {
//      implicit ctx =>
//        mustHaveMethod {
//          implicit m =>
//            mustHaveParams() ^
//              "must return '7/12'" ! {
//                Option(m.invoke()).map(_.toString).getOrElse("TODO") === "7/12"
//              }
//        }
//    } ^ test(6)("r5", "method") {
//      implicit ctx =>
//        mustHaveMethod {
//          implicit m =>
//            mustHaveParams() ^
//              "must return '2/1'" ! {
//                Option(m.invoke()).map(_.toString).getOrElse("TODO") === "2/1"
//              }
//        }
//    }
//}
//
