package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_object extends Exercise with Help /* with Disabled */ {

  /**
   * Klasse 'Point' definiert einen 2-dimensionalen Punkt.
   * Die Methode toString liefert eine Beschreibung des Punktes der Form "[x,y]".
   *
   * @todo Bringen Sie die Tests zum Laufen!
   */

  DEFINE_CLASS_HERE


  /**
   * Objekt 'Point' stellt 2 Factory-Methoden zur Verfügung,
   * eine für x/y-Koordinaten und die andere mit einem Parameter für den Sonderfall x = y.
   *
   * Ist einer der beiden Koordinaten negativ, sollte eine Ausnahme geworfen werden.
   *
   * Zusätzlich zählt es die Anzahl der bisher erstellten Punkte
   * und liefert diese via 'count'.
   *
   * @todo Bringen Sie die Tests zum Laufen!
   */

  DEFINE_OBJECT_HERE


  // ===============================================================
  // TESTS
  // ===============================================================

  task {
    /**
     * Erstellt einen Punkt mit den Koordinaten (5,5)
     */
    def t1 = MAKE_THIS_TEST_PASS // with this: Point(5, 5)

    /**
     * Erstellt einen Punkt mit den Koordinaten (5,5)
     */
    def t2 = MAKE_THIS_TEST_PASS // with this: Point(5)

    /**
     * Versucht einen Punkt mit negativen Koordiaten zu erstellen.
     */
    def t3 = MAKE_THIS_TEST_PASS // with this: Point(-5)

    /**
     * Versucht einen Punkt mit einer negativen Koordiate zu erstellen.
     */
    def t4 = MAKE_THIS_TEST_PASS // with this: Point(-5, 5)

    /**
     * 'count' müsste nun den Wert 2 haben.
     */
    def t5 = {
      MAKE_THIS_TEST_PASS
      //Point(1, 2)
      //Point(2, 1)
      //Point.count
    }
  }
}