package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_B14_1 extends Solution {

    sys.error("test")

    /**
     * Task #1
     */
    def isTheAnswerToLifeTheUniverseAndEverything =
        42

    // ===============================================================

    /**
     * Task #2
     */
    def signum(n: Int) =
        if (n == 0)
            0
        else {
            if (n > 0) 1 else -1
        }

    // ===============================================================

    /**
     * Task #3
     */
    def absMax(n1: Int, n2: Int) =
        if (Math.abs(n1) > Math.abs(n2)) n1 else n2
}