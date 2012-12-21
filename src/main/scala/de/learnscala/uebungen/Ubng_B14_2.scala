package de.learnscala.uebungen

import de.learnscala.base._
import java.io._

class Ubng_B14_2 extends Exercise with Help /* with Disabled */  {

    /**
     * ANLEITUNG
     *
     *    1) Test ausführen
     *    2) Fehler beseitigen
     *    3) zurück zu Schritt 1
     **/


    /**
     * Aufgabe #1
     *
     * Gibt den Namen der mathematischen Symbole zurück: Π, √, ! und ∑
     */
    Task(1) {
        def nameOfSymbol(symbol: Char) =
            TODO
    }

    // ===============================================================

    /**
     * Aufgabe #2
     *
     * Ermittelt ob ein Wochentag ein Arbeitstag ist.
     */
    Task(2) {
        def isWorkingDay(day: String) =
            TODO
    }

    // ===============================================================

    /**
     * Aufgabe #3
     *
     * Gibt vom übergebenen Wert den Namen des Typs zurück.
     */
    Task(3) {
        def nameOfType(value: Any) =
            TODO
    }

    // ===============================================================

    /**
     * Aufgabe #4
     *
     * Berechnet die Hälfte einer Zahl,
     * wirft jedoch eine Exception wenn die Zahl nicht ganzzahlig teilbar ist.
     */
    Task(4) {
        def half(n: Int) =
            TODO
    }

    // ===============================================================

    /**
     * Aufgabe #5
     *
     * Gibt die Länge des Strings zurück;
     * bei einem Fehler ist das Ergebnis 0.
     */
    Task(5) {
        def getSize(s: String) =
            TODO
    }

    // ===============================================================

    /**
     * Aufgabe #6 (Bonus - schwierig !)
     *
     * Liest das erste Zeichen einer Datei aus.
     *
     * Bei 'IOException' sollte 'cannot read' geloggt werden.
     * Bei 'RuntimeException' sollte 'not found' geloggt werden.
     * Bei 'FileNotFoundException' sollte 'not found' geloggt werden.
     *
     * PS: Nicht vergessen den Reader zu schließen!
     *
     * @param f der File Reader
     * @return erste Zeichen der Datei - oder '0' bei einem Fehler
     */
    Task(6) {
        def readCharFromFile(f: FileReader) =
            TODO
    }
}