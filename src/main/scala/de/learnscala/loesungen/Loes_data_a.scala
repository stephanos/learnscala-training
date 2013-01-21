package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_data_a extends Solution {

  object Seasons extends Enumeration {
    val spring = Value("Frühling")
    val summer = Value("Sommer")
    val autumn = Value("Herbst")
    val winter = Value("Winter")
  }

  task(1) {
    def t1 = Seasons.spring.id
    def t2 = Seasons.summer.id
    def t3 = Seasons.winter.id
    def t4 = Seasons.autumn.toString
  }

  // ===============================================================

  task(2) {

    def swap(t: (Int, Int)): (Int, Int) =
      (t._2, t._1)
  }

  // ===============================================================

  task(3) {

    def charWithCode(c: Char) =
      c.toInt -> c
  }

  // ===============================================================

  task(4) {

    def sum(t: (Boolean, Int, Int)) =
      t match {
        case (true, a1, a2) => a1 + a2
        case (false, a1, a2) => a1 - a2
      }
  }

}