package de.learnscala.test.beispiele

import org.scalatest
import org.scalatest.BeforeAndAfter

import collection.mutable

class FunSuite extends scalatest.FunSuite with BeforeAndAfter {

  var stack: mutable.Stack[Int] = _

  before {
    stack = new mutable.Stack[Int]
  }

  test("pop is invoked on a non-empty stack") {

    stack.push(1)
    stack.push(2)
    val oldSize = stack.size
    val result = stack.pop()
    assert(result === 2)
    assert(stack.size === oldSize - 1)
  }

  test("pop is invoked on an empty stack") {

    intercept[NoSuchElementException] {
      stack.pop()
    }
    assert(stack.isEmpty)
  }
}