package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_B14_1 extends Solution {

    /**
     * Aufgabe #1
     */
    def theAnswerToLifeTheUniverseAndEverything =
        42

    // ===============================================================

    /**
     * Aufgabe #2
     */
    def signum(n: Int) =
        if (n == 0)
            0
        else {
            if (n > 0) 1 else -1
        }

    // ===============================================================

    /**
     * Aufgabe #3
     */
    def absMax(n1: Int, n2: Int) =
        if (Math.abs(n1) > Math.abs(n2)) n1 else n2

    // ===============================================================

    /**
     * Aufgabe #4
     *
     * Zählt von 1 bis 10, gibt Zahlen durch Leerzeichen getrennt aus.
     */
    def countingOut() {
        for (i <- 1 to 10)
            print(i + " ")
    }

    // ===============================================================

    /**
     * Aufgabe #5
     *
     * Zählt von 10 bis 100, gibt Zahlen durch Leerzeichen getrennt aus.
     */
    def count10s() {
        for (i <- 10 to 100 by 10)
            print(i + " ")
    }

    // ===============================================================

    /**
     * Aufgabe #6
     *
     * Zählt Zahlen von 1 bis 10;
     * gibt Zahlen, die ganzzahlig durch Parameter teilbar sind, durch Leerzeichen getrennt aus.
     */
    def countMod(mod: Int) {
        for (i <- 1 to 10)
            if (i % mod == 0) print(i + " ")
    }
}