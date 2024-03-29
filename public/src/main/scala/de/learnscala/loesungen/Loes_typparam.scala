package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_typparam extends Solution {

  class MyPair[A, B](val _1: A, val _2: B) {

    def swap =
      new MyPair(_2, _1)

    def isTwinPair =
      _1 == _2

    override def toString =
      "(" + _1 + ", " + _2 + ")"
  }


  // ===============================================================
  // TESTS
  // ===============================================================

  task {
    def p1 =
      new MyPair(1, "Bob")

    def p2 =
      new MyPair(1, 2)

    def p3 =
      new MyPair(true, false).swap

    def p4 =
      new MyPair(true, 5).isTwinPair

    def p5 =
      new MyPair(6, 6).isTwinPair
  }
}