package de.learnscala.beispiele
package qsort

/**
 * Pattern Matching, Typ-Parameter, View Bound, Kollektion
 */
object Quicksort {

  def qsort[T <% Ordered[T]](list: List[T]): List[T] = {
    list match {
      case Nil => Nil
      case x :: xs =>
        val (before, after) = xs partition (_ < x)
        qsort(before) ++ (x :: qsort(after))
    }
  }
}


object Main extends App {

  import Quicksort._

  println(qsort(List(5, 3, 2, 1, 4)))
  println(qsort(List(5, 4, 3, 2, 1)))
}