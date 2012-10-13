package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_O10 extends Solution {

    /**
     * Aufgabe #1
     **/
    class Time(val hours: Int = 0, val min: Int = 0) {

        def addMin(_m: Int) =
            this.add(new Time(0, _m))

        def addHours(_h: Int) =
            this.add(new Time(_h, 0))

        def add(t: Time) = {
            val mm = t.min + min
            val hh = t.hours + hours
            val _m = mm % 60
            val _h = hh % 24 + (mm / 60)
            new Time(if (_h == 24) 0 else _h, if (_m == 60) 0 else _m)
        }

        def print =
            hours + ":" + (if (min < 10) "0" else "") + min

        override def toString =
            print
    }


    /**
     * Zeit um 13:37.
     */
    def t1 = new Time(13, 37)

    /**
     * Zeit um 20:00.
     */
    def t2 = new Time(20)

    /**
     * Zeit um 0:00.
     */
    def t3 = new Time()

    /**
     * Zeit um 12:00 plus 2 Stunden
     */
    def t4 = new Time(12, 00).addHours(2)

    /**
     * Zeit um 23:59 plus 2 Minuten
     */
    def t5 = new Time(23, 59).addMin(2)

    /**
     * Zeit um 12:23 plus 13:37
     */
    def t6 = new Time(12, 23).add(new Time(13, 37))
}