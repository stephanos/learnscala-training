package de.learnscala.loesungen

import de.learnscala.base.Solution
import scala.Some

class Loes_F20 extends Solution {

  task(1) {

    def swap(t: (Int, Int)): (Int, Int) =
      (t._2, t._1)
  }

  // ===============================================================

  task(2) {

    def sum(t: (Boolean, Int, Int)) =
      t match {
        case (true, a1, a2) => a1 + a2
        case (false, a1, a2) => a1 - a2
      }
  }

  // ===============================================================

  task(3) {

    def doYouBuyTheCar(b: Option[Boolean]) =
      b match {
        case Some(true) => "yes"
        case Some(false) => "no"
        case _ => "not sure"
      }
  }

  // ===============================================================

  task(4) {

    def convertToInt(s: String): Option[Int] =
      try {
        Some(s.toInt)
      } catch {
        case _: Throwable => None

      }
  }

}