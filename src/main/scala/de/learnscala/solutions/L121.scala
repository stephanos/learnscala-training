package de.learnscala.solutions

import de.learnscala.base.Solution

object L121 extends Solution {

    import Seconds.{convert => convertToSeconds}
    import Minutes.{convert => convertToMinutes}

    def s60 = new Seconds(60)

    /**
     * 60 Sekunden konvertiert zu 1 Minute
     */
    def m1 =
        convertToMinutes(s60)

    /**
     * 120 Sekunden konvertiert zu 2 Minuten
     */
    def s120 =
        convertToSeconds(new Minutes(2))
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