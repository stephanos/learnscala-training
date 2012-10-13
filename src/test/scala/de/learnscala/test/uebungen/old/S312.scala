//package de.learnscala.test.specs
//
//import de.learnscala.test.uebungen.U312._
//import de.learnscala.test.base.BaseTest
//
//class S312 extends BaseTest {
//
//    spec("U312", enabled) {
//
//        "shout must print '#SCALA#'" >> {
//            captureOutput(shout())._2.trim === "#SCALA#"
//        }
//
//        "google must print '[http://google.com]'" >> {
//            captureOutput(google())._2.trim === "[http://google.com]"
//        }
//    }
//}