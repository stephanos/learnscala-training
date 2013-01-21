package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_data_b extends Exercise with Help /* with Disabled */ {

  // ===============================================================

  task(1) {

    /**
     * Bewältigen Sie das Quiz:
     * Ersetzen Sie den rechten Teil des Vergleichs mit dem entsprechenden Ergebnis!
     */

    def r1 =
      Some("a").get == TODO

    def r2 =
      None.getOrElse(1) == TODO

    def r3 =
      Option(null).getOrElse(6) == TODO

    def r4 =
      Option(None).get == TODO

    def r5 =
      Option(Option(null)).get == TODO
  }

  // ===============================================================

  task(2) {

    /**
     * Methode 'doYouBuyTheCar'
     *
     * Antwortet (print) ob das Auto gekauft werden soll - abhängig vom Argument.
     */

    TODO
  }

  // ===============================================================

  task(3) {

    /**
     * Methode 'convertToInt'
     *
     * Konvertiert einen String in einen Integer (None bei Ausnahme).
     */

    TODO
  }
}