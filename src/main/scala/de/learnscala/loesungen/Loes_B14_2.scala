package de.learnscala.loesungen

import de.learnscala.base.Solution
import java.io._

class Loes_B14_2 extends Solution {

    task(1) {

        def nameOfSymbol(symbol: Char): String =
            symbol match {
                case 'Π' => "Kreiszahl"
                case '√' => "Wurzel"
                case '!' => "Fakultät"
                case '∑' => "Summe"
                case _ => "Unbekannt"
            }
    }

    // ===============================================================

    task(2) {

        def isWorkingDay(day: String): Boolean =
            day match {
                case "Sunday" | "Saturday" => false
                case _ => true
            }
    }

    // ===============================================================

    task(3) {

        def nameOfType(value: Any): String =
            value match {
                case "" => "leerer String"
                case s: String => "String mit der Länge " + s.length
                case i: Int if i > 0 => "ein positiver Integer"
                case i: Int if i < 0 => "ein negativer Integer"
                case _ => "Unbekannt"
            }
    }

    // ===============================================================

    task(4) {

        def half(n: Int) = {
            if (n % 2 != 0) throw new RuntimeException("n must be even")
            n / 2
        }
    }

    // ===============================================================

    task(5) {

        def getSize(s: String): Int =
            try {
                s.length
            } catch {
                case e: Throwable => 0
            }
    }

    // ===============================================================

    task(6) {

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
}
