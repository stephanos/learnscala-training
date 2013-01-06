package de.learnscala.test.base

import org.specs2._
import mock.Mockito
import specification._
import execute._

import de.learnscala.base._
import scala.reflect.runtime.universe._

abstract class BaseTest[T: TypeTag]
    extends SpecificationWithJUnit with Mockito with ScalaCheck
    with Reflect with Capture with Matchers with StopOnFail {

    def fs: Fragments =
        sys.error("overwrite 'fs'")

    final def is =
        args.report(exporter = "de.learnscala.test.base.Export") ^ // hook push into lifecycle
            showOnly("+x!*-") ^ // hide "skipped" results
            sequential ^ // don't execute in parallel
            fs ^
            end // end test


    // SHARED =====================================================================================

    protected def test(name: String, typeOf: String = "", prefix: String = "")(fn: TaskContext => Fragments) =
        task(1)(name, typeOf)(fn)

    protected def task(n: Int)(name: String, typeOf: String = "")(fn: TaskContext => Fragments) =
        _test(n, name, typeOf, "Task #" + n)(fn)


    // INTERNALS ==================================================================================

    private def _test(n: Int, name: String, typeOf: String, prefix: String = "")(fn: TaskContext => Fragments): Fragments = {
        val tasks = getInstance[T]().asInstanceOf[Testable].tasks.toList
        val r: Fragments =
            if (tasks.length >= n) {
                val descr = prefix + ": " + typeOf + " '" + name + "'"
                val tsk = tasks(n - 1)
                (if (tsk == null)
                    descr ^ {
                        "implementation missing" ! {
                            Failure("no code found")
                        }
                    }
                else
                    descr ^ {
                        fn apply (new TaskContext(name, tasks(n - 1)))
                    }
                    ) ^ startBlock ^ p
            } else
                Failure("unable to test task #" + n + ": not enough elements")
        r
    }
}

trait StopOnFail extends AroundExample {

    self: Specification =>

    // make sure the specification is sequential
    // override def map(fs: => Fragments) = sequential ^ fs

    private var mustStop = false

    override protected def around[R: AsResult](ar: => R): Result = {
        val r = AsResult(ar)
        if (mustStop) Skipped("one example failed")
        else if (!r.isSuccess) {
            mustStop = true
            r
        }
        else r
    }

    def startBlock = Action(mustStop = false)
}