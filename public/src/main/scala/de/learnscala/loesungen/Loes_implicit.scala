package de.learnscala.loesungen

import de.learnscala.base.Solution
import java.util.Date

class Loes_implicit extends Solution {

  class Bruch(z: Int, n: Int) {

    private def gcd(x: Int, y: Int): Int = {
      if (x == 0) y
      else if (x < 0) gcd(-x, y)
      else if (y < 0) -gcd(x, -y)
      else gcd(y % x, x)
    }

    private val g = gcd(z, n)

    val zaehler: Int = z / g
    val nenner: Int = n / g

    def *(that: Bruch) =
      new Bruch(zaehler * that.zaehler, nenner * that.nenner)

    def /(that: Bruch) =
      new Bruch(zaehler * that.nenner, nenner * that.zaehler)

    def unary_! =
      new Bruch(nenner, zaehler)

    override def toString =
      zaehler + "/" + nenner
  }

  implicit def int2Bruch(x: Int) = new Bruch(x, 1)

  task(1) {
    def r = 2 * new Bruch(1, 4)
  }

  // ===============================================================

  implicit class MyInt(i: Int) {

    def +%(p: Int): Int =
      math.floor(i + (i / 100.0 * p)).toInt
  }

  task(2) {
    def r = 150 +% 50
  }

  // ===============================================================

  implicit class StringTime(s: String) {

    def time: Date =
      s.split(" ").toList match {
        case "yesterday" :: Nil => nowMinusHours(24)
        case h :: d :: "ago" :: Nil if(d contains "hour") => nowMinusHours(h.toInt)
        case _ => nowMinusHours()
      }

    def nowMinusHours(h: Int = 0) = {
      val now = new Date
      now.setTime(now.getTime - h * 60 * 60 * 1000)
      now
    }
  }

  task(3) {
    def r(s: String) = s.time
  }
}
