package de.learnscala.test.base

import org.junit.runner._

import org.specs2.mock.Mockito
import org.specs2.specification._
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mutable.Around
import org.specs2.execute.Result
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

    protected def test(name: String, typeOf: String = "", prefix: String = "")(fn: (String, Task) => Example) {
        test(1, name, typeOf, prefix)(fn)
    }

    private def test(n: Int, name: String, typeOf: String, prefix: String)(fn: (String, Task) => Example) {
        (prefix) in {
            // + typeOf + " '" + name + "'"
            try {
                val tasks = getInstance[T]().asInstanceOf[Testable].tasks
                if (tasks.length >= n) {
                    val tsk = tasks(n - 1)
                    if (tsk != null)
                        fn apply(name, tsk)
                    else
                        sys.error("unable to test task #" + n + ": no element")
                } else
                    sys.error("unable to test task #" + n + ": not enough elements")

                /*
                //step(args(stopOnFail = true))
                if (!target.isInstanceOf[Disabled])
                else
                    "exercise disabled" >> {
                        Skipped()
                    }
                */
            } catch {
                case e: Throwable =>
                    val r: Example =
                        "failed to initiate exercise" >> {
                            e.printStackTrace()
                            Failure()
                        }
                    r
            }
        }
    }

    protected def task(n: Int)(name: String, typeOf: String = "")(fn: (String, Task) => Example) =
        test(n, name, typeOf, "Task #" + n)(fn)

}