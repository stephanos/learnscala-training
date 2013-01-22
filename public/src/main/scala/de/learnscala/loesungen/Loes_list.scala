package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_list extends Solution {

  task(1) {

    def weekDays =
      List("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag")

    def weekendDays =
      List("Samstag", "Sonntag")

    def days =
      weekDays ::: weekendDays

  }

  // ===============================================================

  task(2) {

    def lastElem(l: List[Int]): Option[Int] =
      l match {
        case Nil => None
        case h :: Nil => Some(h)
        case h :: tail => lastElem(tail)
      }

  }

  // ===============================================================

  task(3) {

    def thirdElem(l: List[Int]): Option[Int] =
      l match {
        case h1 :: h2 :: h3 :: tail => Some(h3)
        case _ => None
      }

  }
}