package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_data_a extends Solution {

  object Categories extends Enumeration {
    val Easy = Value("easy")
    val Average = Value("average")
    val Difficult = Value("difficult")
  }

  task(1) {

    def r1 =
      Categories.Easy.id == 0

    def r2 =
      Categories.Difficult.id == 2

    def r3 =
      (Categories.Difficult.id == Categories.maxId - 1) == true

    def r4 =
      (Categories.Easy == Categories.Difficult) == false

    def r5 =
      Categories(0) == Categories.Easy

    def r6 =
      Categories.Easy.toString == "easy"
  }

  // ===============================================================

  object Seasons extends Enumeration {
    val spring = Value("Frühling")
    val summer = Value("Sommer")
    val autumn = Value("Herbst")
    val winter = Value("Winter")
  }

  task(2) {
    def t1 = Seasons.spring.id
    def t2 = Seasons.summer.id
    def t3 = Seasons.winter.id
    def t4 = Seasons.autumn.toString
  }

  // ===============================================================

  task(3) {

    def r1 =
      ("Bayern" -> "München")._1 == "Bayern"

    def r2 =
      ("Bayern", "München")._2 == "München"

    def r3 = {
      val t = ("Martin", 42)
      t._1 + " ist " + t._2
    } == "Martin ist 42"
  }

  // ===============================================================

  task(4) {

    def swap(t: (Int, Int)): (Int, Int) =
      (t._2, t._1)
  }

  // ===============================================================

  task(5) {

    def charWithCode(c: Char) =
      c.toInt -> c
  }

  // ===============================================================

  task(6) {

    def sum(t: (Boolean, Int, Int)) =
      t match {
        case (true, a1, a2) => a1 + a2
        case (false, a1, a2) => a1 - a2
      }
  }

}