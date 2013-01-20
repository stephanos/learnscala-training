package de.learnscala.loesungen

import de.learnscala.base.Solution
import java.io._

class Loes_B14_2 extends Solution {

  task(1) {

    def nameOfSymbol(symbol: Char): String =
      symbol match {
        case 'Π' => "pi"
        case '∑' => "sum"
        case '√' => "root"
        case '!' => "factorial"
        case _ => "unknown"
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

    def describeValue(value: Any): String =
      value match {
        case "" => "empty string"
        case s: String => "string of size " + s.length
        case i: Int if i > 0 => "positive integer"
        case i: Int if i < 0 => "negative integer"
        case _ => "unknown"
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
        case _: Throwable => 0
      }

  }

  // ===============================================================

  task(6) {

    def readCharFromFile(f: FileReader): Char =
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
