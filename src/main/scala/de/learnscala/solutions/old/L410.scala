package de.learnscala.solutions.old

import de.learnscala.base.Solution

object L410 extends Solution {

    implicit def MyInt(i: Int) = new {
        def +%(p: Int): Int =
            math.floor(i + (i / 100.0 * p)).toInt

        def -%(p: Int): Int =
            math.floor(i - (i / 100.0 * p)).toInt
    }


    /**
     * Die Zahl '150' wird um 50% erhöht
     */
    def plus50p = 150 +% 50


    /**
     * Die Zahl '150' wird um 50% verringert
     */
    def minus50p = 150 -% 50
}