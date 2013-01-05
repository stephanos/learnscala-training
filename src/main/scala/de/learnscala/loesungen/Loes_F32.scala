package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_F32 extends Solution {

    task(1) {

        def until(condition: => Boolean)(block: => Unit) {
            if (!condition) {
                block
                until(condition)(block)
            }
        }

        def incr = {
            var i = 0
            until(i == 10) {
                i += 1
            }
            i
        }
    }

    // ===============================================================

    task(2) {

        /*
        def ?[T](test: Boolean)(fnThen: => T)(fnElse: => T) =
            if (test)
                fnThen
            else
                fnElse

        def print2Digits(i: Int) {
            ?(i < 10) {
              print("0" + i)
            } {
              print(i)
            }
        }
        */
    }
}