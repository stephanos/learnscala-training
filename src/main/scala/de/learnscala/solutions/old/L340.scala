package de.learnscala.solutions.old

import de.learnscala.base.Solution

object L340 extends Solution {

    def until(condition: => Boolean)(block: => Unit) {
        if (!condition) {
            block
            until(condition)(block)
        }
    }

    /**
     * Gesucht wird eine Funktion 'until' die bewirkt, dass der Rückgabewert '10' ist.
     */
    def incr = {
        var i = 0
        until(i == 10) {
            i += 1
        }
        i
    }
}