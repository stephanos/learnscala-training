package de.learnscala.base

import org.junit.runner._

import org.specs2.mock.Mockito
import org.specs2.specification._
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.SpecificationWithJUnit

@RunWith(classOf[JUnitRunner])
abstract class BaseTest(val code: String)
    extends SpecificationWithJUnit with Mockito //with ScalaCheck
    with Target with Reflect with Capture with Matchers {

    // execute sequentially
    sequential


    // hook push update into lifecycle
    args.report(notifier = "de.learnscala.base.Push")


    // alias type
    type FS = Fragments



    /*
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

        "Task #" + num + " ('" + descr + "') should".title

        override def is = {
            sequential ^ endbr ^ specs
        }
    }
    */
}