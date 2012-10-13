package de.learnscala.exercises.old

import de.learnscala.base.Exercise

object U312 extends Exercise {


    /**
     * Eine Markdown-ähnliche Sprache wird erstellt.
     *
     * Bestimmte Formatierungen wie Links und Fett werden häufiger gebraucht,
     * daher werden die speziellen Funktionen 'printLink' und 'printBold' gebraucht.
     */

    def printEnclosed(left: String, text: String, right: String) {
        println(left + text + right)
    }


    def shout() =
        TODO // printBold("SCALA")

    def google() =
        TODO // printLink("http://google.com")
}