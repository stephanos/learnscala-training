package de.learnscala.base

import org.junit.runner._
import org.specs2.mutable._
import org.specs2.runner._
import scala.actors.Futures._
import org.specs2.specification.Fragment
import org.specs2.mock.Mockito

@RunWith(classOf[JUnitRunner])
abstract class BaseTest
    extends SpecificationWithJUnit with Mockito {
    // with ScalaCheck {

    // execute sequentially
    sequential

    // stop execution on first fail / skip
    stopOnFail
    stopOnSkip


    protected def spec(name: String, enabled: Boolean)(fn: => Fragment) = {
        name should {
            if (enabled)
                fn
            else
                skipped
        }
    }

    protected def captureOutput[T](fn: => T): (Option[T], String) = {
        val baos = new java.io.ByteArrayOutputStream
        val r = awaitAll(2000, future {
            Console.withOut(baos) {
                fn
            }
        }).head.asInstanceOf[Option[T]]
        baos.flush()
        (r, new String(baos.toByteArray, "UTF-8"))
    }

    protected def checkType[T: Manifest](v: Any, n: String)(fn1: (T) => Fragment) = {
        add(v aka n must not beNull)
        add(v aka n must beAnInstanceOf[T])
        //if(v.isInstanceOf[T])
        add(fn1(v.asInstanceOf[T]))
        /*else
        fn2(v)*/

    }

    protected def add(f: => Fragment) =
        addFragments(f)
}