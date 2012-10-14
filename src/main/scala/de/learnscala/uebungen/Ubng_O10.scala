package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_O10 extends Exercise with Help /* with Disabled */ {


    /**
     * Klasse 'Time' erwartet 2 Parameter: Stunden und Minuten.
     *
     * Sie besitzt die Methoden
     *  - addMin(Int): fügt Minuten hinzu
     *  - addHours(Int): fügt Stunden hinzu
     *  - add(Time): addiert eine andere Time-Instanz
     *  - print: gibt die Zeit aus (z.B. 00:30)
     *
     **/


    /**
     * Aufgabe #1
     *
     * Zeit um 13:37.
     */
    def t1 = TODO // new Time(13, 37)

    // ===============================================================

    /**
     * Aufgabe #2
     *
     * Zeit um 20:00.
     */
    def t2 = TODO // new Time(20)

    // ===============================================================

    /**
     * Aufgabe #3
     *
     * Zeit um 0:00.
     */
    def t3 = TODO // new Time()

    // ===============================================================

    /**
     * Aufgabe #4
     *
     * Zeit um 12:00 plus 2 Stunden
     */
    def t4 = TODO // new Time(12, 00).addHours(2)

    // ===============================================================

    /**
     * Aufgabe #5
     *
     * Zeit um 23:59 plus 2 Minuten
     */
    def t5 = TODO // new Time(23, 59).addMin(2)

    // ===============================================================

    /**
     * Aufgabe #6
     *
     * Zeit um 12:23 plus 13:37
     */
    def t6 = TODO // new Time(12, 23).add(new Time(13, 37))
}