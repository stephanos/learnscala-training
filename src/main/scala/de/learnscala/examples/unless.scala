package de.learnscala.examples
package unless

object Unless {

    def unless(condition: => Boolean)(body: => Unit) {
        if (!condition) body
    }
}

object Main extends App {

    import Unless._

    for (i <- 1 to 50)
        unless(i == 42) {
            println(i)
        }
}