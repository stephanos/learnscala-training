package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_func1 extends Exercise with Help /* with Disabled */ {

  task(1) {

    /**
     * Gesucht wird eine Funktion 'negate' zur Negierung einer Fließkommazahl.
     */

    // val negate =

    def t = MAKE_THIS_TEST_PASS // with this: negate(5.0f)

  }

  // ===============================================================

  task(2) {

    /**
     * Gesucht wird die Funktion 'half' zur Berechnung der Hälfte einer ganzen Zahl.
     */

    // val half =

    def t = MAKE_THIS_TEST_PASS // with this: half(2)

  }

  // ===============================================================

  task(3) {

    /**
     * Gesucht wird eine Funktion 'reverse' zur Umkehrung eines Strings.
     */

    def t = MAKE_THIS_TEST_PASS // with this: reverse("abc")

  }

  // ===============================================================

  task(4) {

    /**
     * Gesucht wird eine Funktion 'drive' die mitteilt, ob man fahren darf.
     *
     * @throws Wirft Ausnahme wenn die Ampel ausgefallen ist (=null)
     */

    var trafficLight: String = "red"

    def t1 = MAKE_THIS_TEST_PASS // with this: drive()

    def t2 = {
      trafficLight = "yellow"
      MAKE_THIS_TEST_PASS // with this: drive()
    }

    def t3 = {
      trafficLight = "green"
      MAKE_THIS_TEST_PASS // with this: drive()
    }

    def t4 = {
      trafficLight = null
      MAKE_THIS_TEST_PASS // with this: drive()
    }
  }

  // ===============================================================

  task(5) {

    /**
     * BONUS!
     *
     * Gesucht wird eine Funktion zur mehrmaligen Verkettung einer Zeichenkette.
     *
     * @note 1 Zeile genügt
     */

    def t = MAKE_THIS_TEST_PASS // with this: repeat("123", 3)

  }
}