package de.learnscala.loesungen

import de.learnscala.base.Solution
import java.io._

class Loes_B14_2 extends Solution {

    /**
     * Aufgabe #1
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
     */
    def isWorkingDay(day: String): Boolean =
        day match {
            case "Sunday" | "Saturay" => false
            case _ => true
        }

    // ===============================================================

    /**
     * Aufgabe #3
     */
    def nameOfType(value: Any): String =
        value match {
            case s: String if(s.length > 0) => "String mit der Länge " + s.length
            case _: String => "leerer String"
            case i: Int if i > 0 => "ein positiver Integer"
            case i: Int if i < 0 => "ein negativer Integer"
            case _ => "Unbekannt"
        }

    // ===============================================================

    /**
     * Aufgabe #4
     */
    def half(n: Int) =
        if (n % 2 == 0)
            n / 2
        else
            throw new RuntimeException("n must be even")

    // ===============================================================

    /**
     * Aufgabe #5
     */
    def getSize(s: String): Int =
        try {
            s.length
        } catch {
            case e: Throwable => 0
        }

    // ===============================================================

    /**
     * Aufgabe #6
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