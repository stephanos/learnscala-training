package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_B21 extends Solution {

  import annotation.tailrec

  task(1) {

    @tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0)
        a
      else
        gcd(b, a % b)

  }

  // ===============================================================

  task(2) {

    def fib(n: Int): BigInt = {

      @tailrec
      def tailFib(n: Int, a: BigInt, b: BigInt): BigInt = {
        if (n == 0)
          a
        else
          tailFib(n - 1, a + b, a)
      }

      tailFib(n, 0L, 1L)
    }

  }
}