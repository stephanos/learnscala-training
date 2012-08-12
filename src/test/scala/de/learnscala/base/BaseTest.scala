package de.learnscala.base

import org.junit.runner._

import org.specs2.mock.Mockito
import org.specs2.specification._
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mutable.Around
import org.specs2.execute.{Skipped, Result}

@RunWith(classOf[JUnitRunner])
abstract class BaseTest(val code: String)
    extends SpecificationWithJUnit with Mockito //with ScalaCheck
    with Target with Reflect with Capture with Matchers {

    // execute sequentially
    sequential

    // hook push into lifecycle
    args.report(notifier = "de.learnscala.base.Push")

    // Around: stop execution if failed
    case class WhenFail() extends Around {

        private var mustStop = false

        def around[R <% Result](r: => R) = {
            if (mustStop) Skipped("one example failed")
            else if (!r.isSuccess) {
                mustStop = true
                r
            }
            else r
        }
    }

}