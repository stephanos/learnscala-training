package de.learnscala.uebungen

import de.learnscala.base._
import collection.mutable.ListBuffer

class Ubng_func3_b extends Exercise with Help /* with Disabled */ {

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
      FILL_IN_BODY_HERE
  }

  // ===============================================================

  task(3) {

    def m3[A](list: List[A]) =
      FILL_IN_BODY_HERE
  }

  // ===============================================================

  task(4) {

    def m4[A](list: List[A]) =
      FILL_IN_BODY_HERE
  }

  /*

  val votes = Seq(("scala", 1), ("java", 4), ("scala", 10), ("scala", 1), ("python", 10))
  val orderedVotes = votes
    .groupBy(_._1)
    .map { case (which, counts) =>
      (which, counts.foldLeft(0)(_ + _._2))
    }.toSeq
    .sortBy(_._2)
    .reverse

  val votesByLang = votes groupBy { case (lang, _) => lang }
  val sumByLang = votesByLang map { case (lang, counts) =>
    val countsOnly = counts map { case (_, count) => count }
    (lang, countsOnly.sum)
  }
  val orderedVotes = sumByLang.toSeq
    .sortBy { case (_, count) => count }
    .reverse

   */


  // ===============================================================

  task(5) {

    /**
     * BONUS
     */
    def m5[A](list: List[A]) =
      FILL_IN_BODY_HERE
  }
}