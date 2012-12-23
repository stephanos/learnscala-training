package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_B14_1 extends Solution {

    task(1) {

        def theAnswerToLifeTheUniverseAndEverything =
            42
    }

    // ===============================================================

    task(2) {

        def signum(n: Int) =
            if (n == 0)
                0
            else {
                if (n > 0) 1 else -1
            }
    }

    // ===============================================================

    task(3) {

        def absMax(n1: Int, n2: Int) =
            if (Math.abs(n1) > Math.abs(n2)) n1 else n2
    }

    // ===============================================================

    task(4) {

        def countingOut() {
            for (i <- 1 to 10)
                print(i + " ")
        }
    }

    // ===============================================================

    task(5) {

        def count10s() {
            for (i <- 1 to 10 by 10)
                print(i + " ")
        }
    }

    // ===============================================================

    task(6) {

        def countMod(mod: Int) {
            for (i <- 1 to 10)
                if (i % mod == 0) print(i + " ")
        }
    }
}