package de.learnscala.test.base

import org.junit.runner._

import org.specs2.mock.Mockito
import org.specs2.specification._
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mutable.Around
import org.specs2.execute.{Skipped, Result}
import org.specs2.ScalaCheck
import org.specs2.execute.Failure

import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
abstract class BaseTest[T : TypeTag]
    extends SpecificationWithJUnit with Mockito with ScalaCheck
    with Reflect with Capture with Matchers {

    // execute sequentially
    sequential

    // hook push into lifecycle
    args.report(exporter = "de.learnscala.test.base.Export")

    // Around: stop execution if failed
    case class WhenFail() extends Around {

        private var mustStop = false

        def around[R <% Result](r: => R) = {
            if (mustStop)
                Skipped("a previous test failed")
            else if (!r.isSuccess) {
                mustStop = true
                r
            }
            else
                r
        }
    }

    def task(n: Int)(name: String)(fn: (Any) => Example): Example = {
        ("Task #" + n + " ('" + name + "')") >> {
            try {
                fn(getInstance[T]())
            } catch {
                case e: Throwable =>
                    "instantiate exercise" >> {
                        Failure("Unable to initiate exercise!",
                            e.getMessage, e.getStackTrace.toList)
                    }
            }
        }
    }
}