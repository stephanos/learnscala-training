package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_O22 extends Solution {

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

    abstract class OpTree

    case class Leaf(value: Int) extends OpTree
    case class Node(operator: Char, left: OpTree, right: OpTree) extends OpTree

    def sum(tree: OpTree): Int =
        tree match {
            case Leaf(v) => v
            case Node(op, left, right) =>
                op match {
                    case '+' => sum(left) + sum(right)
                    case '-' => sum(left) - sum(right)
                    case '*' => sum(left) * sum(right)
                    case '/' => sum(left) / sum(right)
                }
        }


    // ===============================================================

    /**
     * Aufgabe #1
     */
    def s1 = sum(Leaf(5))

    // ===============================================================

    /**
     * Aufgabe #2
     */
    def s2 = sum(Node('+', Leaf(5), Leaf(5)))

    // ===============================================================

    /**
     * Aufgabe #3
     */
    def s3 = sum(Node('*', Leaf(5), Leaf(5)))

    // ===============================================================

    /**
     * Aufgabe #4
     */
    def s4 = sum(Node('/', Leaf(5), Leaf(5)))

    // ===============================================================

    /**
     * Aufgabe #5
     */
    def s5 = sum(Node('-', Leaf(5), Leaf(5)))

    // ===============================================================

    /**
     * Aufgabe #6
     */
    def s6 = sum(Node('+', Node('-', Leaf(10), Leaf(2)), Node('*', Leaf(5), Leaf(5))))
}