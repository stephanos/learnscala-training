package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_implicit extends Exercise with Help /* with Disabled */ {

  /**
   * Sorgen Sie dafür, dass ein Int mit einem Bruch multiplizierbar ist!
   *
   * @note Bitte dafür die Klasse 'Bruch' aus 'Ubng_operator' hier hinein kopieren.
   */

  INSERT_HERE

  task(1) {
    def r = MAKE_THIS_TEST_PASS // with this: 2 * new Bruch(1, 4)
  }

  // ===============================================================

  /**
   * Kreieren Sie den Operator '+%' der eine ganze Zahl prozentual erhöht!
   */

  DEFINE_CLASS_HERE

  task(2) {
    def r = MAKE_THIS_TEST_PASS // with this: 150 +% 50
  }

  // ===============================================================

  /**
   * BONUS!
   *
   * Erweitern Sie 'String' um die Methode 'time',
   * welche eine entsprechende Instanz von 'java.util.Date' erstellt.
   */

  DEFINE_CLASS_HERE

  task(3) {
    def r(s: String) = MAKE_THIS_TEST_PASS // with this: s.time
  }
}