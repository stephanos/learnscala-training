package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_operator extends Solution {

  task {

    class Bruch(z: Int, n: Int) {

      private def gcd(x: Int, y: Int): Int = {
        if (x == 0) y
        else if (x < 0) gcd(-x, y)
        else if (y < 0) -gcd(x, -y)
        else gcd(y % x, x)
      }

      private val g = gcd(z, n)

      val zaehler: Int = z / g
      val nenner: Int = n / g

      def *(b: Bruch) =
        new Bruch(zaehler * b.zaehler, nenner * b.nenner)

      def /(b: Bruch) =
        new Bruch(zaehler * b.nenner, nenner * b.zaehler)

      def unary_! =
        new Bruch(nenner, zaehler)

      override def toString =
        zaehler + "/" + nenner
    }

    // ===============================================================
    // TESTS
    // ===============================================================

    def r1 = new Bruch(1, 2)

    def r2 = (new Bruch(1, 8)) / (new Bruch(1, 2))

    def r3 = (new Bruch(1, 2)) * (new Bruch(1, 2))

    def r4 = (new Bruch(7, 8)) * (new Bruch(2, 3))

    def r5 = !(new Bruch(1, 2))
  }
}