package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_typparam extends Exercise with Help /* with Disabled */ {

  /**
   * Klasse 'MyPair'
   *
   * Nimmt 2 Werte unterschiedlichen Typs auf.
   *
   * @note Die Tests verwenden 'toString' zum Vergleichen.
   */

  DEFINE_CLASS_HERE


  // ===============================================================
  // TESTS
  // ===============================================================

  task {
    def p1 =
      MAKE_THIS_TEST_PASS // with this: new MyPair(1, "Bob")

    def p2 =
      MAKE_THIS_TEST_PASS // with this: new MyPair(1, 2)

    def p3 =
      MAKE_THIS_TEST_PASS // with this: new MyPair(true, false).swap

    def p4 =
      MAKE_THIS_TEST_PASS // with this: new MyPair(true, 5).isTwinPair

    def p5 =
      MAKE_THIS_TEST_PASS // with this: new MyPair(6, 6).isTwinPair
  }
}