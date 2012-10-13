package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F32 extends Solution {

    /**
     * Aufgabe #1
     *
     */


    // ===============================================================

    /**
     * Aufgabe #2
     */

    def ?[T](test: => Boolean, fnThen: => T, fnElse: => T) =
        if (test)
            fnThen
        else
            fnElse

    def print2Digits(i: Int) {
        ?(i < 10, print("0" + i), print(i.toString))
    }
}