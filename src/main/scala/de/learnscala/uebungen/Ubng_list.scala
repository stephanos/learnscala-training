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

    def weekDays = List()
    def weekendDays = List()
    def days = weekDays ::: weekendDays

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

    TODO

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
     */

    TODO

  }
}