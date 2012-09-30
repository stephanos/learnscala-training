package de.learnscala.examples
package loan

import java.io.{File, PrintWriter}

/**
 * Currying, Kontrollstruktur, Ausnahme
 */
object Loan {

    def withPrintWriter(file: File)(op: PrintWriter => Unit) {
        val writer = new PrintWriter(file)
        try {
            op(writer)
        } finally
        {
            writer.close()
        }
    }
}

object Main extends App {

    import Loan._

    withPrintWriter(new File("test.txt")) {
        writer =>
            writer.println(new java.util.Date)
    }
}