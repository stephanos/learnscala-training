package de.learnscala.specs

import de.learnscala.uebungen.U210._
import de.learnscala.base.BaseTest

class S210 extends BaseTest {

    spec("U210", enabled) {

        "p1" >> {
            "must return swap" >> {
                val _p1 = p1.swap
                p1.t == _p1.s
                p1.s == _p1.t
            }
            "must have same types" >> {
                p1.bothHaveSameType == true
            }
        }

        "p2" >> {
            "must return swap" >> {
                val _p2 = p2.swap
                p2.t == _p2.s
                p2.s == _p2.t
            }
            "must have same types" >> {
                p2.bothHaveSameType == true
            }
        }

        "p3" >> {
            "must return swap" >> {
                val _p3 = p3.swap
                p3.t == _p3.s
                p3.s == _p3.t
            }
            "must have same types" >> {
                p3.bothHaveSameType == true
            }
        }

        "p4" >> {
            "must return swap" >> {
                val _p4 = p4.swap
                p4.t == _p4.s
                p4.s == _p4.t
            }
            "must have same types" >> {
                p4.bothHaveSameType == false
            }
        }
    }
}