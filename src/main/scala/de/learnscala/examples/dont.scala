package de.learnscala.examples
package dont

object Dont {

    def dont(code: => Unit) = new DontCommand(code)

    class DontCommand(code: => Unit) {

        def unless(condition: => Boolean) {
            if (condition) code
        }

        def until(condition: => Boolean) {
            while (!condition) {}
            code
        }
    }

}

object Main {

    import Dont._

    dont {
        println("Yep, 2 really is greater than 1.")
    } unless (2 > 1)
}