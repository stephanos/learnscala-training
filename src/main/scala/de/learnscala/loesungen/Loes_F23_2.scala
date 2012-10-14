package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F23_2 extends Solution {

    /**
     * Aufgabe #1
     */
    def sum(l: MyList[Int]) =
        l.foldLeft(0)(_ + _)

    // ===============================================================

    /**
     * Aufgabe #2
     */
    def product(l: MyList[Int]) =
        l.foldLeft(1)(_ * _)

    // ===============================================================

    /**
     * Aufgabe #3
     */
    def count(l: MyList[Int]) =
        l.foldLeft(0)((sum, _) => sum + 1)

    // ===============================================================

    /**
     * Aufgabe #4
     */
    def last[A](list: MyList[A]): Option[A] =
        if (list.isEmpty) None
        else Some(list.foldLeft(list.head)((_, c) => c))

    // ===============================================================

    /**
     * Aufgabe #5
     */
    def reverse[A](list: MyList[A]): MyList[A] =
        list.foldLeft(MyList[A]())((r, c) => c :: r)

    // ===============================================================

    /**
     * Aufgabe #6
     */
    def contains[A](list: MyList[A], item: A): Boolean =
        list.foldLeft(false)(_ || _ == item)

    // ===============================================================

    /**
     * Aufgabe #7
     */
    def map[A, B](list: MyList[A], f: A => B): MyList[B] =
        reverse(list.foldLeft(MyList[B]())((res, cur) => f(cur) :: res))

    // ===============================================================

    /**
     * Aufgabe #8
     */
    def filter[A](list: MyList[A], p: A => Boolean): MyList[A] =
        reverse(list.foldLeft(MyList[A]())((r, c) => if (p(c)) c :: r else r))

    // ===============================================================

    /**
     * Aufgabe #9
     */
    def unique[A](list: MyList[A]): MyList[A] =
        reverse(list.foldLeft(MyList[A]()) {
            (r, c) =>
                if (contains(r, c)) r else c :: r
        })

    // ===============================================================

    /**
     * Aufgabe #10
     */
    def separateTheMenFromTheBoys(persons: List[Person]): List[List[String]] = {
        def sortByAgeAndMapToName(persons: List[Person]) =
            persons.sortBy(_.age).map(_.firstName)

        val (minors, adults) = persons.partition(_.age < 18)
        List(sortByAgeAndMapToName(minors), sortByAgeAndMapToName(adults))
    }
}

case class MyList[A](private val l: List[A] = List()) {

    def head =
        l.head

    def tail =
        l.tail

    def foldLeft[B](z: B)(f: (B, A) => B): B =
        l.foldLeft(z)(f)

    def isEmpty =
        l.isEmpty

    def ::[B >: A](x: B): MyList[B] =
        new MyList(x :: l)
}

case class Person(age: Int, firstName: String, lastName: String)