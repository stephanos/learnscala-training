package de.learnscala.loesungen

import de.learnscala.base.Solution

object Loes_B14_1 extends Solution {

    /**
     * Task #1
     */
    def isTheAnswerToLifeTheUniverseAndEverything(n: Int) =
        n == 42


    /**
     * Task #2
     */
    def signum(n: Int) =
        if (n == 0) 0
        else {
            if (n > 0) 1 else -1
        }


    /**
     * Task #3
     */
    def absMax(n1: Int, n2: Int) =
        if (Math.abs(n1) > Math.abs(n2)) n1 else n2


    import scala.reflect.runtime.universe._
    import scala.reflect.runtime.{currentMirror => cm}
    import scala.reflect.ClassTag

    class Foo{
     object R { override def toString = "R" }
     def foo = {
      val classTag = implicitly[ClassTag[R.type]]
      val sym = cm.moduleSymbol(classTag.runtimeClass)
      try {
        val cls = cm.reflectModule(sym)
        cls.instance
        println("this indicates a failure")
      } catch {
        case ex: Throwable =>
          println(ex.getMessage)
      }
     }
    }

    object Test extends App{
      val foo = new Foo
      println(foo.foo)
    }
}