package de.learnscala.loesungen

import de.learnscala.base.Uebung

object L010 {

    /**
     * 1.
     * Wenn DIE Antwort '42' gegeben wird, bestätige sie mit einem 'true'.
     */
    def isTheAnswerToLifeTheUniverseAndEverything(n: Int): Boolean =
        if (n == 42) true else false


    /**
     * 2.
     * Signum einer positiven Zahl ist 1, einer negativen -1 und von Null 0.
     */
    def signum(n: Int): Int =
        if (n == 0) 0
        else {
            if (n > 0) 1 else -1
        }


    /**
     * 3.
     * Es wird die Zahl von 2 Argumenten gesucht, die absolut den größten Wert hat.
     */
    def absMax(n1: Int, n2: Int): Int =
        if (Math.abs(n1) > Math.abs(n2)) n1 else n2
}