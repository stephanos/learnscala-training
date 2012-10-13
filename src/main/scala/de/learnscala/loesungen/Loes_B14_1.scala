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
}