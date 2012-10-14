package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_F12 extends Exercise with Help /* with Disabled */ {

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