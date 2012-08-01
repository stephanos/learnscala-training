package de.learnscala.uebungen

import de.learnscala.base.Uebung

object U410 extends Uebung(enabled = true) {

    implicit def MyInt(i: Int) = new {
        def +%(p: Int): Int =
            math.floor(i + (i / 100.0 * p)).toInt

        def -%(p: Int): Int =
            math.floor(i - (i / 100.0 * p)).toInt
    }


    /**
     * Die Zahl '150' wird um 50% erhöht
     */
    val plus50p = 150 +% 50


    /**
     * Die Zahl '150' wird um 50% verringert
     */
    val minus50p = 150 -% 50
}