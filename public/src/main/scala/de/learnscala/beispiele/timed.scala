package de.learnscala.beispiele
package timed

/**
 * Currying, Kontrollstruktur, By-Name-Parameter
 */
object Timed {

  def timed(f: => Unit) = {
    val start = System.currentTimeMillis
    val result = f
    println(System.currentTimeMillis - start + "ms")
    result
  }
}


object Main extends App {

  import Timed._

  timed { 10 * 2 }
}