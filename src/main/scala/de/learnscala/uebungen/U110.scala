package de.learnscala.uebungen

import de.learnscala.base.Uebung

object U110 extends Uebung(enabled = true) {

    /**
     * Klasse 'Point' definiert einen 2-dimensionalen Punkt.
     *
     * Objekt 'Point' stellt 2 Factory-Methoden zur Verfügung,
     *  eine für x/y-Koordinaten und die andere mit einem Parameter für den Sonderfall x = y.
     *
     * Zusätzlich zählt es die Anzahl der bisher erstellten Punkte
     *  und liefert diese via 'getCount'.
     */
    class Point(val x: Int, val y: Int)

    object Point {
        def apply(x: Int): Point = {
            apply(x, x)
        }

        def apply(x: Int, y: Int): Point = {
            count += 1
            new Point(x, y)
        }

        def getCount = count

        private var count = 0
    }


    // TESTS
    def p1 = Point(5, 5)
    def p2 = Point(5)
}