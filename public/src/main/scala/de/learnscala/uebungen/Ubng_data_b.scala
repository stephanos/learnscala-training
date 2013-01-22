package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_data_b extends Exercise with Help /* with Disabled */ {

  task(1) {

    /**
     * Antwortet (print) ob das Auto gekauft werden soll - abhängig vom Argument.
     */

    def doYouBuyTheCar(b: Option[Boolean]) = TODO
  }

  // ===============================================================

  task(2) {

    /**
     * Konvertiert einen String in einen Integer (None bei Ausnahme).
     */

    def convertToInt(s: String) = TODO
  }

  // ===============================================================

  task(3) {

    /**
     * Addiert den linken mit dem rechten numerischen Wert (falls vorhanden).
     */

    def addLeftAndRight(left: Option[Long], right: Option[Long]) = TODO
  }
}