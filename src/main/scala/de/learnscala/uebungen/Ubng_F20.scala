package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_F20 extends Exercise with Help /* with Disabled */ {

    task(1) {

        /**
         * Methode 'swap'
         *
         * Tauscht die Elemente des Tuples.
         */

        def swap(t: (Int, Int)) =
            TODO
    }

    // ===============================================================

    task(2) {

        /**
         * Methode 'sum'
         *
         * Summiert die Elemente eines Tuples.
         * Das erste Element zeigt an, ob addiert (true) oder subtrahiert (false) werden soll.
         */

        def sum(t: (Boolean, Int, Int)) =
            TODO
    }

    // ===============================================================

    task(3) {

        /**
         * Methode 'doYouBuyTheCar'
         *
         * Antwortet (print) ob das Auto gekauft werden soll - abhängig vom Argument.
         */

        def doYouBuyTheCar(b: Option[Boolean]) {
            TODO
        }
    }

    // ===============================================================

    task(3) {

        /**
         * Methode 'convertToInt'
         *
         * Konvertiert einen String in einen Integer (None bei Ausnahme).
         */

        def convertToInt(s: String) =
            TODO
    }
}