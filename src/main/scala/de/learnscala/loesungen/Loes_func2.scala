package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_func2 extends Solution {

  def singletonSet(elem: Int): Int => Boolean =
      (e: Int) => e == elem

  // TESTS:
  def s1: Int => Boolean = singletonSet(1)
  def s2: Int => Boolean = singletonSet(2)
  def s3: Int => Boolean = singletonSet(3)

  // ===============================================================

  /**
   * Aufgabe #1
   */
  def union(s: Int => Boolean, t: Int => Boolean): Int => Boolean =
    elem => s.apply(elem) || t(elem)

  // TESTS:
  def u = union(s1, s2)
  def u_1 = u(1)
  def u_2 = u(2)
  def u_3 = u(3)

  // ===============================================================

  /**
   * Aufgabe #2
   */
  def intersect(s: Int => Boolean, t: Int => Boolean): Int => Boolean =
    elem => s(elem) && t(elem)

  // TESTS:
  def i = intersect(s1, s3)
  def i_1 = i(1)
  def i_2 = i(2)
  def i_3 = i(3)

  // ===============================================================

  /**
   * Aufgabe #3
   */
  def diff(s: Int => Boolean, t: Int => Boolean): Int => Boolean =
    elem => s(elem) && !t(elem)

  // TESTS:
  def d = diff(s1, s2)
  def d_1 = d(1)
  def d_2 = d(2)
  def d_3 = d(3)
}