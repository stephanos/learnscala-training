package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_F21 extends Exercise with Help /* with Disabled */ {


  /**
   * Für die folgenden Aufgaben sollte die offizielle Scala API-Dokumentation verwendet werden!
   *
   * @see http://www.scala-lang.org/api/current/index.html
   *
   * @note Es wird niemals mehr als 1 Zeile benötigt!
   */


  /////////////////////////////////////////////////////////
  // Traversable

  task(1) {
    /**
     * Konvertiert Elemente von Traversable in einen String der Form "[1,2,3]".
     */
    def toString(t: Traversable[Int]) =
      TODO
  }

  task(2) {
    /**
     * Hängt Argument 2 an Argument 1.
     */
    def join(t1: Traversable[Int], t2: Traversable[Int]) =
      TODO
  }

  task(3) {
    /**
     * Liefert die ersten beiden Elemente des Traversable.
     */
    def first2(t: Traversable[Int]) =
      TODO
  }

  task(4) {
    /**
     * Summiert die Elemente des Traversable.
     */
    def sumOf(t: Traversable[Int]) =
      TODO
  }

  task(5) {
    /**
     * Ermittelt die Länge des Traversable.
     */
    def length(t: Traversable[Int]) =
      TODO
  }

  task(6) {
    /**
     * Entfernt das erste Element des Traversable.
     */
    def withoutFirst(t: Traversable[Int]) =
      TODO
  }

  task(7) {
    /**
     * Ermittelt das größte Elemente desTraversable.
     */
    def biggest(t: Traversable[Int]) =
      TODO

  }

  /////////////////////////////////////////////////////////
  // List

  task(8) {
    /**
     * Erstellt eine Liste aus den 3 Elementen
     */
    def makeList(e1: Int, e2: Int, e3: Int) =
      TODO

  }

  task(9) {
    /**
     * Erstellt aus Parameter eine Liste ohne Duplikate.
     */
    def unique(l: List[Int]) =
      TODO
  }


  task(10) {
    /**
     * Kehrt die Reihenfolge der Liste um
     */
    def backwards(l: List[Int]) =
      TODO
  }

  /////////////////////////////////////////////////////////
  // Set

  task(11) {
    /**
     * Ermittelt ob das Set die Elemente 42 und 101 enthält.
     */
    def has42and101(s: Set[Int]) =
      TODO

  }

  task(12) {
    /**
     * Kombiniert Argument 1 und Argument 2
     */
    def mergeSet(s1: Set[Int], s2: Set[Int]) =
      TODO
  }

  /////////////////////////////////////////////////////////
  // Map

  task(13) {
    /**
     * Entfernt Schlüssel '42' aus der Map.
     */
    def withoutKey42(m: Map[Int, Boolean]) =
      TODO
  }

  task(14) {
    /**
     * Ermittelt ob Map den Schlüssel '42' enthält.
     */
    def hasKey42(m: Map[Int, Boolean]) =
      TODO
  }

  task(15) {
    /**
     * Liefert alle Schlüssel der Map
     */
    def allKeys(m: Map[Int, Boolean]) =
      TODO
  }
}