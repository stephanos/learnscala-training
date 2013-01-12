package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_O12 extends Solution {

  /**
   * Aufgabe #1
   */
  class Point(val x: Int, val y: Int) {
    require(x >= 0)
    require(y >= 0)

    override def toString =
      "[" + x + "," + y + "]"
  }

  object Point {

    private var count = 0

    def apply(x: Int): Point = {
      apply(x, x)
    }

    def apply(x: Int, y: Int): Point = {
      count += 1
      new Point(x, y)
    }

    def getCount =
      count
  }


  /**
   * Erstellt einen Punkt mit den Koordinaten (5,5)
   */
  def p1 = Point(5, 5)

  /**
   * Erstellt einen Punkt mit den Koordinaten (5,5)
   */
  def p2 = Point(5)

  /**
   * Versucht einen Punkt mit negativen Koordiaten zu erstellen.
   */
  def p3 = Point(-5)

  /**
   * Versucht einen Punkt mit einer negativen Koordiate zu erstellen.
   */
  def p4 = Point(-5, 5)
}