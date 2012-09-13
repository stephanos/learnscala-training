package de.learnscala.examples
package retry

object Retry {

    @annotation.tailrec
    def retry[T](n: Int)(fn: => T): T = {
        try {
            return fn
        } catch {
            case e if n > 1 => // ignore
        }
        retry(n - 1)(fn)
    }
}

object Main extends App {

    import Retry._

    def connectToDatabase() {
        if(util.Random.nextBoolean()) {
            val m = "unable to connect"
            println(m)
            sys.error(m)
        }
    }

    retry(3) {
        connectToDatabase()
    }
}