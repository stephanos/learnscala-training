package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F21 extends Solution {

  /////////////////////////////////////////////////////////
  // Traversable

  task(1) {
    def toString(t: Traversable[Int]) =
      t.mkString("[", ",", "]")
  }

  task(2) {
    def join(t1: Traversable[Int], t2: Traversable[Int]) =
      t1 ++ t2
  }

  task(3) {
    def first2(t: Traversable[Int]) =
      t.take(2)
  }

  task(4) {
    def sumOf(t: Traversable[Int]) =
      t.sum
  }

  task(5) {
    def length(t: Traversable[Int]) =
      t.size
  }

  task(6) {
    def withoutFirst(t: Traversable[Int]) =
      t.drop(1)
  }

  task(6) {
    def biggest(t: Traversable[Int]) =
      t.max
  }

  /////////////////////////////////////////////////////////
  // List

  task(7) {
    def makeList(e1: Int, e2: Int, e3: Int) =
      List(e1, e2, e3)
  }

  task(8) {
    def unique(l: List[Int]) =
      l.distinct
  }

  task(9) {
    def backwards(l: List[Int]) =
      l.reverse
  }


  /////////////////////////////////////////////////////////
  // Set

  task(10) {
    def has42and101(s: Set[Int]) =
      Set(42, 101) subsetOf s
  }

  task(11) {
    def mergeSet(s1: Set[Int], s2: Set[Int]) =
      s1 union s2
  }


  /////////////////////////////////////////////////////////
  // Map

  task(12) {
    def withoutKey42(m: Map[Int, Boolean]) =
      m - 42
  }

  task(13) {
    def hasKey42(m: Map[Int, Boolean]) =
      m contains 42
  }
}