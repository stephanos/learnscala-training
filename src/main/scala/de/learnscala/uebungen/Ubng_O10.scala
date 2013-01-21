package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_O10 extends Exercise with Help /* with Disabled */ {

  task {

    /**
     * Klase 'Time'
     *
     * @todo Bringen Sie die Tests zum Laufen!
     *
     * @note Die Tests verwenden 'toString' zum Vergleichen.
     * @note Und vergessen Sie nicht: Unveränderlich ist Trumpf.
     **/

    TODO


    // ===============================================================
    // TESTS
    // ===============================================================

    /**
     * Zeit um 13:37.
     */
    def t1 = TODO // new Time(13, 37)

    /**
     * Zeit um 20:00.
     */
    def t2 = TODO // new Time(20)

    /**
     * Zeit um 0:00.
     */
    def t3 = TODO // new Time()

    /**
     * Zeit um 12:00 plus 2 Stunden
     */
    def t4 = TODO // new Time(12, 00).addHours(2)

    /**
     * Zeit um 23:59 plus 2 Minuten
     */
    def t5 = TODO // new Time(23, 59).addMin(2)

    /**
     * Zeit um 12:23 plus 13:37
     */
    def t6 = TODO // new Time(12, 23).add(new Time(13, 37))

    /**
     * ungültige Zeit
     */
    def t7 = TODO // new Time(99)
  }
}