package de.learnscala.test.base

import scala.reflect.runtime.universe._
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.execute.Pending
import org.specs2.specification.Example

/**
 * http://etorreborre.github.com/specs2/guide/org.specs2.guide.Matchers.html#Custom
 */
trait Matchers {

    self: Reflect with SpecificationWithJUnit =>

    def mustHaveMethod[T : TypeTag](name: String)(f: (MethodSymbol) => Example) = {
        getMethod[T](name) match {
            case Some(m) =>
                f apply m
            case _ =>
                "must be defined" >> {
                    Pending()
                }
        }
    }

    def mustHaveParams(m: MethodSymbol, types: List[_]) = {
        "must have " + types.size + " parameter" >> {
            getParams(m) aka "parameter list" must haveSize(0)
        }
        // TODO
    }

    def mustHaveType(m: MethodSymbol, t: Any) = {
        // TODO
    }
}