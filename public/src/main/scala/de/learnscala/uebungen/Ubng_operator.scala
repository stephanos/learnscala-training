package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_operator extends Exercise with Help /* with Disabled */ {

    /**
     * Gesucht wird eine Klasse 'Bruch' mit den Methoden: 'toString', '*', '/' und '!'
     *
     * @note Ausgabe via String sollte natürlich immer gekürzte Brüche ausgeben
     * @note Und nicht vergessen, zur Division wird über Kreuz multipliziert.
     * @note Ach und, bitte alles nur kein 'var'.
     */

    DEFINE_CLASS_HERE

    /*
      Als Arbeitserleichterung, Methode zur Berechnung des größten gemeinsamen Teilers:

      private def gcd(x: Int, y: Int): Int = {
        if (x == 0) y
        else if (x < 0) gcd(-x, y)
        else if (y < 0) -gcd(x, -y)
        else gcd(y % x, x)
      }
    */

  // ===============================================================
  // TESTS
  // ===============================================================

  task {
    def r1 = MAKE_THIS_TEST_PASS // with this: new Bruch(1, 2)

    def r2 = MAKE_THIS_TEST_PASS // with this: (new Bruch(1, 8)) / (new Bruch(1, 2))

    def r3 = MAKE_THIS_TEST_PASS // with this: (new Bruch(1, 2)) * (new Bruch(1, 2))

    def r4 = MAKE_THIS_TEST_PASS // with this: (new Bruch(7, 8)) * (new Bruch(2, 3))

    def r5 = MAKE_THIS_TEST_PASS // with this: !(new Bruch(1, 2))

  }
}