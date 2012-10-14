package de.learnscala.test.base

import org.junit.runner._

import org.specs2.mock.Mockito
import org.specs2.specification._
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mutable.Around
import org.specs2.execute.{Skipped, Failure, Result}
import org.specs2.ScalaCheck

import scala.reflect.runtime.universe._
import de.learnscala.base._
import org.specs2.execute.Skipped
import org.specs2.execute.Failure

@RunWith(classOf[JUnitRunner])
abstract class BaseTest[T: TypeTag]
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
            println(r)
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
    //implicit val stop = WhenFail()

    def test(name: String, typeOf: String = "", prefix: String = "")(fn: (String, Testable) => Example): Example = {
        (prefix + typeOf + " '" + name + "'") >> {
            try {
                //step(args(stopOnFail = true))
                val target = getInstance[T]()
                if (!target.isInstanceOf[Disabled])
                    fn apply(name, target.asInstanceOf[Testable])
                else
                    "exercise disabled" >> {
                        Skipped()
                    }
            } catch {
                case e: Throwable =>
                    "failed to initiate exercise" >> {
                        e.printStackTrace()
                        Failure()
                    }
            }
        }
    }

    def task(n: Int)(name: String, typeOf: String = "")(fn: (String, Testable) => Example): Example =
        test(name, typeOf, "Task #" + n + ": ")(fn)
}