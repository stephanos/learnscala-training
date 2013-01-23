package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_trait extends Exercise with Help /* with Disabled */ {

  /**
   * Gehaltsabrechnung.
   *
   * - jeder normale Angestellte verdient 50.000€ im Jahr
   * - ist er mit dem Manager befreundet, bekommt er das doppelte
   * - ist er jedoch illegaler Einwanderer, halbiert sich sein Lohn
   * - ist er Teil des Aufsichtsrats, ist er automatisch Freund des Managers
   * - der Manager bekommt das 5x eines normalen Angestellten
   *
   * Nutze Traits um Logik zu "mixen" ! (siehe Aufgabe #4)
   */

  SOLUTION_HERE


  // ===============================================================
  // TESTS
  // ===============================================================

  task {
    /**
     * Aufgabe #1
     *
     * Das Gehalt eines normalen Angestellten.
     */
    def salaryForClerk =
      MAKE_THIS_TEST_PASS // with this: (new Clerk).salary

    // ===============================================================

    /**
     * Aufgabe #2
     *
     * Das Gehalt eines Managers.
     */
    def salaryForManager =
      MAKE_THIS_TEST_PASS

    // ===============================================================

    /**
     * Aufgabe #3
     *
     * Das Gehalt eines Board Members.
     */
    def salaryForBoardMember =
      MAKE_THIS_TEST_PASS

    // ===============================================================

    /**
     * Aufgabe #4
     *
     * Das Gehalt eines Angestellten, der befreundet mit dem Manager ist.
     */
    def salaryForFriendOfManagerClerk =
      MAKE_THIS_TEST_PASS // with this:  (new Clerk with FriendOfManager).salary

    // ===============================================================

    /**
     * Aufgabe #5
     *
     * Das Gehalt eines Angestellten der illegal eingewandert ist.
     */
    def salaryForIllegalImmigrantClerk =
      MAKE_THIS_TEST_PASS

    // ===============================================================

    /**
     * Aufgabe #6
     *
     * Das Gehalt eines illegal eingewanderten Managers.
     */
    def salaryForIllegalImmigrantManager =
      MAKE_THIS_TEST_PASS

    // ===============================================================

    /**
     * Aufgabe #7
     *
     * Das Gehalt eines illegal eingewanderten Board Members.
     */
    def salaryForIllegalImmigrantBoardMember =
      MAKE_THIS_TEST_PASS
  }
}