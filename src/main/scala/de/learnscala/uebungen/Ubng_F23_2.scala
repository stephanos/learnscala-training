package de.learnscala.uebungen

import de.learnscala.base._

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

    // ===============================================================

    /**
     * Aufgabe #10 (Bonus)
     *
     * Überarbeiten den folgenden imperativen Algorithmus.
     * Durch Verwendung der funktionalen Programmierung sollte der Code maximal 4 Zeilen lang sein!
     */
    def separateAdultsAndMinors(persons: List[Person]): List[List[String]] = {

        import collection.mutable.ListBuffer

        var minors: ListBuffer[Person] = new ListBuffer[Person]()
        var adults: ListBuffer[Person] = new ListBuffer[Person]()
        var minorNames: ListBuffer[String] = new ListBuffer[String]()
        var adultNames: ListBuffer[String] = new ListBuffer[String]()

        for (person <- persons) {
            if (person.age < 18) {
                minors += person
            } else {
                adults += person
            }
        }

        var sortedBoys = minors.toList.sortBy(_.age)
        var sortedMen = adults.toList.sortBy(_.age)

        for (minor <- sortedBoys) {
            minorNames += minor.firstName
        }
        for (man <- sortedMen) {
            adultNames += man.firstName
        }
        List(minorNames.toList, adultNames.toList)
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