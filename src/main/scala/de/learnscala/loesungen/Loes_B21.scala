package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_B21 extends Solution {

  import annotation.tailrec

  task(1) {
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