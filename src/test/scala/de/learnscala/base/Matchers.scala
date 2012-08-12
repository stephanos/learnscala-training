package de.learnscala.base

import scala.reflect.runtime.universe._
import org.specs2.SpecificationWithJUnit

/**
 * http://etorreborre.github.com/specs2/guide/org.specs2.guide.Matchers.html#Custom
 */
trait Matchers {

    self: Reflect with SpecificationWithJUnit =>


    def haveMember[T : TypeTag](name: => String) =
        beSome ^^ { (obj: T) => getMember[T](name) }
}