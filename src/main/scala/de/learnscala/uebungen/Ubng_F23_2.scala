package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_F23_2 extends Exercise with Help /* with Disabled */ {

    /**
     * Aufgabe #1
     *
     * Summiert die Elemente der Liste.
     */
    def sum(l: List[Int]) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #2
     *
     * Multipliziert alle Elemente der Liste (leere Liste ergibt 1).
     */
    def product(l: List[Int]) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #3
     *
     * Zählt die Elemente der Liste.
     */
    def count(l: List[Int]) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #4
     *
     * Liefert das letzte Ergebnis der Liste (leere Liste: None).
     */
    def last[A](list: List[A]) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #5
     *
     * Invertiert die Reihenfolge der Liste.
     */
    def reverse[A](list: List[A]) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #6
     *
     * Ermittelt ob ein Element Teil der Liste ist.
     */
    def contains[A](list: List[A], item: A) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #7
     *
     * Transformiert die Elemente der Liste durch Anwendung der übergebenen Funktion.
     */
    def map[A, B](list: List[A], f: A => B) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #8
     *
     * Filtert die Elemente aus der Liste heraus, bei denen die Funktion 'true' ergibt.
     */
    def filter[A](list: List[A], p: A => Boolean) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #9 (Bonus)
     *
     * Überarbeiten den folgenden imperativen Algorithmus.
     * Durch Verwendung der funktionalen Programmierung sollte der Code maximal 4 Zeilen lang sein!
     */
    def separateAdultsAndMinors(persons: List[(String, Int)]): (List[String], List[String]) = {

        import collection.mutable.ListBuffer

        var minors= new ListBuffer[(String, Int)]()
        var adults = new ListBuffer[(String, Int)]()
        var minorNames = new ListBuffer[String]()
        var adultNames = new ListBuffer[String]()

        for (i <- 0 to persons.size) {
            val person = persons(0)
            if (person._2 < 18) {
                minors += person
            } else {
                adults += person
            }
        }

        val sortedMinors = minors.toList.sortBy(_._2)
        val sortedAdults = adults.toList.sortBy(_._2)

        for (i <- 0 to sortedMinors.size) {
            val minor = sortedMinors(i)
            minorNames += minor._1
        }
        for (i <- 0 to sortedAdults.size) {
            val adult = sortedMinors(i)
            adultNames += adult._1
        }
        (minorNames.toList, adultNames.toList)
    }
}