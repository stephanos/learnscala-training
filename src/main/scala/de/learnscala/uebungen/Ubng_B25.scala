package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_B25 extends Exercise with Help /* with Disabled */ {

    task {

        /**
         * Die Fibonacci-Folge ist eine unendliche Folge von Zahlen (den Fibonacci-Zahlen),
         * bei der sich die jeweils folgende Zahl durch Addition ihrer beiden vorherigen Zahlen ergibt:
         * 0, 1, 1, 2, 3, 5, 8, 13, …
         *
         * Wandle folgende Funktion in eine tail-rekursive Funktion um!
         */

        def fib(n: Int): BigInt =
            n match {
                case 0 => 0
                case 1 => 1
                case _ => fib(n - 1) + fib(n - 2)
            }

    }
}