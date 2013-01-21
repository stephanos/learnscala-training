package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_list extends Exercise with Help /* with Disabled */ {

  task(1) {

    /**
     * Bewältigen Sie das Quiz:
     * Ersetzen Sie den rechten Teil des Vergleichs mit dem entsprechenden Ergebnis!
     */

    //def r1 =
    //  "Hello" :: List("World") == List(TODO)

    def r2 =
      ("Hello" :: "World" :: Nil).mkString("", " ", "!") == TODO

    def r3 =
      Nil.size == TODO

    def r4 =
      Nil.::(4).::(3).::(2).::(1) == TODO

    def r5 =
      List().headOption == TODO

    def r6 =
      List(1, 2, 3).tail == TODO

    def r7 =
      List('a', 'b', 'c').head == TODO

    def r8 =
      List("1" :: "2" :: Nil, "3") == TODO
  }

  // ===============================================================

  task(2) {

    /**
     * Methoden:
     *
     *  'weekDays':     Liste aus den deutschen Wochentagen
     *  'weekendDays':  Liste aus den deutschen Wochenendtagen
     *  'days':         Liste aller Tage der Woche
     */

    def weekDays = List()
    def weekendDays = List()
    def days = weekDays ::: weekendDays

  }

  // ===============================================================

  task(3) {

    /**
     * Methode 'lastElem'
     *
     * @param l eine Liste aus natürlichen Zahlen
     * @return das letzte Element einer Liste, None falls nicht vorhanden
     *
     * @note Pattern Matching!
     */

    TODO

  }

  // ===============================================================

  task(4) {

    /**
     * BONUS!
     *
     * Methode 'thirdElem'
     *
     * @param l eine Liste aus natürlichen Zahlen
     * @return das dritte Element der Liste, None falls nicht vorhanden
     *
     * @note Pattern Matching!
     */

    TODO

  }
}