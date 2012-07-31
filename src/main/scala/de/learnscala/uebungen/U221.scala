package de.learnscala.uebungen

import de.learnscala.base.Uebung

object U221 extends Uebung(enabled = true) {

    /* TODO: Tupel & Option mit Pattern match */

    def swap(t: (Int, Int)) =
        (t._2, t._1)

}