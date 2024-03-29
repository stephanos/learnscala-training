package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_data2 extends Exercise with Help /* with Disabled */ {


  /**
   * Für die folgenden Aufgaben sollte die offizielle Scala API-Dokumentation verwendet werden!
   *
   * @see http://www.scala-lang.org/api/current/index.html
   *
   * @note Es wird niemals mehr als 1 Zeile benötigt!
   * @note Die API-Dokumentation kann je nach Klassen und Methoden durchsucht werden!
   */


  /** ====================================================================================
   * Traversable
   * ====================================================================================*/

  task(1) {
    /**
     * Konvertiert Elemente von Traversable in einen String der Form "[1,2,3]".
     */
    def toString(t: Traversable[Int]) =
      FILL_IN_BODY_HERE
  }

  task(2) {
    /**
     * Hängt Argument 2 an Argument 1.
     */
    def join(t1: Traversable[Int], t2: Traversable[Int]) =
      FILL_IN_BODY_HERE
  }

  task(3) {
    /**
     * Liefert die ersten beiden Elemente des Traversable.
     */
    def first2(t: Traversable[Int]) =
      FILL_IN_BODY_HERE
  }

  task(4) {
    /**
     * Summiert die Elemente des Traversable.
     */
    def sumOf(t: Traversable[Int]) =
      FILL_IN_BODY_HERE
  }

  task(5) {
    /**
     * Ermittelt die Länge des Traversable.
     */
    def length(t: Traversable[Int]) =
      FILL_IN_BODY_HERE
  }

  task(6) {
    /**
     * Entfernt das erste Element des Traversable.
     */
    def withoutFirst(t: Traversable[Int]) =
      FILL_IN_BODY_HERE
  }

  task(7) {
    /**
     * Ermittelt das größte Elemente desTraversable.
     */
    def biggest(t: Traversable[Int]) =
      FILL_IN_BODY_HERE
  }


  /** ====================================================================================
  * List
  * ====================================================================================*/

  task(8) {
    /**
     * Erstellt eine Liste aus den 3 Elementen
     */
    def makeList(e1: Int, e2: Int, e3: Int) =
      FILL_IN_BODY_HERE

  }

  task(9) {
    /**
     * Erstellt aus Parameter eine Liste ohne Duplikate.
     */
    def unique(l: List[Int]) =
      FILL_IN_BODY_HERE
  }


  task(10) {
    /**
     * Kehrt die Reihenfolge der Liste um
     */
    def backwards(l: List[Int]) =
      FILL_IN_BODY_HERE
  }


  /** ====================================================================================
  * Set
  * ====================================================================================*/

  task(11) {
    /**
     * Ermittelt ob das Set die Elemente 42 und 101 enthält.
     */
    def has42and101(s: Set[Int]) =
      FILL_IN_BODY_HERE
  }

  task(12) {
    /**
     * Kombiniert Argument 1 und Argument 2
     */
    def mergeSet(s1: Set[Int], s2: Set[Int]) =
      FILL_IN_BODY_HERE
  }


  /** ====================================================================================
  * Map
  * ====================================================================================*/

  task(13) {
    /**
     * Entfernt Schlüssel '42' aus der Map.
     */
    def withoutKey42(m: Map[Int, Boolean]) =
      FILL_IN_BODY_HERE
  }

  task(14) {
    /**
     * Ermittelt ob Map den Schlüssel '42' enthält.
     */
    def hasKey42(m: Map[Int, Boolean]) =
      FILL_IN_BODY_HERE
  }

  task(15) {
    /**
     * Liefert alle Schlüssel der Map
     */
    def allKeys(m: Map[Int, Boolean]) =
      FILL_IN_BODY_HERE
  }
}