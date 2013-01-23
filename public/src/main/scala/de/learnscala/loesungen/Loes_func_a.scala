package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_func_a extends Solution {

  task {

    def add1 =
      (x: Int) => { x + 1 }

    def sub1 =
      (x: Int) => { x - 1 }

    def double =
      (x: Int) => { x * 2 }

    // ===============================================================

    def r1(l: List[Int]) =
      l map { i => add1(i) }

    // ===============================================================

    def r2(l: List[Int]) =
      l map { i => add1(i) } map { i => double(i) }

    // ===============================================================

    def r3(l: List[Int]) =
      l map { i => double(i) } map { i => add1(i) }

    // ===============================================================

    def r4(l: List[Int]) =
      l map { i => add1(i) } map { i => double(i) } map { i => sub1(i) }

    // ===============================================================

    def r5(l: List[(Int, Int)]) =
      l map { t => (add1(t._1), sub1(t._2)) }
  }
}