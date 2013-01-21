package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_recursion extends Solution {

  import annotation.tailrec

  task(1) {

    @tailrec
    def gcd(a: Int, b: Int): BigInt =
      if (b == 0)
        a
      else
        gcd(b, a % b)

  }

  // ===============================================================

  task(2) {

    def sumDouble(ls: List[Int]): BigInt = {

      @tailrec
      def tailSum(l: List[Int], sum: BigInt): BigInt = {
        l match {
          case Nil => sum
          case head :: tail => tailSum(tail, sum + head * head)
        }
      }

      tailSum(ls, 0)
    }
  }

  // ===============================================================

  task(3) {

    def fib(n: Int): BigInt = {

      @tailrec
      def tailFib(n: Int, a: BigInt, b: BigInt): BigInt = {
        n match {
          case 0 => a
          case _ => tailFib(n - 1, a + b, a)
        }
      }

      tailFib(n, 0L, 1L)
    }

  }
}