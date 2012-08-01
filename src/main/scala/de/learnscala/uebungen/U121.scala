package de.learnscala.uebungen

import de.learnscala.base.Uebung

object U121 extends Uebung(enabled = true) {

    import Seconds.{convert => convertToSeconds}
    import Minutes.{convert => convertToMinutes}

    def s60 = new Seconds(60)

    def m1 = convertToMinutes(s60)
    def s120 = convertToSeconds(new Minutes(2))
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