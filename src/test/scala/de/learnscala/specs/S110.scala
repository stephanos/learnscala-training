package de.learnscala.specs

import de.learnscala.uebungen.U110._
import de.learnscala.base.BaseTest

class S110 extends BaseTest {

    spec("U110", enabled) {

        "Point" >> {
            "must create instance for coordinates (5,5)" >> {
                val p = p1
                p.x === 5
                p.y === 5
            }
            "must create instance with coordinates (5,5) for parameter '5'" >> {
                val p = p2
                p.x === 5
                p.y === 5
            }
            "object must return count '2'" >> {
                Point.getCount === 2
            }
        }
    }
}