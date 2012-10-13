package de.learnscala.test.base

import scala.reflect.runtime.universe.MethodSymbol
import org.specs2.mutable.SpecificationWithJUnit

/**
 * http://etorreborre.github.com/specs2/guide/org.specs2.guide.Matchers.html#Custom
 */
trait Matchers {

    self: Reflect with SpecificationWithJUnit =>

    def haveSignature(m: MethodSymbol, types: List[_]) {
        getParams(m) aka "parameter list" must haveSize(0)
        // TODO
    }

    /*
    def haveMember[T : TypeTag](name: => String) =
        beSome ^^ { (obj: T) => getMember[T](name) }
    */
}