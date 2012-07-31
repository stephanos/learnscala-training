package de.learnscala.uebungen

import de.learnscala.base.Uebung

object U030 extends Uebung(enabled = false) {

    /**
     * Bestätigt DIE Antwort '42' als richtig.
     */
    def isTheAnswerToLifeTheUniverseAndEverything(n: Int): Boolean =
        if(n == 42) true else false


    /**
     * Signum einer positiven Zahl ist 1, einer negativen -1 und von Null 0.
     */
    def signum(n: Int): Int =
        if(n == 0) 0
        else {
            if(n > 0) 1 else -1
        }


    /**
     * Es wird die Zahl von 2 Argumenten gesucht, die absolut den größten Wert hat.
     */
    def absMax(n1: Int, n2: Int): Int =
        if(Math.abs(n1) > Math.abs(n2)) n1 else n2
}