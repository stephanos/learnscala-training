package de.learnscala.beispiele
package cat

/**
 * Case Class
 */
object Main extends App {

  case class Cat(name: String, age: Int, isFemale: Boolean = true)

  val cat1 = Cat("Snowball", 5)
  println("current cat is " + cat1)

  val cat2 = cat1.copy(age = 0)
  println("old cat died, getting new cat " + cat2)
}