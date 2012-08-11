package de.learnscala.solutions

import de.learnscala.base.Solution

object L030 extends Solution {

    /**
     * Task #1
     */
    def isTheAnswerToLifeTheUniverseAndEverything(n: Int) =
        n == 42


    /**
     * Task #2
     */
    def signum(n: Int) =
        if (n == 0) 0
        else {
            if (n > 0) 1 else -1
        }


    /**
     * Task #3
     */
    def absMax(n1: Int, n2: Int) =
        if (Math.abs(n1) > Math.abs(n2)) n1 else n2
}