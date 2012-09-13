package de.learnscala.examples

package object breakloop {

    object Break extends RuntimeException
    object Continue extends Exception

    def break {
        throw Break
    }

    def continue {
        throw Continue
    }

    def whileTrue(block: => Unit) {
        try {
            try {
                while (true) try {
                    block
                }
                catch {
                    case Continue =>
                }
            }
            catch {
                case Break =>
            }
        }
    }

    def whileTrue(condition: => Boolean)(block: => Unit) {
        try {
            while (condition)
                try {
                    block
                }
                catch {
                    case Continue =>
                }
        }
        catch {
            case Break =>
        }
    }


    // =====
    // TEST
    // =====
    object Main extends App {

        var i = 0
        whileTrue {
            println(i)
            i += 1
            if (i < 3) continue
            if (i >= 5) break
        }
    }
}