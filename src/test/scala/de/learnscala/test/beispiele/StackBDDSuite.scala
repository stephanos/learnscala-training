package de.learnscala.test.beispiele

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter

import scala.collection.mutable.Stack

class StackBDDSuite extends FunSpec with BeforeAndAfter {

    var stack: Stack[Int] = _

    before {
        stack = new Stack[Int]
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