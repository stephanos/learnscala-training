package de.learnscala.beispiele
package factorial1

import annotation.tailrec

/**
 * Rekursion
 */
object Factorial {

  // without tail recursion
  def inefficientFactorial(n: Int): Int = {
    assert(n >= 0)

    if (n == 0) 1
    else n * inefficientFactorial(n - 1)
  }


  //with tail recursion
  def factorial(n: Int): Int = {
    assert(n >= 0)

    @tailrec def factorial(n: Int, result: Int): Int =
      if (n == 0) result
      else factorial(n - 1, result * n)

    factorial(n, 1)
  }

}

object Main extends App {

  import Factorial._

  val result0 = factorial(5)
  val result1 = inefficientFactorial(5)

  assert(result0 == result1)
}