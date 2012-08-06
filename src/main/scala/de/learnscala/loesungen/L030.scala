package de.learnscala.loesungen

import de.learnscala.base.Loesung

object L030 extends Loesung {

  /**
   * Bestätigt DIE Antwort '42' als richtig.
   */
  /*
  def isTheAnswerToLifeTheUniverseAndEverything(n: Int): Boolean =
      if(n == 42) true else false
  */

  object Test {

    def isTheAnswerToLifeTheUniverseAndEverything(n: Int): Boolean =
        if(n == 42) true else false
  }

  import scala.reflect.runtime.universe._

  // http://dcsobral.blogspot.ch/2012/07/json-serialization-with-reflection-in.html

  val tt = typeOf[Test.type]
  val mt = tt.member(newTermName("isTheAnswerToLifeTheUniverseAndEverything"))

  println(mt.typeSignature)
}