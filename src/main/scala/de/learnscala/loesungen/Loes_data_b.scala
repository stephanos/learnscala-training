package de.learnscala.loesungen

import de.learnscala.base.Solution
import scala.Some

class Loes_data_b extends Solution {

  // ===============================================================

  task(1) {
    def r1 =
      Some("a").get == "a"

    def r2 =
      None.getOrElse(1) == 1

    def r3 =
      Option(null).getOrElse(6) == 6

    def r4 =
      Option(None).get == None

    def r5 =
      Option(Option(null)).get == None
  }

  // ===============================================================

  task(2) {

    def doYouBuyTheCar(b: Option[Boolean]) =
      b match {
        case Some(true) => "yes"
        case Some(false) => "no"
        case _ => "not sure"
      }
  }

  // ===============================================================

  task(3) {

    def convertToInt(s: String): Option[Int] =
      try {
        Some(s.toInt)
      } catch {
        case _: Throwable => None
      }
  }

}