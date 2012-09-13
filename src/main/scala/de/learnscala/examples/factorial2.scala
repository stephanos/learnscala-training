package de.learnscala.examples
package factorial2

/**
 * Rekursion, Implicit
 */
object Factorial {

    def fact(n: Int): BigInt =
        if (n == 0) 1 else fact(n - 1) * n

    class Factorizer(n: Int) {
        def ! = fact(n)
    }

    implicit def int2fact(n: Int) = new Factorizer(n)
}

object Main {

    import Factorial._

    println("10! = " + (10 !))
}