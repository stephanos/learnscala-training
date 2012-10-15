package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_O22 extends Exercise with Help /* with Disabled */ {

    /**
     * 'OpTree' ist ein Baum, bei dem jeder Knoten einen Operator und zwei Unterbäume besitzt.
     * Mögliche Operatoren sind: '+', '-', '*', '/'.
     *
     * Die Methode 'sum' erhält einen Baum als Argument und errechnet die Summe,
     * wobei der Operator auf die Summen der Unterbäume anzuwenden ist.
     *
     * Zum Beispiel:
     * +
     * /  \
     * *    -
     * / \  / \
     * 3 8  2  5
     * => Summe ist (3 * 8) + (2 - 5) = 24 + -3 = 21
     */


    // def sum(tree: OpTree): Int =


    // ===============================================================

    /**
     * Aufgabe #1
     */
    def s1 = TODO //sum(Leaf(5))

    // ===============================================================

    /**
     * Aufgabe #2
     */
    def s2 = TODO //sum(Node('+', Leaf(5), Leaf(5)))

    // ===============================================================

    /**
     * Aufgabe #3
     */
    def s3 = TODO //sum(Node('*', Leaf(5), Leaf(5)))

    // ===============================================================

    /**
     * Aufgabe #4
     */
    def s4 = TODO //sum(Node('/', Leaf(5), Leaf(5)))

    // ===============================================================

    /**
     * Aufgabe #5
     */
    def s5 = TODO //sum(Node('-', Leaf(5), Leaf(5)))

    // ===============================================================

    /**
     * Aufgabe #6
     */
    def s6 = TODO //sum(Node('+', Node('-', Leaf(10), Leaf(2)), Node('*', Leaf(5), Leaf(5))))
}