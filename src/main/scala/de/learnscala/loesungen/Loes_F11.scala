package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F11 extends Solution {

  task(1) {

    val negate = (f: Float) => { f * -1 }

    def t = negate(5.0f)
  }

  // ===============================================================

  task(2) {

    val half = (i: Int) => { i / 2 }

    def t = half(2)
  }

  // ===============================================================

  task(3) {

    val reverse = (s: String) => { s.reverse }

    def t = reverse("abc")
  }

  // ===============================================================

  task(4) {

    var trafficLight: String = "red"

    val drive = () => {
      trafficLight match {
        case "red" => false
        case "yellow" | "green" => true
        case _ => sys.error("out of order")
      }
    }

    def t1 = drive()

    def t2 = {
      trafficLight = "yellow"
      drive()
    }

    def t3 = {
      trafficLight = "green"
      drive()
    }

    def t4 = {
      trafficLight = null
      drive()
    }
  }

  // ===============================================================

  task(5) {

    // A
    val repeat = (s: String, i: Int) => { s * i }

    // B
    val repeat2: (String, Int) => String = {
      (s, n) =>
        if (n > 0)
          s + repeat2(s, n - 1)
        else
          ""
    }

    def t = repeat("123", 3)
  }
}