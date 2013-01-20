package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_B23 extends Exercise with Help /* with Disabled */ {

  task(1) {

    /**
     * Erstelle eine Zeitungsannonce aus den Parametern.
     */

    def printAd(firstName: String, age: Int, height: Float, weight: Int, hobbies: List[String]) =
      ""
  }

  // ===============================================================

  task(2) {

    /**
     * Erstelle einen eigenen Interpolationsbefehl "nums",
     * der einen String in eine Sequenz aus ganzen Zahlen erstellt.
     *
     * @note Platziere die Klasse im Companion Object und importiere sie!
     */

    def list123 =
      Seq() // nums"1,2,3"
  }

  // ===============================================================

  task(3) {

    /**
     * Verbessere die Implementierung ggf., so dass auch dynamische Ausdrücke funktionieren.
     */

    def list123 =
      Seq() // nums"1,{1 + 1},{1 + 1 + 1}"
  }
}