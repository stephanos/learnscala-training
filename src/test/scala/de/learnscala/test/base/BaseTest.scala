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
import de.learnscala.base.Disabled

@RunWith(classOf[JUnitRunner])
abstract class BaseTest[T : TypeTag]
    extends SpecificationWithJUnit with Mockito with ScalaCheck
    with Reflect with Capture with Matchers {

    type

    // execute sequentially
    sequential

    // hook push into lifecycle
    args.report(exporter = "de.learnscala.test.base.Export")

    // Around: stop execution if failed
    case class WhenFail() extends Around {

        private var mustStop = false

        def around[R <% Result](r: => R) = {
            if (mustStop)
                Skipped("(a previous test failed)")
            else if (!r.isSuccess) {
                mustStop = true
                r
            }
            else
                r
        }
    }

    def task(n: Int)(name: String, typeOf: String = "")(fn: (String, Any) => Example): Example = {
        ("Task #" + n + ": " + typeOf + " '" + name + "'") >> {
            try {
                //step(args(stopOnFail = true))
                val target = getInstance[T]()
                if(!target.isInstanceOf[Disabled])
                    fn apply (name, target)
                else
                    "exercise disabled" >> {
                        Skipped()
                    }
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