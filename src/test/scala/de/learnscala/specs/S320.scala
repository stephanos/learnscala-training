package de.learnscala.specs

import de.learnscala.uebungen.U320._
import de.learnscala.base.BaseTest

class S320 extends BaseTest {

    spec("U320", enabled) {

        "titlesWithAuthorMartin must have titles of books with author 'Martin'" >> {
            titlesWithAuthorMartin must_!= beNull
            titlesWithAuthorMartin must
                containAllOf(List("Programming In Scala", "Patterns of Enterprise Application Architecture"))
        }

        "isbnsWithAuthorS must have ISBNs of books where author's lastname starts with 'S'" >> {
            isbnsWithAuthorS must_!= beNull
            isbnsWithAuthorS must
                containAllOf(List("3868020640", "0321127420"))
        }

        "priceAndTitleOfScalaBooks must have list of title and prices where 'Scala' is in the title" >> {
            priceAndTitleOfScalaBooks must_!= beNull
            priceAndTitleOfScalaBooks must
                containAllOf(List(("Programming In Scala" -> 36.95f), ("Programming Scala" ->  27.95f),
                    ("Durchstarten mit Scala" -> 24.90f), ("Programming Scala" -> 22.95f)))
        }

        "titlesOutOfStock " >> {
            titlesOutOfStock must_!= beNull
            titlesOutOfStock must
                containAllOf(List("Java Virtual Machine", "Patterns of Enterprise Application Architecture"))
        }
    }
}