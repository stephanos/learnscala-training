package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F22[T: TypeTag] extends BaseTest[T] {

    /*
    "Task #1: days" ! {

        test("weekDays") {
            implicit ctx =>
                mustHaveMethod {
                  implicit m =>
                        mustHaveParams() ^

                        getList(target, m) {
                            l =>
                                "must contain all (work) week days" ! {
                                    val ls = l.toString()
                                    ls must contain("Montag")
                                    ls must contain("Dienstag")
                                    ls must contain("Mittwoch")
                                    ls must contain("Donnerstag")
                                    ls must contain("Freitag")
                                }
                        }
                }
        }

        test("weekendDays") {
            implicit ctx =>
                mustHaveMethod {
                  implicit m =>
                        mustHaveParams() ^

                        getList(target, m) {
                            l =>
                                "must contain all weekend days" ! {
                                    val ls = l.toString()
                                    ls must contain("Sonntag")
                                    ls must contain("Samstag")
                                }
                        }
                }
        }

        test("days") {
            implicit ctx =>
                mustHaveMethod {
                  implicit m =>
                        mustHaveParams() ^

                        getList(target, m) {
                            l =>
                                "must contain all days of the week" ! {
                                    val ls = l.toString()
                                    ls must contain("Montag")
                                    ls must contain("Dienstag")
                                    ls must contain("Mittwoch")
                                    ls must contain("Donnerstag")
                                    ls must contain("Freitag")
                                    ls must contain("Sonntag")
                                    ls must contain("Samstag")
                                }
                        }
                }
        }
    }
    */

    task(2)("last") {
        implicit ctx =>
            mustHaveMethod {
              implicit m =>
                    mustHaveParams(1)

                    "must return 'Some(1)' for List(1)" ! {
                        m.invoke( List(1)) === Some(1)
                    }
                    "must return 'Some(3)' for List(1,2,3)" ! {
                        m.invoke( List(1, 2, 3)) === Some(3)
                    }
                    "must return 'Some(5)' for List(1,2,3,4,5)" ! {
                        m.invoke( List(1, 2, 3, 4, 5)) === Some(5)
                    }
                    "must return 'None' for List()" ! {
                        m.invoke( List()) === None
                    }
            }
    }

    task(3)("third") {
        implicit ctx =>
            mustHaveMethod {
              implicit m =>
                    mustHaveParams(1)

                    "must return 'Some(3)' for List(1,2,3)" ! {
                        invoke(target, m,List(1, 2, 3)) === Some(3)
                   }
                   "must return 'Some(3)' for List(1,2,3,4,5)" ! {
                       invoke(target, m,List(1, 2, 3, 4, 5)) === Some(3)
                   }
                   "must return 'None' for List(1,2)" ! {
                       invoke(target, m,List(1, 2)) === None
                   }
                   "must return 'None' for List(1)" ! {
                       invoke(target, m,List(1)) === None
                   }
                   "must return 'None' for List()" ! {
                       invoke(target, m,List()) === None
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