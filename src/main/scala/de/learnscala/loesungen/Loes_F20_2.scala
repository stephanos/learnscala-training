package de.learnscala.loesungen

import de.learnscala.base.Solution
import scala.Some

class Loes_F20_2 extends Solution {

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