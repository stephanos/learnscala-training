package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_object extends Solution {

  class Point(val x: Int, val y: Int) {
    require(x >= 0)
    require(y >= 0)

    override def toString =
      "[" + x + "," + y + "]"
  }


  object Point {

    private var noOfPoints = 0

    def apply(x: Int): Point = {
      apply(x, x)
    }

    def apply(x: Int, y: Int): Point = {
      noOfPoints += 1
      new Point(x, y)
    }

    def count = noOfPoints
  }

  // ===============================================================
  // TESTS
  // ===============================================================
  task {
    def t1 = Point(5, 5)

    def t2 = Point(5)

    def t3 = Point(-5)

    def t4 = Point(-5, 5)

    def t5 = {
      Point(1, 2)
      Point(2, 1)
      Point.count
    }
  }
}