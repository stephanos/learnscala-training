package de.learnscala.test.base

import scala.actors.Futures._

trait Capture {

    protected def captureOutput[T](fn: => T): (Option[T], String) = {
        val baos = new java.io.ByteArrayOutputStream
        val r = awaitAll(2000, future {
            Console.withOut(baos) {
                fn
            }
        }).head.asInstanceOf[Option[T]]
        baos.flush()
        val out = new String(baos.toByteArray, "UTF-8")
        println(out)
        (r, Option(out).getOrElse(""))
    }
}
