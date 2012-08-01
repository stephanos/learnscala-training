package de.learnscala.uebungen

import de.learnscala.base.Uebung

object U313 extends Uebung(enabled = true) {

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
