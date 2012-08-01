package de.learnscala.uebungen

import de.learnscala.base.Uebung

object U312 extends Uebung(enabled = true) {

    def printEnclosed(left: String, text: String, right: String) =
        println(left + text + right)

    def printCode =
        printEnclosed("[", (_: String), "]")

    def printBold =
        printEnclosed("#", (_: String), "#")


    def shout() =
        printBold("SCALA")

    def google() =
        printCode("http://google.com")
}