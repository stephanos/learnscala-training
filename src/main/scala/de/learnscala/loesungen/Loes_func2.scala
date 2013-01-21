package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_func2 extends Solution {

  task {
    def singletonSet(elem: Int): Int => Boolean =
        (e: Int) => e == elem

    // TESTS:
    def s1: Int => Boolean = singletonSet(1)
    def s2: Int => Boolean = singletonSet(2)
    def s3: Int => Boolean = singletonSet(3)

    // ===============================================================

    def union(s: Int => Boolean, t: Int => Boolean): Int => Boolean =
      elem => { s.apply(elem) || t(elem) }

    // TESTS:
    def u = union(s1, s2)
    def u1 = u(1)
    def u2 = u(2)
    def u3 = u(3)

    // ===============================================================

    def intersect(s: Int => Boolean, t: Int => Boolean): Int => Boolean =
      elem => { s(elem) && t(elem) }

    // TESTS:
    def i = intersect(union(s1, s2), union(s1, s3))
    def i1 = i(1)
    def i2 = i(2)
    def i3 = i(3)

    // ===============================================================

    def diff(s: Int => Boolean, t: Int => Boolean): Int => Boolean =
      elem => { s(elem) && !t(elem) }

    // TESTS:
    def d = diff(union(s1, s2), union(s1, s3))
    def d1 = d(1)
    def d2 = d(2)
    def d3 = d(3)
  }
}