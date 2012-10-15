package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F22 extends Solution {

    /**
     * Aufgabe #1
     */
    def weekDays =
        List("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag")

    def weekendDays =
        List("Samstag", "Sonntag")

    // ===============================================================

    /**
     * Aufgabe #2
     */
    def last(l: List[Int]): Option[Int] =
        l match {
            case List() => None
            case h :: List() => Some(h)
            case h :: tail => last(tail)
        }

    // ===============================================================

    /**
     * Aufgabe #3
     */
    def third(l: List[Int]): Option[Int] =
        l match {
            case h1 :: h2 :: h3 :: tail => Some(h3)
            case h :: tail => third(tail)
            case List() => None
        }
}