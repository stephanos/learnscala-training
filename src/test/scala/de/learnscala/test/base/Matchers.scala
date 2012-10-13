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

    def mustHaveValue[T: TypeTag](name: String)(f: (TermSymbol) => Example): Example =
        getVal[T](name) match {
            case Some(v) =>
                f apply v
            case _ =>
                ("must be defined: '" + name + "'") >> {
                    Pending()
                }
        }

    def mustHaveMethod[T: TypeTag](name: String)(f: (MethodSymbol) => Example): Example =
        getMethod[T](name) match {
            case Some(m) =>
                f apply m
            case _ =>
                ("must be defined: '" + name + "'") >> {
                    Pending()
                }
        }


    def mustHaveParams(m: MethodSymbol, types: Class[_]*) = {
        val size = types.size
        "must have " + size + " parameter" >> {
            getParams(m) aka "parameter list" must haveSize(size)
        }
        // TODO: check types
    }

    def mustHaveType(m: MethodSymbol, t: Any) = {
        // TODO
    }
}