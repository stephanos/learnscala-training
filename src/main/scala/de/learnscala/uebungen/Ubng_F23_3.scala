package de.learnscala.uebungen

import de.learnscala.base._
import collection.mutable.ListBuffer

class Ubng_F23_3 extends Exercise with Help /* with Disabled */ {

  /**
   *
   * Schreiben Sie folgende Methoden mit Hilfe von 'map', 'flatMap', 'filter und 'foreach' um!
   *
   * PS: Verwenden Sie dabei maximal eine Zeile.
   *
   */

  // ===============================================================

  task(1) {

    def m1(l: List[Int]) = {
      var i = 0
      var res = ListBuffer[Int]()
      while (i < l.size) {
        res += l(i) + 1
        i + 1
      }
      res.toList
    }
  }

  // ===============================================================

  task(2) {

    def m2[A](list: List[A]) =
      TODO
  }

  // ===============================================================

  task(3) {

    def m3[A](list: List[A]) =
      TODO
  }

  // ===============================================================

  task(4) {

    def m4[A](list: List[A]) =
      TODO
  }


  // ===============================================================

  task(5) {

    /**
     * BONUS
     */
    def m5[A](list: List[A]) =
      TODO
  }
}