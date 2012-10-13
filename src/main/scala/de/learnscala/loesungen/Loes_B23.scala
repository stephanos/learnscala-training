package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_B23 extends Solution {

    implicit def MyInt(i: Int) = new {
        def +%(p: Int): Int =
            math.floor(i + (i / 100.0 * p)).toInt

        def -%(p: Int): Int =
            math.floor(i - (i / 100.0 * p)).toInt
    }


    // ===============================================================

    /**
     * Aufgabe #1
     */
    def plus50p = 150 +% 50


    // ===============================================================

    /**
     * Aufgabe #2
     */
    def minus50p = 150 -% 50
}