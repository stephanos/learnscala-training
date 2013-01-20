package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_B23 extends Solution {

  task(1) {

    def printAd(firstName: String, age: Int, height: Float, weight: Int, hobbies: List[String]) = {
      f"Hi, my name is $firstName. I'm $age years old, weighing $weight kg at $height%1.2f meters. My hobbies are ${hobbies.mkString(" and ")}."
    }
  }

  // ===============================================================

  task(2) {

    import Loes_B23._

    def list123 =
      nums"1,2,3"
  }

  // ===============================================================

  task(3) {

    import Loes_B23._

    def list123 =
      nums"1,{1 + 1},{1 + 1 + 1}"
  }
}

object Loes_B23 {

  implicit class ListHelper(val sc: StringContext) {

    def nums(args: Any*): Seq[Int] = {
      val fs = sc.s(args: _*)
      val nums = fs.split(",")
      nums.map(_.toInt)
    }
  }
}