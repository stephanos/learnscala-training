package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_func4_a extends Solution {

  task(1) {
    def sum(l: List[Int]) =
      l.foldLeft(0){ (r, n) => r + n }
  }

  // ===============================================================

  task(2) {
    def product(l: List[Int]) =
      l.foldLeft(1){ (r, n) => r * n }
  }

  // ===============================================================

  task(3) {
    def count(l: List[Int]) =
      l.foldLeft(0){ (sum, _) => sum + 1 }
  }

  // ===============================================================

  task(4) {
    def contains[A](list: List[A], item: A): Boolean =
      list.foldLeft(false){ (r, n) => r || n == item }
  }

  // ===============================================================

  task(5) {
    def reverse[A](list: List[A]): List[A] =
      list.foldLeft(List[A]()){ (r, c) => c :: r }
  }
}

