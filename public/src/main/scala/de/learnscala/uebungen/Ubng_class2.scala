package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_class2 extends Exercise with Help /* with Disabled */ {

  /**
   * 'OpTree' ist ein Baum, bei dem jeder Knoten (Node) entweder
   *   A) eine Zahl beinhaltet (Leaf) oder
   *   B) einen Operator und wieder zwei Unterknoten hat.
   *
   * Mögliche Operatoren sind '+', '-', '*' und '/'.
   *
   * @todo Definieren Sie das Datenmodell!
   */

  DEFINE_CLASS_HERE


  /**
   * Methode 'solve'
   *
   * @param tree eine Instanz vom Typ OpTree
   * @return Rechenergebnis unter Anwendung der Zahlen und Operatoren der Knoten
   *
   * @example
   *           +
   *         /  \
   *        *    -
   *       / \  / \
   *       3 8  2  5
   *
   *       => Ergebnis: (3 * 8) + (2 - 5) = 24 + -3 = 21
   *
   * @todo Entwerfen Sie die Methode!
   */

  DEFINE_METHOD_HERE


  // ===============================================================
  // TESTS
  // ===============================================================

  task {
    def s1 = MAKE_THIS_TEST_PASS // use this: solve(Leaf(5))

    def s2 = MAKE_THIS_TEST_PASS // use this: solve(Node('+', Leaf(5), Leaf(5)))

    def s3 = MAKE_THIS_TEST_PASS // use this: solve(Node('*', Leaf(5), Leaf(5)))

    def s4 = MAKE_THIS_TEST_PASS // use this: solve(Node('/', Leaf(5), Leaf(5)))

    def s5 = MAKE_THIS_TEST_PASS // use this: solve(Node('-', Leaf(5), Leaf(5)))

    def s6 = MAKE_THIS_TEST_PASS // use this: solve(Node('+', Node('-', Leaf(10), Leaf(2)), Node('*', Leaf(5), Leaf(5))))
  }
}