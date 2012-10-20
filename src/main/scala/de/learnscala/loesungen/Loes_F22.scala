package de.learnscala.loesungen

import de.learnscala.base.Solution
import scala.annotation.tailrec

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
            case Nil => None
            case h :: Nil => Some(h)
            case h :: tail => last(tail)
        }

    // ===============================================================

    /**
     * Aufgabe #3
     */
    def third(l: List[Int]): Option[Int] =
        l match {
            case h1 :: h2 :: h3 :: tail => Some(h3)
            case _ => None
        }
}