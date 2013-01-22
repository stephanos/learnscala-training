package de.learnscala.test.beispiele

import org.scalatest
import org.scalatest.BeforeAndAfter

import collection.mutable

class FunSpec extends scalatest.FunSpec with BeforeAndAfter {

  var stack: mutable.Stack[Int] = _

  before {
    stack = new mutable.Stack[Int]
  }

  describe("A Stack") {

    it("should pop values in last-in-first-out order") {
      stack.push(1)
      stack.push(2)
      assert(stack.pop() === 2)
      assert(stack.pop() === 1)
    }

    it("should throw NoSuchElementException if an empty stack is popped") {
      intercept[NoSuchElementException] {
        stack.pop()
      }
    }
  }
}