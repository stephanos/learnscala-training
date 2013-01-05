package de.learnscala.beispiele
package mirror

import scala.language.implicitConversions

object Main extends App {

    implicit class Mirror(s: String) {
        def mirror = s + (s.reverse)
    }

    println("Anna ".mirror)
}