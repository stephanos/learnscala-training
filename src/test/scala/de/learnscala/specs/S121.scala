package de.learnscala.specs

import de.learnscala.uebungen.U121._
import de.learnscala.base.BaseTest
import de.learnscala.uebungen._

class S121 extends BaseTest {

    spec("U121", enabled) {

        "convert" >> {
            "'m1' must be 1 Minute" >> {
                checkType[Minutes](m1, "m1") {
                    _.v === 1
                }
            }

            "'s120' must be 120 Seconds" >> {
                checkType[Seconds](s120, "s120") {
                    _.v === 120
                }
            }
        }

        1 === 1
    }
}