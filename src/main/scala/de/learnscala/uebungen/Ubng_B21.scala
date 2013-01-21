package de.learnscala.uebungen

import de.learnscala.base._
import annotation.tailrec

class Ubng_B21 extends Exercise with Help /* with Disabled */ {

  // ===============================================================

  task(1) {

    /**
     * Methode 'gcd'
     *
     * @param x
     * @param y
     * @return Größter gemeinsamer Teiler (kgV)
     *
     * @todo Wandeln Sie folgende Funktion in eine endrekursive Funktion um!
     */

    //@tailrec
    def gcd(x: Int, y: Int): BigInt = {
      if (x == 0) y
      else if (x < 0) gcd(-x, y)
      else if (y < 0) -gcd(x, -y)
      else gcd(y % x, x)
    }

  }

  task(2) {

    /**
     * Methode 'doubleSum'
     *
     * @param lst Liste aus natürlichen Zahlen
     * @return Summe der Quadradzahlen der Liste
     *
     * @todo Wandeln Sie folgende Funktion in eine endrekursive Funktion um!
     * @note Die Signatur der Methode soll bestehen bleiben!
     */

    //@tailrec
    def doubleSum(lst: List[Int]): BigInt =
      lst match {
        case Nil => 0
        case head :: tail => (head * head) + doubleSum(tail)
      }

  }

  // ===============================================================

  task(3) {

    /**
     * Methode 'fib'
     *
     * @param n
     * @return Fibonacci-Zahl
     *
     * @note
         * Die Fibonacci-Folge ist eine unendliche Folge von Zahlen,
     *     bei der sich die jeweils folgende Zahl durch Addition ihrer beiden vorherigen Zahlen ergibt:
     *     0, 1, 1, 2, 3, 5, 8, 13, …
     *
     * @todo Wandeln Sie folgende Funktion in eine endrekursive Funktion um!
     * @note Die Signatur der Methode soll bestehen bleiben!
     */

    //@tailrec
    def fib(n: Int): BigInt =
      n match {
        case 0 => 0
        case 1 => 1
        case _ =>
          println(n)
          fib(n - 1) + fib(n - 2)
      }

  }
}