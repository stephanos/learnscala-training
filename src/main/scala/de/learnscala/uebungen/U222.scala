package de.learnscala.uebungen

import de.learnscala.base.Uebung

object U222 extends Uebung(enabled = true) {

    /**
     * Ermittelt das letzte Element einer Liste.
     */
    def last(l: List[Int]): Option[Int] =
        l match {
            case List() => None
            case h :: List() => Some(h)
            case h :: tail => last(tail)
        }


    /**
     * Ermittelt das dritte Element einer Liste.
     */
    def third(l: List[Int], count: Int = 1): Option[Int] =
        l match {
            case List() => None
            case h :: tail if(count == 3) => Some(h)
            case h :: tail => third(tail, count + 1)
        }


    /**
     * Ermittelt ob eine Liste ein Palindrom ist (Zeichenkette, die von vorn und von hinten gelesen gleich bleibt).
     *
     * Tipp: l.reverse
     */
    def palindrome(s: List[Int]): Boolean =
        s.reverse.mkString("") == s.mkString("")

}