package de.learnscala.uebungen

import de.learnscala.base.{Help, Exercise}

class Ubng_F22 extends Exercise with Help /* with Disabled */ {

    /**
     * Aufgabe #1
     *
     * Tauscht die Elemente des Tuples.
     */
    def swap(t: (Int, Int)) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #2
     *
     * Summiert die Elemente eines Tuples.
     * Das erste Element zeigt an, ob addiert (true) oder subtrahiert (false) werden soll.
     */
    def sum(t: (Boolean, Int, Int)) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #3
     *
     * Antwortet (print) ob das Auto gekauft werden soll - abhängig vom Argument.
     */
    def doYouBuyTheCar(b: Option[Boolean]) {
        TODO
    }

    // ===============================================================

    /**
     * Aufgabe #4
     *
     * Konvertiert einen String in einen Integer (None bei Ausnahme).
     */
    def convertToInt(s: String) =
        TODO

}