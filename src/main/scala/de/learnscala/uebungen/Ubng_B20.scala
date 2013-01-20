package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_B20 extends Exercise with Help /* with Disabled */ {

  task {

    /**
     * Gesucht wird eine Klasse 'Bruch' mit den Methoden: 'toString', '*', '/' und '!'
     *
     * @note Ausgabe via String sollte natürlich immer gekürzte Brüche ausgeben
     * @note Und nicht vergessen, zur Division wird über Kreuz multipliziert.
     */

    TODO

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

    def r1 = TODO // new Bruch(1, 2)

    def r2 = TODO // (new Bruch(1, 8)) / (new Bruch(1, 2))

    def r3 = TODO // (new Bruch(1, 2)) * (new Bruch(1, 2))

    def r4 = TODO // (new Bruch(7, 8)) * (new Bruch(2, 3))

    def r5 = TODO // !(new Bruch(1, 2))

  }
}