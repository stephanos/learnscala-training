package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_typparam extends Exercise with Help /* with Disabled */ {

  // TODO: Cay p.184

  /**
   * Aufgabe #1
   *
   * Klasse 'MyPair' ist eine konkrete, typisierte Implementierung von 'Pair'.
   */

  trait Pair {

    def t: Any

    def s: Any

    def swap: Pair
    def bothHaveSameType: Boolean
  }


  // ===============================================================
  // TESTS
  // ===============================================================

  def p1 =
    MAKE_THIS_TEST_PASS // with this: new MyPair(1, 1)

  def p2 =
    MAKE_THIS_TEST_PASS // with this: new MyPair(true, false)

  def p3 =
    MAKE_THIS_TEST_PASS // with this: new MyPair("Bob", "Babe")

  def p4 =
    MAKE_THIS_TEST_PASS // with this: new MyPair("male", true)
}