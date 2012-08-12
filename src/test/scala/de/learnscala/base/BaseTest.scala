package de.learnscala.base

import org.junit.runner._

import org.specs2.mock.Mockito
import org.specs2.specification._
import org.specs2.execute.Result
import org.specs2.runner.JUnitRunner
import org.specs2.SpecificationWithJUnit
import org.specs2.execute.Skipped

@RunWith(classOf[JUnitRunner])
abstract class BaseTest(val code: String)
    extends SpecificationWithJUnit with Mockito //with ScalaCheck
    with Target with Reflect with Capture with Matchers {


    "### " + code + " ###".title


    // hook push update into lifecycle
    args.report(exporter = "de.learnscala.base.Push",
        notifier = "de.learnscala.base.MyNotifier")


    // alias type
    type FS = Fragments


    // list of spec fragments
    def specs: Fragments


    // execution steps
    override def is = {
        sequential ^ specs
    }


    abstract case class Task(num: Int, descr: String) extends org.specs2.Specification with Around {

        private var mustStop = false

        def specs: Fragments

        def around[R <% Result](r: => R) = {
            println("AROUND")
            if (mustStop) Skipped("one example failed")
            else if (!r.isSuccess) {
                mustStop = true
                r
            }
            else r
        }

        override def is = {
            val heading = "Task #" + num + " ('" + descr + "') should"
            sequential ^ endbr ^ heading ^ specs
        }
    }

}