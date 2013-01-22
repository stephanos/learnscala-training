package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_func2 extends Exercise with Help /* with Disabled */ {

  task {

    /**
     * Allgemein wird eine Menge (engl. 'set') natürlicher Zahlen mit der Funktion
     *   (s: Int) => Boolean
     * definiert.
     *
     * Liefert die Funktion 'singletonSet' true, ist der eingegebene Parameter Teil der Menge.
     */

    def singletonSet(elem: Int): Int => Boolean =
      (e: Int) => e == elem


    // TESTS:
    def s1 = singletonSet(1)
    def s2 = singletonSet(2)
    def s3 = singletonSet(3)

    // ===============================================================

    /**
     * Aufgabe #1
     *
     * Liefert die Vereinigungsmenge zweier Mengen - also alle Elemente
     * die in mindestens einer der Mengen vorhanden sind.
     */
    def union(s: Int => Boolean, t: Int => Boolean): Int => Boolean =
      ???


    // TESTS:
    def u = union(s1, s2)
    def u1 = u(1)
    def u2 = u(2)
    def u3 = u(3)

    // ===============================================================

    /**
     * Aufgabe #2
     *
     * Liefert die Schnittmenge zweier Mengen - also alle Elemente
     * die in beiden Mengen vorhanden sind.
     */
    def intersect(s: Int => Boolean, t: Int => Boolean): Int => Boolean =
      ???


    // TESTS:
    def i = intersect(union(s1, s2), union(s1, s3))
    def i1 = i(1)
    def i2 = i(2)
    def i3 = i(3)

    // ===============================================================

    /**
     * Aufgabe #3
     *
     * Liefert die Differenz zweier Mengen - also alle Elemente
     * die in `s` aber nicht in `t` sind.
     */
    def diff(s: Int => Boolean, t: Int => Boolean): Int => Boolean =
      ???


    // TESTS:
    def d = diff(union(s1, s2), union(s1, s3))
    def d1 = d(1)
    def d2 = d(2)
    def d3 = d(3)
  }
}