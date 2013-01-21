package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_interpol extends Solution {

  task(1) {

    def printAd(firstName: String, age: Int, height: Float, weight: Int, hobbies: List[String]) = {
      s"Hi, my name is $firstName. " +
        f"I'm $age years old, weighing $weight kg at $height%.2f meters. " +
        f"My hobbies are ${hobbies.mkString(" and ")}."
    }
  }

  // ===============================================================

  task(2) {

    import Loes_interpol._

    def list123 =
      nums"1,2,3"
  }

  // ===============================================================

  task(3) {

    import Loes_interpol._

    def list123 =
      nums"1,${1 + 1},${1 + 1 + 1}"
  }
}

object Loes_interpol {

  implicit class ListHelper(val sc: StringContext) {

    def nums(args: Any*): Seq[Int] = {
      sc.s(args: _*).split(",").map { s => s.toInt }
    }
  }
}