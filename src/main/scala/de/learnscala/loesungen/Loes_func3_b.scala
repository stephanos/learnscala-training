package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_func3_b extends Solution {

  task(1) {
    def m1(l: List[Int]) =
      l map { i => i + 1 } filter { i => i % 2 == 0 }
  }

  // ===============================================================

  task(2) {
    def m2(l: List[String]) = {
      def startsWithVowel = (s: String) => s.charAt(0)
      l groupBy { s => startsWithVowel(s) }
    }
  }

  // ===============================================================

  task(3) {

  }

  // ===============================================================

  task(4) {

  }

  // ===============================================================

  task(5) {

  }
}

