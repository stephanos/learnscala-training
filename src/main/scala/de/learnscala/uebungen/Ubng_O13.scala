package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_O13 extends Exercise with Help /* with Disabled */ {

    def s60 = new Seconds(60)

    /**
     * 60 Sekunden konvertiert zu 1 Minute
     */
    def m1 = TODO

    /**
     * 120 Sekunden konvertiert zu 2 Minuten
     */
    def s120 = TODO
}

class Seconds(val v: Int)

object Seconds {

    def convert(m: Minutes) =
        new Seconds(m.v * 60)
}


class Minutes(val v: Int)

object Minutes {

    def convert(s: Seconds) =
        new Minutes(s.v / 60)
}