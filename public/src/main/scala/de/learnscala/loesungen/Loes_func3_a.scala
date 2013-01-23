package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_func3_a extends Solution {

  /**
   * Teil #1: foreach
   */

  task(1) {
    def r {
      List(1, 2, 3) foreach { n => println(n) }
    }
  }

  task(2) {
    def r {
      List("Mary", "John", "Paul", "Barry") foreach {
        n => if (n endsWith "y") println(n)
      }
    }
  }


  /**
   * Teil #2: filter
   */

  task(3) {
    def r =
      List(1, 2, 3, 4) filter { i => i % 2 == 0 }
  }

  task(4) {
    def r =
      List(1, 9, 43, 100, 321, 23) filter { i => i < 10 }
  }

  task(5) {
    def polls =
      List(("CDU" -> 35), ("SPD" -> 35), ("Grüne" -> 15), ("FDP" -> 6), ("Piraten" -> 4), ("Linke" -> 5))

    def r =
      polls filter { t => t._2 < 5 }
  }


  /**
   * Teil #3: map
   */

  task(6) {
    def r =
      List(1, 2, 3, 4) map { i => i * 2 }
  }

  task(7) {
    def r(opt: Option[String]): Option[String] =
       opt map { s => s.toUpperCase }
  }

  task(8) {
    def r =
      List("Jim", "Bob", "John") map { s => s + s.last + "y" }
  }

  /**
   * Teil #4: other
   *
   * @note Nicht verzagen, API-Dokumentation oder Präsentationsfolien fragen!
   */

  task(9) {
    def r =
      List(List("o", "u", "i", "e", "a"), List("ü", "ä", "ö")).flatten
  }

  task(10) {
    def r: (List[String], List[String])  =
      List("Anna", "John", "Maria", "Adam") partition { s => s.endsWith("a") }
  }

  task(11) {
    def isPrime(n: Int) = (((1 to n).toList) count { i => n % i == 0 }) == 2

    def r(nums: List[Int]) =
      nums exists { i => isPrime(i) }
  }
}