package de.learnscala.exercises

import de.learnscala.base.Exercise

object U210 extends Exercise {



    /**
     * Klasse 'MyPair' ist eine konkrete, typisierte Implementierung von 'Pair'.
     */


    trait Pair {

        def t: Any
        def s: Any
        def swap: Pair
        def bothHaveSameType: Boolean
    }


    def p1 =
        TODO //new MyPair(1, 1)

    def p2 =
        TODO //new MyPair(true, false)

    def p3 =
        TODO //new MyPair("Bob", "Babe")

    def p4 =
        TODO //new MyPair("male", true)
}