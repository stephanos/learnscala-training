package de.learnscala.uebungen

import de.learnscala.base.Uebung

object U340 extends Uebung(enabled = true) {

    def until(condition: => Boolean)(block: => Unit) {
        if (!condition) {
            block
            until(condition)(block)
        }
    }

    /**
     * Definiere eine Funktion 'until' die bewirkt, dass der Rückgabewert '10' ist.
     */
    def incr = {
        var i = 0
        until(i == 10) {
            i += 1
        }
        i
    }
}