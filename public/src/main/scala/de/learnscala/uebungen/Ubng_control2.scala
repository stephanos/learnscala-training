package de.learnscala.uebungen

import de.learnscala.base._
import java.io.{FileInputStream, File, Closeable}

class Ubng_control2 extends Exercise with Help /* with Disabled */ {

  /**
   * Die folgenden 4 Aufgaben-Blöcke beinhalten auskommentierten Quellcode.
   *
   * Entfernen Sie die Kommentare und stellen Sie den Compiler zufrieden!
   */


  <!-- ################################################################################## -->


  /**
   * Kontrollstruktur 'until'
   *
   * 'until' führt so lange einen Block aus, bis die Bedingung wahr ist.
   *
   * @note Closure, Rekursion
   */

  DEFINE_METHOD_HERE


  task(1) {

    def count(till: Int) {
      var i = 0
      /*
      until(i == till) {
        print(i + " ")
        i += 1
      }
      */
    }
  }


  <!-- ################################################################################## -->

  /**
   * Kontrollstruktur 'catching'
   *
   * 'catching' fängt alle möglichen Fehler eines Blocks - es liefert daher ein 'Option'.
   *
   * @note Some / None
   */

  DEFINE_METHOD_HERE


  task(2) {
    def convertToInt(s: String): Option[String] = {
      MAKE_THE_FOLLOWING_WORK // catching { s.toInt }
    }
  }


  <!-- ################################################################################## -->

  /**
   * Kontrollstruktur 'withResource'
   *
   * 'withResource' wendet eine Funktion auf eine Resource an und schließt diese
   * in jedem Fall (ob Fehler oder nicht) automatisch. Das Ergebnis ist vom Typ 'Option'.
   *
   * @note 'Closeable'
   */

  DEFINE_METHOD_HERE


  task(3) {
    def readFile(f: File): Option[String] = {
      MAKE_THE_FOLLOWING_WORK
      /*
      withResource(new FileInputStream(f)) { stream =>
        val bytes = new Array[Byte](f.length.toInt)
        stream.read(bytes)
        new String(bytes, "UTF-8")
      }
      */
    }
  }


  <!-- ################################################################################## -->

  /**
   * BONUS (schwierig!)
   * Kontrollstruktur 'ternary'
   *
   * Benötigt wird eine Kontrollstruktur, ähnlich dem ternären Operator ? bzw. : aus Java:
   * Abhängig von einem Wahrheitswert wird entweder der erste oder der zweite Block ausgeführt.
   *
   * @note implicit, innere Klasse & Operatoren
   */

  DEFINE_CLASS_HERE


  task(4) {
    def printTime(hour: Int, min: Int) {
      MAKE_THE_FOLLOWING_WORK
      /*
      (hour < 10) ? print("0" + hour) | print(hour)
      print(":")
      (min < 10) ? print("0" + min) | print(min)
      */
    }
  }
}