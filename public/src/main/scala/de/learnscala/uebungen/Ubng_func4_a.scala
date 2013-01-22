package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_func4_a extends Exercise with Help /* with Disabled */ {

  /**
   * Implementieren Sie die folgenden Methoden mit Hife von 'foldLeft'.
   *
   * @note Verwenden Sie dabei maximal 3 Zeilen.
   */

  task(1) {

    /**
     * Summiert die Elemente der Liste.
     */

    def sum(l: List[Int]) =
      FILL_IN_BODY_HERE
  }

  // ===============================================================

  task(2) {

    /**
     * Multipliziert alle Elemente der Liste (leere Liste ergibt 1).
     */

    def product(l: List[Int]) =
      FILL_IN_BODY_HERE
  }

  // ===============================================================

  task(3) {

    /**
     * Zählt die Elemente der Liste.
     */

    def count(l: List[Int]) =
      FILL_IN_BODY_HERE
  }

  // ===============================================================

  task(4) {

    /**
     * Ermittelt ob ein Element Teil der Liste ist.
     */

    def contains[A](list: List[A], item: A) =
      FILL_IN_BODY_HERE
  }

  // ===============================================================

  task(5) {

    /**
     * BONUS
     *
     * Invertiert die Reihenfolge der Liste.
     */

    def reverse[A](list: List[A]) =
      FILL_IN_BODY_HERE
  }


}