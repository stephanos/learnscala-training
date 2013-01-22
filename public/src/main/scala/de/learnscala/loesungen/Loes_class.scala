package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_class extends Solution {

  task {

    class Time(val hours: Int = 0, val min: Int = 0) {

      require(min < 60)
      require(hours < 24)

      def addMin(m: Int): Time =
        add(new Time(0, m))

      def addHours(h: Int): Time =
        add(new Time(h, 0))

      def add(t: Time): Time = {
        val mm = t.min + min
        val hh = t.hours + hours
        val newM = mm % 60
        val newH = hh % 24 + (mm / 60)
        new Time(
          if (newH == 24) 0 else newH,
          if (newM == 60) 0 else newM
        )
      }

      override def toString =
        hours + ":" + (if (min < 10) "0" else "") + min
    }

    // ===============================================================
    // TESTS
    // ===============================================================

    def t1 = new Time(13, 37)

    def t2 = new Time(20)

    def t3 = new Time()

    def t4 = new Time(12, 0).addHours(2)

    def t5 = new Time(23, 59).addMin(2)

    def t6 = new Time(12, 23).add(new Time(13, 37))

    def t7 = new Time(99)
  }
}