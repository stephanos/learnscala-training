package de.learnscala.loesungen.old

import de.learnscala.base.Solution

object L312 extends Solution {

    /**
     * Eine Markdown-ähnliche Sprache wird erstellt.
     *
     * Bestimmte Formatierungen wie Links und Fett werden häufiger gebraucht,
     * daher werden die speziellen Funktionen 'printLink' und 'printBold' gebraucht.
     */

    def printEnclosed(left: String, text: String, right: String) {
        println(left + text + right)
    }

    def printLink =
        printEnclosed("[", (_: String), "]")

    def printBold =
        printEnclosed("#", (_: String), "#")


    def shout() =
        printBold("SCALA")

    def google() =
        printLink("http://google.com")
}