package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_B23 extends Solution {

    task(1) {

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

            def *(that: Bruch) =
                new Bruch(zaehler * that.zaehler, nenner * that.nenner)

            def /(that: Bruch) =
                new Bruch(zaehler * that.nenner, nenner * that.zaehler)

            def unary_! =
                new Bruch(nenner, zaehler)

            override def toString =
                zaehler + "/" + nenner
        }

        implicit def int2Bruch(x: Int) = new Bruch(x, 1)

        def r1 = 1 * new Bruch(1, 2)
    }

    // ===============================================================

    task(2) {

        class MyInt(i: Int) {

            def +%(p: Int): Int =
                math.floor(i + (i / 100.0 * p)).toInt
        }

        implicit def int2MyInt(x: Int) = new MyInt(x)

        def r2 = 150 +% 50
    }
}