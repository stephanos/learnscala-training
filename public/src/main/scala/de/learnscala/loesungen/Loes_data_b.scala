package de.learnscala.loesungen

import de.learnscala.base.Solution
import scala.Some

class Loes_data_b extends Solution {

  task(1) {

    def doYouBuyTheCar(b: Option[Boolean]) =
      b match {
        case Some(true) => "yes"
        case Some(false) => "no"
        case _ => "not sure"
      }
  }

  // ===============================================================

  task(2) {

    def convertToInt(s: String): Option[Int] =
      try {
        Some(s.toInt)
      } catch {
        case _: Throwable => None
      }
  }

  // ===============================================================

  task(3) {

    def addLeftAndRight(left: Option[Int], right: Option[Int]) =
      left.getOrElse(0) + right.getOrElse(0)
  }

}