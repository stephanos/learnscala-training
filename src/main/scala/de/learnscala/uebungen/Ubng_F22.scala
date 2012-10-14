package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_F22 extends Exercise with Help /* with Disabled */ {

    /**
     * Aufgabe #1
     *
     * Liste aus den deutschen Tagen der Woche, unterteilt in Wochentage und Wochenendtage.
     */
    def weekDays = TODO
    def weekendDays = TODO

    def days = TODO

    // ===============================================================

    /**
     * Aufgabe #2
     *
     * Ermittelt das letzte Element einer Liste (None falls nicht vorhanden).
     */
    def last(l: List[Int]) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #3
     *
     * Ermittelt das dritte Element einer Liste (None falls nicht vorhanden).
     */
    def third(l: List[Int], count: Int = 1) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #4
     *
     * Ermittelt ob eine Liste ein Palindrom ist (Zeichenkette, die von vorn und von hinten gelesen gleich bleibt).
     *
     * Tipp: l.reverse
     */
    def palindrome(s: List[Int]) =
        TODO
}