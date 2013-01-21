package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_data_a extends Exercise with Help /* with Disabled */ {

  object Categories extends Enumeration {
    val Easy = Value("easy")
    val Average = Value("average")
    val Difficult = Value("difficult")
  }

  task(1) {

    /**
     * Bewältigen Sie das Quiz:
     * Ersetzen Sie den rechten Teil des Vergleichs mit dem entsprechenden Ergebnis!
     */

    def r1 =
      Categories.Easy.id == TODO

    def r2 =
      Categories.Difficult.id == TODO

    def r3 =
      (Categories.Difficult.id == Categories.maxId - 1) == TODO

    def r4 =
      (Categories.Easy == Categories.Difficult) == TODO

    def r5 =
      Categories(0) == TODO

    def r6 =
      Categories.Easy.toString == TODO
  }

  // ===============================================================

  /**
   * Vervollständigen Sie 'Seasons', so dass die Testfälle erfolgreich laufen.
   */
  object Seasons extends Enumeration

  task(2) {
    def t1 = TODO //Seasons.spring.id
    def t2 = TODO //Seasons.summer.id
    def t4 = TODO //Seasons.winter.id
    def t5 = TODO //Seasons.autumn.toString
  }

  // ===============================================================

  task(3) {

    /**
     * Bewältigen Sie das Quiz:
     * Ersetzen Sie den rechten Teil des Vergleichs mit dem entsprechenden Ergebnis!
     */

    def r1 =
      ("Bayern" -> "München")._1 == TODO

    def r2 =
      ("Bayern", "München")._2 == TODO

    def r3 = {
      val t = ("Martin", 42)
      t._1 + " ist " + t._2
    } == TODO
  }

  // ===============================================================

  task(4) {

    /**
     * Tauscht die Elemente des Tuples.
     *
     * @example swap((1,2)) = (2,1)
     */

    def swap(t: (Int, Int)) = TODO
  }

  // ===============================================================

  task(5) {

    /**
     * Liefert zu einem Zeichen den entsprechenden ASCII-Code
     *
     * @example charWithCode('a') = (97, 'a')
     * @note Char erbt von 'Int'
     */

    def charWithCode(c: Char) = TODO
  }

  // ===============================================================

  task(6) {

    /**
     * Summiert die Elemente eines Tuples.
     *
     * @example sum((false, 5, 5)) = 0
     * @note Das erste Element zeigt an, ob addiert (true) oder subtrahiert (false) werden soll.
     */

    def sum(t: (Boolean, Int, Int)) = TODO
  }

}