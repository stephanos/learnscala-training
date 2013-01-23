package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_data_b extends Exercise with Help /* with Disabled */ {

  task(1) {

    /**
     * Aufgabe #1
     *
     * Antwortet ob das Auto gekauft werden soll - abhängig vom Argument.
     */

    def doYouBuyTheCar(b: Option[Boolean]) =
      FILL_IN_BODY_HERE
  }

  // ===============================================================

  task(2) {

    /**
     * Aufgabe #2
     *
     * Konvertiert einen String in einen Integer (None bei Ausnahme).
     */

    def convertToInt(s: String) =
      FILL_IN_BODY_HERE
  }

  // ===============================================================

  task(3) {

    /**
     * Aufgabe #3
     *
     * Addiert den linken mit dem rechten numerischen Wert (falls vorhanden).
     */

    def addLeftAndRight(left: Option[Long], right: Option[Long]) =
      FILL_IN_BODY_HERE
  }
}