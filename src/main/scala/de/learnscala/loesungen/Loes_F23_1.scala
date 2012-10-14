package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F23_1 extends Solution {

    def add1 =
        (x: Int) => x + 1

    def sub1 =
        (x: Int) => x - 1

    def double =
        (x: Int) => x * 2


    /**
     * Aufgabe #1
     */
    def r1(l: List[Int]) =
        l map add1

    // ===============================================================

    /**
     * Aufgabe #2
     */
    def r2(l: List[Int]) =
        l map add1 map double

    // ===============================================================

    /**
     * Aufgabe #3
     */
    def r3(l: List[Int]) =
        l map double map add1

    // ===============================================================

    /**
     * Aufgabe #4
     */
    def r4(l: List[Int]) =
        l map add1 map double map sub1

    // ===============================================================

    /**
     * Aufgabe #5
     */
    def r5(l: List[(Int, Int)]) =
        l map (t => (add1(t._1), sub1(t._2)))
}