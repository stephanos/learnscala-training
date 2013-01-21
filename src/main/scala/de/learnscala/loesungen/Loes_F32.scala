package de.learnscala.loesungen

import java.io._
import de.learnscala.base.Solution

class Loes_F32 extends Solution {

  def until(condition: => Boolean)(block: => Unit) {
    if (!condition) {
      block
      until(condition)(block)
    }
  }

  task(1) {
    def count(till: Int) {
      var i = 1
      until(i == till) {
        print(i + " ")
        i += 1
      }
    }
  }


  <!-- ################################################################################## -->


  def catching[A](body: => A): Option[A] =
    try {
      Some(body)
    } catch {
      case _: Throwable => None
    }

  task(2) {
    def convertToInt(s: String): Option[Int] =
      catching { s.toInt }
  }


  <!-- ################################################################################## -->


  def withResource[A, R <: Closeable](res: => R)(f: R => A): Option[A] = {
    try {
      val r = res
      try {
        Some(f(r))
      } catch {
        case _: Throwable => None
      } finally {
        r.close()
      }
    } catch {
      case _: Throwable => None
    }
  }

  task(3) {
    def readFile(f: File): Option[String] = {
      withResource(new FileInputStream(f)) { stream =>
        val bytes = new Array[Byte](f.length.toInt)
        stream.read(bytes)
        new String(bytes, "UTF-8")
      }
    }
  }


  <!-- ################################################################################## -->

  implicit class Ternary(condition: Boolean) {

    class ResultHandler[A](condition: Boolean, trueBody: => A) {
      def |(falseBody: => A) = if (condition) trueBody else falseBody
    }

    def ?[A](trueBody: => A) =
      new ResultHandler(condition, trueBody)
  }

  task(4) {
    def printTime(hour: Int, min: Int) {
      (hour < 10) ? print("0" + hour) | print(hour)
      print(":")
      (min < 10) ? print("0" + min) | print(min)
    }
  }
}