package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O24[T: TypeTag] extends BaseTest[T] {

    //        "p1" >> {
    //            checkType[Pair](p1, "p1", enabled) {
    //                item =>
    //                    "must return swap" >> {
    //                        val _item = item.swap
    //                        item.t == _item.s
    //                        item.s == _item.t
    //                    }
    //                    "must have same types" >> {
    //                        item.bothHaveSameType == true
    //                    }
    //            }
    //        }
    //
    //        "p2" >> {
    //            checkType[Pair](p2, "p2", enabled) {
    //                item =>
    //                    "must return swap" >> {
    //                        val _item = item.swap
    //                        item.t == _item.s
    //                        item.s == _item.t
    //                    }
    //                    "must have same types" >> {
    //                        item.bothHaveSameType == true
    //                    }
    //            }
    //        }
    //
    //        "p3" >> {
    //            checkType[Pair](p3, "p3", enabled) {
    //                item =>
    //                    "must return swap" >> {
    //                        val _item = item.swap
    //                        item.t == _item.s
    //                        item.s == _item.t
    //                    }
    //                    "must have same types" >> {
    //                        item.bothHaveSameType == true
    //                    }
    //            }
    //        }
    //
    //        "p4" >> {
    //            checkType[Pair](p4, "p4", enabled) {
    //                item =>
    //                    "must return swap" >> {
    //                        val _item = item.swap
    //                        item.t == _item.s
    //                        item.s == _item.t
    //                    }
    //                    "must have same types" >> {
    //                        item.bothHaveSameType == false
    //                    }
    //            }
    //        }
    //    }
}

