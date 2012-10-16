package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F23_2 extends Solution {

    /**
     * Aufgabe #1
     */
    def sum(l: List[Int]) =
        l.foldLeft(0)((r, n) => r + n)

    // ===============================================================

    /**
     * Aufgabe #2
     */
    def product(l: List[Int]) =
        l.foldLeft(1)((r, n) => r * n)

    // ===============================================================

    /**
     * Aufgabe #3
     */
    def count(l: List[Int]) =
        l.foldLeft(0)((sum, _) => sum + 1)

    // ===============================================================

    /**
     * Aufgabe #4
     */
    def last[A](list: List[A]): Option[A] =
        if (list.isEmpty) None
        else Some(list.foldLeft(list.head)((_, c) => c))

    // ===============================================================

    /**
     * Aufgabe #5
     */
    def reverse[A](list: List[A]): List[A] =
        list.foldLeft(List[A]())((r, c) => c :: r)

    // ===============================================================

    /**
     * Aufgabe #6
     */
    def contains[A](list: List[A], item: A): Boolean =
        list.foldLeft(false)((r, n) => r || n == item)

    // ===============================================================

    /**
     * Aufgabe #7
     */
    def map[A, B](list: List[A], f: A => B): List[B] =
        reverse(list.foldLeft(List[B]())((res, cur) => f(cur) :: res))

    // ===============================================================

    /**
     * Aufgabe #8
     */
    def filter[A](list: List[A], p: A => Boolean): List[A] =
        reverse(list.foldLeft(List[A]())((r, c) => if (p(c)) c :: r else r))
}

