package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_class extends Exercise with Help /* with Disabled */ {

  task {

    /**
     * Klasse 'Time'
     *
     * @todo Bringen Sie die Tests zum Laufen!
     *
     * @note Die Tests verwenden 'toString' zum Vergleichen.
     * @note Und vergessen Sie nicht: Unveränderlich ist Trumpf.
     **/

    DEFINE_CLASS_HERE


    // ===============================================================
    // TESTS
    // ===============================================================

    /**
     * Zeit um 13:37.
     */
    def t1 = MAKE_THIS_TEST_PASS // with this: new Time(13, 37)

    /**
     * Zeit um 20:00.
     */
    def t2 = MAKE_THIS_TEST_PASS // with this: new Time(20)

    /**
     * Zeit um 0:00.
     */
    def t3 = MAKE_THIS_TEST_PASS // with this: new Time()

    /**
     * Zeit um 12:00 plus 2 Stunden
     */
    def t4 = MAKE_THIS_TEST_PASS // with this: new Time(12, 0).addHours(2)

    /**
     * Zeit um 23:59 plus 2 Minuten
     */
    def t5 = MAKE_THIS_TEST_PASS // with this: new Time(23, 59).addMin(2)

    /**
     * Zeit um 12:23 plus 13:37
     */
    def t6 = MAKE_THIS_TEST_PASS // with this: new Time(12, 23).add(new Time(13, 37))

    /**
     * ungültige Zeit
     */
    def t7 = MAKE_THIS_TEST_PASS // with this: new Time(99)
  }
}