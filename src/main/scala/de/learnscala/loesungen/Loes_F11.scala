package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F11 extends Solution {


    task(1) {

        def negate = (f: Float) => f * -1

        def f1 = negate(5.0f)
    }

    // ===============================================================

    task(2) {

        def half = (i: Int) => i / 2

        def f2 = half(2)
    }

    // ===============================================================

    task(3) {

        def reverse = (s: String) => s.reverse

        def f3 = reverse("abc")
    }

    // ===============================================================

    task(4) {

        // A
        def repeat = (s: String, i: Int) => s * i

        // B
        def repeat2: (String, Int) => String = {
            (s, n) =>
                if (n > 0)
                    s + repeat2(s, n - 1)
                else
                    ""
        }

        def f4 = repeat("123", 3)
    }
}