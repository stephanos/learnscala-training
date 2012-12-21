package de.learnscala.test.base

import scala.reflect.runtime.universe._
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.execute.Pending
import org.specs2.specification.Example
import reflect.ClassTag

/**
 * http://etorreborre.github.com/specs2/guide/org.specs2.guide.Matchers.html#Custom
 */
trait Matchers {

    self: Reflect with SpecificationWithJUnit =>

    def mustHaveObject[T: TypeTag](name: String)(f: (Any) => Example): Example = {
        getObject[T](name) match {
            case Some(o) =>
                f apply o
            case _ =>
                ("must be defined: object '" + name + "'") >> {
                    Pending()
                }
        }
    }

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
                ("method '" + name + "' must be defined") >> {
                    Pending()
                }
        }


    def mustHaveParams(m: MethodSymbol, count: Int): Example = {
        "must have " + count + " parameter" >> {
            getParams(m) aka "parameter list" must haveSize(count)
        }
    }

    def mustHaveParams(m: MethodSymbol, types: Class[_]*): Example = {
        mustHaveParams(m, types.size)
        // TODO: check types
    }

    def mustHaveParams2(m: MethodSymbol, types: Class[_]*)(f: (MethodSymbol) => Example): Example = {
        val shouldHave = types.size
        val doesHave = getParams(m)

        if(shouldHave != doesHave.size) {
            "must have " + shouldHave + " parameter" >> {
                doesHave aka "parameter list" must haveSize(shouldHave)
            }
        }

        // TODO: check types ?

        f(m)
    }

    /*
    def methodMustHaveType[T: TypeTag](m: MethodSymbol, typ: T)(f: (MethodSymbol) => Example): Example = {
        val shouldHave = typ
        val doesHave = getReturnType(m)

        if(shouldHave != doesHave) {
            ("must have type: '" + name + "'") >> {
                Pending()
            }
        }

        f((m, shouldHave))
    }
    */

    def getList[T : ClassTag : TypeTag](obj: T, m: MethodSymbol)(f: Traversable[_] => Example): Example = {
        (invoke[T](obj, m)) match {
            case null => mustNotBeNull()
            case l: Traversable[Any] => f(l)
            case _ => mustHaveType("List")
        }
    }

    def mustHaveType(t: String): Example = {
        ("must have type: '" + t + "'") >> {
            Pending()
        }
    }

    def mustNotBeNull(): Example = {
        ("must not be null") >> {
            Pending()
        }
    }
}