package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_data_a extends Exercise with Help /* with Disabled */ {

  /**
   * Vervollständigen Sie 'Seasons', so dass die Testfälle erfolgreich laufen.
   */
  object Seasons extends Enumeration

  task(1) {
    def t1 = MAKE_THIS_TEST_PASS // with this: Seasons.spring.id
    def t2 = MAKE_THIS_TEST_PASS // with this: Seasons.summer.id
    def t4 = MAKE_THIS_TEST_PASS // with this: Seasons.winter.id
    def t5 = MAKE_THIS_TEST_PASS // with this: Seasons.autumn.toString
  }

  // ===============================================================

  task(2) {

    /**
     * Tauscht die Elemente des Tuples.
     *
     * @example swap((1,2)) = (2,1)
     */

    def swap(t: (Int, Int)) =
      FILL_IN_BODY_HERE
  }

  // ===============================================================

  task(3) {

    /**
     * Liefert zu einem Zeichen den entsprechenden ASCII-Code
     *
     * @example charWithCode('a') = (97, 'a')
     * @note Char erbt von 'Int'
     */

    def charWithCode(c: Char) =
      FILL_IN_BODY_HERE
  }

  // ===============================================================

  task(4) {

    /**
     * Summiert die Elemente eines Tuples.
     *
     * @example sum((false, 5, 5)) = 0
     * @note Das erste Element zeigt an, ob addiert (true) oder subtrahiert (false) werden soll.
     */

    def sum(t: (Boolean, Int, Int)) =
      FILL_IN_BODY_HERE
  }

}