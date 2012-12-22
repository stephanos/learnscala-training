package de.learnscala.test.base

import org.junit.runner._

import org.specs2._
import mock.Mockito
import specification._
import org.specs2.runner.JUnitRunner

import scala.reflect.runtime.universe._
import de.learnscala.base._
import org.specs2.execute.Failure

@RunWith(classOf[JUnitRunner])
abstract class BaseTest[T: TypeTag]
    extends SpecificationWithJUnit with Mockito with ScalaCheck
    with Reflect with Capture with Matchers {

    def is: Fragments = null

    // execute sequentially
    sequential

    // hook push into lifecycle
    args.report(exporter = "de.learnscala.test.base.Export")

    // Around: stop execution if failed
    /*
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
    */

    //implicit val stop = WhenFail()

    protected def test(name: String, typeOf: String = "", prefix: String = "")(fn: (String, Task) => Fragments) {
        test(1, name, typeOf, prefix)(fn)
    }

    private def test(n: Int, name: String, typeOf: String, prefix: String)(fn: (String, Task) => Fragments) =
        prefix ^ {
            // + typeOf + " '" + name + "'"
            try {
                val r: Fragments =
                    Failure("unable to test task #" + n + ": no element")
                r

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
                    val r: Fragments =
                        "failed to initiate exercise" ! {
                            e.printStackTrace()
                            Failure()
                        }
                    r
            }
        }


    private def test2(n: Int, name: String, typeOf: String, prefix: String)(fn: TaskContext => Fragments): Fragments =
        // + typeOf + " '" + name + "'"
        try {
            val tasks = getInstance[T]().asInstanceOf[Testable].tasks
            val r: Fragments =
                if (tasks.length >= n) {
                    val tsk = tasks(n - 1)
                    if (tsk != null)
                        prefix ^ {
                            fn apply (new TaskContext(name, tsk))
                        }
                    else
                        Failure("unable to test task #" + n + ": no element")
                } else
                    Failure("unable to test task #" + n + ": not enough elements")
            r

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
                Failure("failed to initiate exercise", e.getMessage, e.getStackTrace.toList)
        }

    protected def task(n: Int)(name: String, typeOf: String = "")(fn: (String, Task) => Fragments) =
        test(n, name, typeOf, "Task #" + n)(fn)

    protected def task2(n: Int)(name: String, typeOf: String = "")(fn: TaskContext => Fragments) =
        test2(n, name, typeOf, "Task #" + n)(fn)
}