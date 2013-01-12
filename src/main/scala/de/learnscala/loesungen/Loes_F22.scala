package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F22 extends Solution {

  task(1) {

    def weekDays =
      List("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag")

    def weekendDays =
      List("Samstag", "Sonntag")
  }

  // ===============================================================

  task(2) {

    def last(l: List[Int]): Option[Int] =
      l match {
        case Nil => None
        case h :: Nil => Some(h)
        case h :: tail => last(tail)
      }
  }

  // ===============================================================

  task(3) {

    def third(l: List[Int]): Option[Int] =
      l match {
        case h1 :: h2 :: h3 :: tail => Some(h3)
        case _ => None
      }
  }
}