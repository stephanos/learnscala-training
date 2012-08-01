package de.learnscala.uebungen

import de.learnscala.base.Uebung

object U223 extends Uebung(enabled = true) {

    /* TODO: Maps */

    val quotes =
        """
          |Scala is much more like a bazaar than a cathedral,
          |in the sense that it is designed to be extended and adapted by the people programming in it.
          |
          |Although a static type system certainly cannot replace unit testing,
          |it can reduce the number of unit tests needed by taking care of some properties
          |that would otherwise need to be tested.
          |
          |Although Scala is designed to help programmers build very large-scale systems,
          |it also scales down nicely to scripting.
        """.stripMargin


    def wordsByCount = {
        val map = Map(" " -> 0)
        val arr = quotes.split(' ')
        for(i <- 0 until arr.length) yield Map(i -> arr(i))
        map
    }

    print(wordsByCount)

    def wordsByLength = {

    }
}