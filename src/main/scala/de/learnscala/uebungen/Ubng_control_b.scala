package de.learnscala.uebungen

import java.io._
import de.learnscala.base._


class Ubng_control_b extends Exercise with Help /* with Disabled */ {

  /**
   * ANLEITUNG
   *
   * 1) Test ausführen
   * 2) Fehler beseitigen
   * 3) zurück zu Schritt 1
   *
   **/


  // ===============================================================

  task(1) {

    /**
     * Methode 'nameOfSymbol'
     *
     * @param symbol mathematisches Symbol
     * @return engl. Name des Symbols
     */

    def nameOfSymbol(symbol: Char) =
      TODO

  }

  // ===============================================================

  task(2) {

    /**
     * Methode 'isWorkingDay'
     *
     * @param day engl. Name des Wochentags
     * @return ob der Wochentag ein Arbeitstag ist
     *
     * @todo Methode muss kürzer und lesbarer werden!
     */

    def isWorkingDay(day: String) = {
      var res: Boolean = false
      day match {
        case "Monday" =>
          res = true
        case "Tuesday" =>
          res = true
        case "Wednesday" =>
          res = true
        case "Thursday" =>
          res = true
        case "Friday" =>
          res = true
        case _ =>
      }
      res
    }

  }

  // ===============================================================

  task(3) {

    /**
     * Methode 'describeValue'
     *
     * @param value ein Wert
     * @return englische Beschreibung des Wertes
     */

    def describeValue(value: Any) =
      TODO

  }

  // ===============================================================

  task(4) {

    /**
     * Methode 'half'
     *
     * @param n ganze Zahl
     * @return Hälfte der Zahl
     * @throws RuntimeException falls der Eingabewert nicht ganzzahlig teilbar ist
     */

    def half(n: Int) =
      TODO

  }

  // ===============================================================

  task(5) {

    /**
     * Methode 'getSize'
     *
     * @param s eine Zeichenkette
     * @return Länge des Strings
     */

    def getSize(s: String) =
      TODO

  }

  // ===============================================================

  task(6) {

    /**
     * BONUS-AUFGABE
     *
     * Methode 'readCharFromFile'
     *
     * @param f offener java.io.FileReader
     * @return erste Zeichen der Datei - oder '0' bei einem Fehler
     *
     * @note
         * Printet 'cannot read' bei 'IOException'
     *     Printet 'not found' bei 'RuntimeException'
     *     Printet 'not found' bei 'FileNotFoundException'
     *
     *     Und nicht vergessen den Reader zu schließen!
     */

    def readCharFromFile(f: FileReader) =
      TODO

  }
}