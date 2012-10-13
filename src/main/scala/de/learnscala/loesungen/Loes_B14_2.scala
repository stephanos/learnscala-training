package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_B14_2 extends Solution {

    /**
     * Aufgabe #1
     *
     * Zählt von 1 bis 10, gibt Zahlen durch Leerzeichen getrennt aus.
     */
    def countingOut() {
        for (i <- 1 to 10)
            print(i + " ")
    }

    // ===============================================================

    /**
     * Aufgabe #2
     *
     * Zählt von 10 bis 100, gibt Zahlen durch Leerzeichen getrennt aus.
     */
    def count10s() {
        for (i <- 10 to 100 by 10)
            print(i + " ")
    }

    // ===============================================================

    /**
     * Aufgabe #3
     *
     * Zählt Zahlen von 1 bis 10;
     * gibt Zahlen, die ganzzahlig durch Parameter teilbar sind, durch Leerzeichen getrennt aus.
     */
    def countMod(mod: Int) {
        for (i <- 1 to 10)
            if (i % mod == 0) print(i + " ")
    }
}