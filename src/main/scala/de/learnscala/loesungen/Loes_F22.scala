package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F22 extends Solution {

    /**
     * Aufgabe #1
     */
    def weekDays = List("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag")

    def weekendDays = List("Samstag", "Sonntag")

    def days = weekDays ::: weekendDays

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
    def third(l: List[Int], count: Int = 1): Option[Int] =
        l match {
            case List() => None
            case h :: tail if (count == 3) => Some(h)
            case h :: tail => third(tail, count + 1)
        }

    // ===============================================================

    /**
     * Aufgabe #4
     *
     * Tipp: l.reverse
     */
    def palindrome(s: List[Int]): Boolean =
        s.reverse.mkString("") == s.mkString("")
}