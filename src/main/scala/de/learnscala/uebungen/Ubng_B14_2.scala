package de.learnscala.uebungen

import de.learnscala.base._
import java.io._

class Ubng_B14_2 extends Exercise with Help /* with Disabled */  {

    /**
     * STEP-BY-STEP GUIDE:
     *    1) execute test
     *    3) fix error
     *    4) go to step 2
     **/

    /**
     * Aufgabe #1
     *
     * Gibt den Namen der mathematischen Symbole zurück: Π, √, ! und ∑
     */
    def nameOfSymbol(symbol: Char) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #2
     *
     * Ermittelt ob ein Wochentag ein Arbeitstag ist.
     */
    def isWorkingDay(day: String) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #3
     *
     * Gibt vom übergebenen Wert den Namen des Typs zurück.
     */
    def nameOfType(value: Any) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #4
     *
     * Berechnet die Hälfte einer Zahl,
     * wirft jedoch eine Exception wenn die Zahl nicht ganzzahlig teilbar ist.
     */
    def half(n: Int) =
        TODO

    // ===============================================================

    /**
     * Aufgabe #5
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
    def readCharFromFile(f: FileReader) = {
        TODO
    }
}