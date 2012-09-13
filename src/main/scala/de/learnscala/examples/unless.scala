package de.learnscala.examples

package object unless {

    def unless(condition: => Boolean)(body: => Unit) {
        if (!condition) body
    }


    // =====
    // TEST
    // =====
    object Main extends App {

        for (i <- 1 to 50)
            unless(i == 42) {
                println(i)
            }
    }
}