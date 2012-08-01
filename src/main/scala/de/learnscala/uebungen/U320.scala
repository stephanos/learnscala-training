package de.learnscala.uebungen

import de.learnscala.base.Uebung

object U320 extends Uebung(enabled = true) {

    /* TODO: for-expression */

    case class Book(title: String, authors: List[String])

    val books: List[Book] = List(
        Book("Structure and Interpretation of Computer Programs",
            List("Abelson, Harold", "Sussman, Gerald J.")),
        Book("Principles of Compiler Design",
            List("Aho, Alfred", "Ullman, Jeffrey")),
        Book("Introduction to Functional Programming",
            List("Bird, Richard")),
        Book("The Java Language Specification",
            List("Gosling, James", "Joy, Bill", "Steele, Guy", "Bracha, Gilad"))
    )


    for (b <- books; a <- b.authors if a startsWith "Bird") yield b.title
    for (b <- books; a <- b.authors if a startsWith "Ullman") yield b.title
    for (b <- books if (b.title indexOf "Program") >= 0) yield b.title
    for (b <- books if (b.title indexOf "Program") >= 0) yield b.title
    for (b1 <- books; b2 <- books if b1 != b2; a1 <- b1.authors; a2 <- b2.authors if a1 == a2) yield a1

    def removeDuplicates[A](xs: List[A]): List[A] =
        if (xs.isEmpty) xs
        else xs.head :: removeDuplicates(xs.tail filter (x => x != xs.head))

    //xs.head :: removeDuplicates(for (x <- xs.tail if x != xs.head) yield x)
}