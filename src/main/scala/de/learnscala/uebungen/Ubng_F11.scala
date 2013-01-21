package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_F11 extends Exercise with Help /* with Disabled */ {

  task(1) {

    /**
     * Gesucht wird eine Funktion 'negate' zur Negierung einer Fließkommazahl.
     */

    // val negate =

    def t = TODO // negate(5.0f)

  }

  // ===============================================================

  task(2) {

    /**
     * Gesucht wird die Funktion 'half' zur Berechnung der Hälfte einer ganzen Zahl.
     */

    // val half =

    def t = TODO // half(2)

  }

  // ===============================================================

  task(3) {

    /**
     * Gesucht wird eine Funktion 'reverse' zur Umkehrung eines Strings.
     */

    def t = TODO // reverse("abc")

  }

  // ===============================================================

  task(4) {

    /**
     * Gesucht wird eine Funktion 'drive' die mitteilt, ob
     *
     * @throws Wirft Ausnahme wenn die Ampfel ausgefallen ist (=null)
     */

    var trafficLight: String = "red"

    def t1 = TODO // drive()

    def t2 = {
      trafficLight = "yellow"
      //drive()
    }

    def t3 = {
      trafficLight = "green"
      //drive()
    }

    def t4 = {
      trafficLight = null
      //drive()
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

    def t = TODO // repeat("123", 3)

  }
}