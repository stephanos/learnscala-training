package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_F32 extends Exercise with Help /* with Disabled */ {


    task(1) {

        /**
         * Gesucht wird eine Funktion 'until' die bewirkt, dass der Rückgabewert '10' ist.
         */

        def incr = {
            var i = 0
            /*
            until(i == 10) {
                i += 1
            }
            */
            i
        }
    }

    // ===============================================================

    task(2) {

        /**
         * Benötigt wird die Bedingsungsfunktion '?'.
         */

        def print2Digits(i: Int) {
            /*
            ?(i < 10) {
              print("0" + i)
            } {
              print(i)
            }
            */
        }
    }
}