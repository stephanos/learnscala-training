package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F11 extends Solution {

    /**
     * Aufgabe #1
     */

    def negate = (f: Float) => f * -1

    def f1 = negate(5.0f)

    // ===============================================================

    /**
     * Aufgabe #2
     */

    def half = (i: Int) => i / 2

    def f2 = half(2)

    // ===============================================================

    /**
     * Aufgabe #3
     */

    def reverse = (s: String) => s.reverse

    def f3 = reverse("abc")

    // ===============================================================

    /**
     * Aufgabe #4 (Bonus)
     */

    def repeat = (s: String, i: Int) => s * i

    def f4 = repeat("123", 3)
}