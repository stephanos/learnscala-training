package de.learnscala.test.base

import org.specs2._
import main.Arguments
import mock.Mockito
import reporter.DefaultReporter
import specification._
import execute._

import de.learnscala.base._
import scala.reflect.runtime.universe._

abstract class BaseTest[T: TypeTag](continuous: Boolean = false)
  extends SpecificationWithJUnit with Mockito with ScalaCheck
  with Reflect with Capture with Matchers with StopOnFail {

  def twoPass = false

  def sendResults = false

  def fs: Fragments =
    sys.error("overwrite 'fs'")

  final def is =
    args.report(exporter = if (sendResults) "de.learnscala.test.base.Export" else "") ^ // hook push into lifecycle
      //showOnly("+x!*-") ^ // hide "skipped" results
      sequential ^ // don't execute in parallel
      fs ^
      end // end test

  override def map(fs: => Fragments) =
    if (twoPass) {
      val executed = silent.execute(fs)
      val filtered = executed.fs.zip(fs.fragments).collect {
        case (f1, f2) if (f1.stats.result.isSuccess || f1.stats.result.isFailure || f1.stats.result.isError) => f2
      }
      Fragments.createList(filtered: _*)
    } else
      super.map(fs)


  // SHARED =====================================================================================

  //protected def test(name: String, typeOf: String = "", prefix: String = "", descr: String = null)(fn: TaskContext => Fragments) =
  //    task(1)(name, typeOf, descr)(fn)

  protected def test(n: Int = 1)(name: String = "", typeOf: String = "", descr: String = null)(fn: TaskContext => Fragments) =
    _test(1, name, typeOf, "Task #" + n, descr)(fn)

  protected def task(n: Int)(name: String, typeOf: String = "", descr: String = null)(fn: TaskContext => Fragments) =
    _test(n, name, typeOf, "Task #" + n, descr)(fn)


  // INTERNALS ==================================================================================

  private object silent extends DefaultReporter {
    def export(implicit args: Arguments) =
      (s: ExecutingSpecification) => s.execute

    def execute(fs: Fragments) =
      report(new Specification {
        def is = sequential ^ fs ^ end
      })(Arguments())
  }

  private def _test(n: Int, name: String, typeOf: String, prefix: String = "", descr: String = null)(fn: TaskContext => Fragments): Fragments = {
    val tasks = getInstance[T]().asInstanceOf[Testable]._tasks
    val r: Fragments =
      if (tasks.size >= n) {
        val defDescr = prefix + ": " + typeOf + " '" + name + "'"
        val tsk = tasks(n)
        (if (tsk == null)
          descr ^ {
            "implementation missing" ! {
              Skipped("no code found")
            }
          }
        else
          (Option(descr).getOrElse(defDescr)) ^ {
            fn apply (new TaskContext(name, tasks(n)))
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