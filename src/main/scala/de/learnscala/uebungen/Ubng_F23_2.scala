package de.learnscala.uebungen

import de.learnscala.base.{Help, Exercise}

class Ubng_F23_2 extends Exercise with Help /* with Disabled */ {

    /**
     * Aufgabe #1
     *
     * Summiert die Elemente der Liste.
     */
    def sum(l: MyList[Int]) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #2
     *
     * Multipliziert alle Elemente der Liste (leere Liste ergibt 1).
     */
    def product(l: MyList[Int]) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #3
     *
     * Zählt die Elemente der Liste.
     */
    def count(l: MyList[Int]) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #4
     *
     * Liefert das letzte Ergebnis der Liste (leere Liste: None).
     */
    def last[A](list: MyList[A]) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #5
     *
     * Invertiert die Reihenfolge der Liste.
     */
    def reverse[A](list: MyList[A]) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #6
     *
     * Ermittelt ob ein Element Teil der Liste ist.
     */
    def contains[A](list: MyList[A], item: A) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #7
     *
     * Transformiert die Elemente der Liste durch Anwendung der übergebenen Funktion.
     */
    def map[A, B](list: MyList[A], f: A => B) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #8
     *
     * Filtert die Elemente aus der Liste heraus, bei denen die Funktion 'true' ergibt.
     */
    def filter[A](list: MyList[A], p: A => Boolean) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #9
     *
     * Erstellt eine Liste ohne doppelte Werte.
     */
    def unique[A](list: MyList[A]) =
        TODO
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