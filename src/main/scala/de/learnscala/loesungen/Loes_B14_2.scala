package de.learnscala.loesungen

import de.learnscala.base.Solution
import java.io._

class Loes_B14_2 extends Solution {

    /**
     * Aufgabe #1
     *
     * Gibt den Namen der mathematischen Symbole zurück: Π, √, ! und ∑
     */
    def nameOfSymbol(symbol: Char): String =
        symbol match {
            case 'Π' => "Kreiszahl"
            case '√' => "Wurzel"
            case '!' => "Fakultät"
            case '∑' => "Summe"
            case _ => "Unbekannt"
        }

    // ===============================================================

    /**
     * Aufgabe #2
     *
     * Ermittelt ob ein Wochentag ein Arbeitstag ist.
     */
    def isWorkingDay(day: String): Boolean =
        day match {
            case "Sunday" | "Saturay" => true
            case _ => false
        }

    // ===============================================================

    /**
     * Aufgabe #3
     *
     * Gibt vom übergebenen Wert den Namen des Typs zurück.
     */
    def nameOfType(value: Any): String =
        value match {
            case _: Boolean => "Boolean"
            case _: Char => "Char"
            case _: Int => "Int"
            case _: Float => "Float"
            case _: String => "String"
            case _ => "Unbekannt"
        }

    // ===============================================================

    /**
     * Aufgabe #4
     *
     * Berechnet die Hälfte einer Zahl,
     * wirft jedoch eine Exception wenn die Zahl nicht ganzzahlig teilbar ist.
     */
    def half(n: Int) =
        if (n % 2 == 0)
            n / 2
        else
            throw new RuntimeException("n must be even")

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
    def readCharFromFile(f: FileReader): Char = {
        try {
            f.read().toChar
        } catch {
            case e: FileNotFoundException =>
                println("not found")
                0
            case e: IOException =>
                println("cannot read")
                0
            case e: RuntimeException =>
                println("unknown error")
                0
        } finally {
            f.close()
        }
    }
}