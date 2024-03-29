package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_control_a extends Exercise with Help /* with Disabled */ {

  /**
   * ANLEITUNG
   *
   * 1) Test ausführen
   * 2) Fehler beseitigen
   * 3) zurück zu Schritt 1
   *
   **/


  // ===============================================================

  task(1) {

    /**
     * Methode 'theAnswerToLifeTheUniverseAndEverything'
     *
     * @return 42
     */

    def theAnswerToLifeTheUniverseAndEverything =
      21

  }

  // ===============================================================

  task(2) {

    /**
     * Methode 'signum' (Vorzeichenfunktion)
     *
     * @param n ganze Zahl
     * @return 1, 0 or -1
     * @example signum(-5) = -1
     */

    def signum(n: Int) = {
      FILL_IN_BODY_HERE
    }

  }

  // ===============================================================

  task(3) {

    /**
     * Methode 'absMax'
     *
     * @param n1 erste ganze Zahl
     * @param n2 zweite ganze Zahl
     * @return die Zahl mit dem größten absoluten Wert
     * @example absMax(-5, 2) = -5
     *
     * @note Math.abs(-5) = 5
     */

    def absMax(n1: Int, n2: Int) =
      FILL_IN_BODY_HERE

  }


  // ===============================================================

  task(4) {

    /**
     * Methode 'countingOut'
     *
     * @note printet die Zahlen von 1 bis 10, getrennt durch Leerzeichen
     * @example 1 2 3 4 5 6 7 8 9 10
     */

    def countingOut() {
      FILL_IN_BODY_HERE
    }

  }

  // ===============================================================

  task(5) {

    /**
     * Methode 'count10s'
     *
     * @note printet die Zahlen von 10 bis 100 in 10er-Schritten, getrennt durch Leerzeichen
     * @example 10 20 30 40 50 60 70 80 90 100
     */

    def count10s() {
      FILL_IN_BODY_HERE
    }

  }

  // ===============================================================

  task(6) {

    /**
     * Methode 'countMod'
     *
     * @param mod Int
     * @note printet die Zahlen von 1 bis 10, die ganzzahlig durch den Parameter 'mod' teilbar sind,
     *       getrennt durch Leerzeichen
     **/

    def countMod(mod: Int) {
      FILL_IN_BODY_HERE
    }

  }

}