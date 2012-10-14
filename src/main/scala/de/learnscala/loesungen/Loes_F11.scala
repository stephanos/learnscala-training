package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F11 extends Solution {

    /**
     * Aufgabe #1
     */

    val negate = (f: Float) => f * -1

    def f1 = negate(5.0f)

    // ===============================================================

    /**
     * Aufgabe #2
     */

    val half = (i: Int) => i / 2

    def f2 = half(2)

    // ===============================================================

    /**
     * Aufgabe #3
     */

    val printReverse = (s: String) => println(s.reverse)

    def f3 = printReverse("abc")

    // ===============================================================

    /**
     * Aufgabe #4 (Bonus)
     */

    val repeat = (s: String, i: Int) => s * i

    def f4 = repeat("123", 3)
}