package de.learnscala.base

import org.junit.runner._

import org.specs2.mutable._
import org.specs2.runner._
import org.specs2.mock.Mockito
import org.specs2.specification._

@RunWith(classOf[JUnitRunner])
abstract class BaseTest(val code: String)
    extends SpecificationWithJUnit with Mockito //with ScalaCheck
    with Target with Reflect with Push with Capture with Matchers {

    // alias type
    type FS = Fragments


    // list of spec fragments
    def specs: Fragments


    // execution steps
    override def is = {
        val heading = "### " + code + " ###"
        sequential ^ heading ^ specs
    }


    // wrap a task in its own specification
    protected def task(num: Int, descr: String)(fs: => Fragments): Fragments =
        include(new org.specs2.Specification {
            override def is = {
                val heading = "Task #" + num + " ('" + descr + "') should"
                sequential ^ stopOnSkip ^ stopOnFail ^ endbr ^ heading ^ fs
            }
        })
}