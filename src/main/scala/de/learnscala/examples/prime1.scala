package de.learnscala.examples
package prime1

/**
 * Kollektion, Funktion höherer Ordnung
 */
object Prime {

    def isPrime(n: Int) =
        (2 until n) forall (n % _ != 0)

    def primes(start: Int, end: Int) =
        for (i <- start to end if isPrime(i)) println(i)
}

object Main extends App {

    Prime.primes(1, 20)
}