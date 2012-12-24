package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F23_2 extends Solution {

    task(1) {
        def sum(l: List[Int]) =
            l.foldLeft(0)((r, n) => r + n)
    }

    // ===============================================================

    task(2) {
        def product(l: List[Int]) =
            l.foldLeft(1)((r, n) => r * n)
    }

    // ===============================================================

    task(3) {
        def count(l: List[Int]) =
            l.foldLeft(0)((sum, _) => sum + 1)
    }

    // ===============================================================

    task(4) {
        def last[A](list: List[A]): Option[A] =
            if (list.isEmpty) None
            else Some(list.foldLeft(list.head)((_, c) => c))
    }

    // ===============================================================

    task(4) {
        def reverse[A](list: List[A]): List[A] =
            list.foldLeft(List[A]())((r, c) => c :: r)
    }

    // ===============================================================

    task(5) {
        def contains[A](list: List[A], item: A): Boolean =
            list.foldLeft(false)((r, n) => r || n == item)
    }

    // ===============================================================

    /*
    task(6) {
        def map[A, B](list: List[A], f: A => B): List[B] =
            reverse(list.foldLeft(List[B]())((res, cur) => f(cur) :: res))
    }

    // ===============================================================

    task(7) {
        def filter[A](list: List[A], p: A => Boolean): List[A] =
            reverse(list.foldLeft(List[A]())((r, c) => if (p(c)) c :: r else r))
    }
    */
}

