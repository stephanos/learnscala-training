package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_list extends Solution {

  task(1) {

    def r1 =
      "Hello" :: List("World") == List("Hello", "World")

    def r2 =
      ("Hello" :: "World" :: Nil).mkString("", " ", "!") == "Hello World!"

    def r3 =
      Nil.size == 0

    def r4 =
      Nil.::(4).::(3).::(2).::(1) == List(1, 2, 3, 4)

    def r5 =
      List().headOption == None

    def r6 =
      List(1, 2, 3).tail == List(2, 3)

    def r7 =
      List('a', 'b', 'c').head == 'a'

    def r8 =
      List("1" :: "2" :: Nil, "3") == List(List("1", "2"), "3")

  }

  // ===============================================================

  task(2) {

    def weekDays =
      List("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag")

    def weekendDays =
      List("Samstag", "Sonntag")

    def days =
      weekDays ::: weekendDays

  }

  // ===============================================================

  task(3) {

    def lastElem(l: List[Int]): Option[Int] =
      l match {
        case Nil => None
        case h :: Nil => Some(h)
        case h :: tail => lastElem(tail)
      }

  }

  // ===============================================================

  task(4) {

    def thirdElem(l: List[Int]): Option[Int] =
      l match {
        case h1 :: h2 :: h3 :: tail => Some(h3)
        case _ => None
      }

  }
}