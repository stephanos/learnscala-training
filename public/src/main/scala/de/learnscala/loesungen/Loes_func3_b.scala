package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_func3_b extends Solution {

  task(1) {
    def m(l: List[Int]) =
      l map { _ + 1 }
  }

  // ===============================================================

  task(2) {
    def m(l: List[String]) =
      l map { _.toLowerCase } filter { n => n == n.reverse }
  }

  // ===============================================================

  task(3) {
    def m(ourStocks: List[(String, Float)]) =
      ourStocks filter { _._2 > 0.05 } foreach { s => println("sell " + s._1) }
  }

  // ===============================================================

  val weOfferFoodFor = List("cat", "bird", "mouse")

  class Person(val pets: List[String])

  val customers = List(
    new Person(List("cat", "dog")),
    new Person(List("dog", "bird")),
    new Person(List("fish")),
    new Person(List())
  )

  task(4) {
    def m =
      customers flatMap { _.pets } filter { p => weOfferFoodFor.contains(p) } toSet
  }
}

