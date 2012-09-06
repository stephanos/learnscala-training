package de.learnscala.solutions.old

import de.learnscala.base.Solution

object L313 extends Solution {

    /**
     * Benötigt wird die Bedingsungsfunktion '?'.
     */
    def ?[T](test: => Boolean, fnThen: => T, fnElse: => T) =
        if (test)
            fnThen
        else
            fnElse

    def print2Digits(i: Int) {
        //?(Condition, then, else)
        ?(i < 10, print("0" + i), print(i.toString))
    }

}
