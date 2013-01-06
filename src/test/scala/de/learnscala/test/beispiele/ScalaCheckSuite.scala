package de.learnscala.test.beispiele

import org.scalatest.junit.JUnitSuite
import org.scalatest.prop.Checkers
import org.scalacheck.Arbitrary._
import org.scalacheck.Prop._

import org.junit.Test

class ScalaCheckSuite extends JUnitSuite with Checkers {

    @Test
    def testStartsWith() {
        check {
            (a: String, b: String) =>
                (a + b).startsWith(a)
        }
    }

    @Test
    def testEndsWith() {
        check {
            (a: String, b: String) =>
                (a + b).endsWith(b)
        }
    }

    @Test
    def testSubstring() {
        check {
            (a: String, b: String) =>
                (a + b).substring(a.length) == b
        }
    }
}