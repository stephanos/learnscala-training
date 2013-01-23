package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_func3_a extends Exercise with Help /* with Disabled */ {

  /**
   * @todo Passen Sie folgende Methoden 'r' an, so dass das Ergebnis den Tests entspricht!
   *
   * @note doe Lösungen passen alle in 1-2 Zeilen!
   */


  /** ====================================================================================
   * Teil #1: foreach
   * ====================================================================================*/

  task(1) {

    /**
     * Methode gibt die Zahlen der Liste aus
     */

    def r {
      List(1, 2, 3)
    }
  }

  task(2) {

    /**
     * Methode gibt Namen die mit 'y' enden aus
     */

    def r {
      List("Mary", "John", "Paul", "Barry")
    }
  }


  /**
   * Teil #2: filter
   */

  task(3) {

    /**
     * Methode liefert Teilliste mit den geraden Zahlen heraus
     */

    def r =
      List(1, 2, 3, 4)
  }

  task(4) {

    /**
     * Methode liefert Teilliste mit einstelligen Zahlen
     */

    def r =
      List(1, 9, 43, 100, 321, 23)
  }

  task(5) {

    def polls =
      List(("CDU" -> 35), ("SPD" -> 35), ("Grüne" -> 15), ("FDP" -> 6), ("Piraten" -> 4), ("Linke" -> 5))

    /**
     * Methode liefert Teilliste mit den Parteien, die die 5%-Hürde nicht geschafft haben
     */

    def r =
      polls
  }


  /**
   * Teil #3: map
   */

  task(6) {

    /**
     * Methode liefert Liste mit verdoppelten Elementen
     */

    def r =
      List(1, 2, 3, 4)
  }

  task(7) {

    /**
     * Methode transformiert Inhalt der Box zu Großbuchstaben
     */

    def r(opt: Option[String]): Option[String] =
       opt
  }

  task(8) {

    /**
     * Methode bildet Spitznamen: Hängt den letzten Buchstaben und "y" an
     *
     * @note um den letzten Buchstaben zu bekommen, behandle einen String wie eine Liste ...
     */

    def r =
      List("Jim", "Bob", "John")
  }

  /**
   * Teil #4: other
   *
   * @note Nicht verzagen, API-Dokumentation oder Präsentationsfolien fragen!
   */

  task(9) {

    /**
     * Methode plättet die 2 Listen zu 1 einzelnen
     */

    def r =
      List(List("o", "u", "i", "e", "a"), List("ü", "ä", "ö"))
  }

  task(10) {

    /**
     * Methode teilt Liste in 2 Teile: Mädchen links (Namen enden mit "a"), Jungen rechts
     */

    def r: (List[String], List[String]) =
      null // List("Anna", "John", "Maria", "Adam")
  }

  task(11) {

    def isPrime(n: Int) = (((1 to n).toList) count { i => n % i == 0 }) == 2

    /**
     * Methode testet ob Liste eine Primzahl beinhaltet
     *
     * @note ruhig die Hilfsmethode 'isPrime' benutzen - oder selbst schreiben ;-)
     */

    def r(nums: List[Int]) =
      false
  }

}