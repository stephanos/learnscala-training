package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_list extends Exercise with Help /* with Disabled */ {

  task(1) {

    /**
     * Methoden:
     *
     *  'weekDays':     Liste aus den deutschen Wochentagen
     *  'weekendDays':  Liste aus den deutschen Wochenendtagen
     *  'days':         Liste aller Tage der Woche
     */

    def weekDays = Nil
    def weekendDays = Nil
    def days = Nil

  }

  // ===============================================================

  task(2) {

    /**
     * Methode 'lastElem'
     *
     * @param l eine Liste aus natürlichen Zahlen
     * @return das letzte Element einer Liste, None falls nicht vorhanden
     *
     * @note Pattern Matching!
     */

    def lastElem(l: List[Int]) =
      FILL_IN_BODY_HERE

  }

  // ===============================================================

  task(3) {

    /**
     * BONUS!
     *
     * Methode 'thirdElem'
     *
     * @param l eine Liste aus natürlichen Zahlen
     * @return das dritte Element der Liste, None falls nicht vorhanden
     *
     * @note Pattern Matching!
     *
     */

    def thirdElem(l: List[Int]) =
      FILL_IN_BODY_HERE

  }
}