//package de.learnscala.test.specs
//
//import de.learnscala.test.uebungen.U313._
//import de.learnscala.test.base.BaseTest
//
//class S313 extends BaseTest {
//
//    spec("U313", enabled) {
//
//        "print2Digits" >> {
//            "must print '10' for 10" >> {
//                val (r, out) = captureOutput(print2Digits(10))
//                out.trim === "10"
//            }
//            "must print '05' for 5" >> {
//                val (r, out) = captureOutput(print2Digits(5))
//                out.trim === "05"
//            }
//        }
//    }
//}