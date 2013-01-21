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


  def p1 =
    TODO //new MyPair(1, 1)

  def p2 =
    TODO //new MyPair(true, false)

  def p3 =
    TODO //new MyPair("Bob", "Babe")

  def p4 =
    TODO //new MyPair("male", true)
}