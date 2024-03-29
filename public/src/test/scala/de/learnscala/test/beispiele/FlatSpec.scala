package de.learnscala.test.beispiele

import org.scalatest
import org.scalatest.BeforeAndAfter

class FlatSpec extends scalatest.FlatSpec with BeforeAndAfter {

  val builder = new StringBuilder

  before {
    builder.append("Hello ")
  }

  after {
    builder.clear()
  }

  "Builder" should "greet Scala" in {
    builder.append("Scala!")
    assert(builder.toString === "Hello Scala!")
  }

  it should "greet the World" in {
    builder.append("World!")
    assert(builder.toString === "Hello World!")
  }
}