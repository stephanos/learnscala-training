package de.learnscala.beispiele
package bool

/**
 * Infix-Notation
 */
class Bool(x: Boolean) {

    def and(that: Bool) =
        if (x) that else this

    def or(that: Bool) =
        if (x) this else that

    def negate =
        new Bool(!x)
}


object Main extends App {

    val TRUE = new Bool(true)
    val FALSE = new Bool(false)

    def not(x: Bool) =
        x negate

    def xor(x: Bool, y: Bool) =
        (x or y) and not(x and y) // alternative: x.or(y).and(x.and(y).negate)


    println(not(TRUE))
    println(xor(TRUE, FALSE))
}