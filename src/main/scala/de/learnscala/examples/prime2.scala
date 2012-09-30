package de.learnscala.examples
package prime2

/**
 * Stream
 */
object Prime {

    lazy val ps: Stream[Int] =
        2 #:: Stream.from(3).filter(i => ps.takeWhile(j => j * j <= i).forall(i % _ > 0))

    def primes(start: Int, end: Int) =
        ps.drop(start).take(start - end).foreach(println)
}

object Main extends App {

    Prime.primes(1, 20)
}