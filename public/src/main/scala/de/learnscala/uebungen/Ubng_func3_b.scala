package de.learnscala.uebungen

import de.learnscala.base._
import collection.mutable

class Ubng_func3_b extends Exercise with Help /* with Disabled */ {

  /**
   * Eine alte Codebasis wird modernisiert.
   *
   * Blöderweise waren die Kollegen sehr faul: Dokumentation sucht man vergebens.
   * Aber immerhin gibt es ein paar Tests!
   *
   * @todo Schreiben Sie folgende Methoden mit 'map', 'flatMap', 'filter und 'foreach' um!
   * @note Tipp: alten Code auskommentieren, nicht löschen.
   */

  // ===============================================================

  task(1) {

    def m(list: List[Int]): List[Int] = {
      var i = 0
      var res = mutable.ListBuffer[Int]()
      while (i < list.size) {
        res += list(i) + 1
        i += 1
      }
      res.toList
    }

  }

  // ===============================================================

  task(2) {

    def m(list: List[String]): List[String] = {
      var res = mutable.ListBuffer[String]()
      for (i <- 0 until list.size) {
        val name = list(i).toLowerCase
        if (name == name.reverse)
          res += name
      }
      res.toList
    }

  }

  // ===============================================================

  task(3) {

    def m(ourStocks: List[(String, Float)]) {
      for (i <- 0 until ourStocks.size) {
        val stock = ourStocks(i)
        if (stock._2 > 0.05) // increased by 5%
          println("sell " + stock._1)
      }
    }

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
    def m = {
      var res = mutable.ListBuffer[String]()
      for (i <- 0 until customers.size) {
        val pets = customers(i).pets
        for (j <- 0 until pets.size) {
          val pet = pets(j)
          if (weOfferFoodFor.contains(pet))
            if (!res.contains(pet))
              res += pet
        }
      }
      res.toList
    }
  }

  // ===============================================================

  task(5) {


  }
}