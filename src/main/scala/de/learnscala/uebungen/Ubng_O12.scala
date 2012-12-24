package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_O12 extends Exercise with Help /* with Disabled */ {

    task {
        /**
         * Klasse 'Point' definiert einen 2-dimensionalen Punkt.
         * Die Methode toString liefert eine Beschreibung des Punktes der Form "[x,y]".
         */


        /**
         * Objekt 'Point' stellt 2 Factory-Methoden zur Verfügung,
         * eine für x/y-Koordinaten und die andere mit einem Parameter für den Sonderfall x = y.
         *
         * Ist einer der beiden Koordinaten negativ, sollte eine Ausnahme geworfen werden.
         *
         * Zusätzlich zählt es die Anzahl der bisher erstellten Punkte
         * und liefert diese via 'getCount'.
         */


        /**
         * Erstellt einen Punkt mit den Koordinaten (5,5)
         */
        def p1 = TODO // Point(5, 5)

        /**
         * Erstellt einen Punkt mit den Koordinaten (5,5)
         */
        def p2 = TODO //Point(5)

        /**
         * Versucht einen Punkt mit negativen Koordiaten zu erstellen.
         */
        def p3 = TODO //Point(-5)

        /**
         * Versucht einen Punkt mit einer negativen Koordiate zu erstellen.
         */
        def p4 = TODO //Point(-5, 5)
    }
}