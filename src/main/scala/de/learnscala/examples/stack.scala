package de.learnscala.examples
package stack

class Stack[T] {

    var elems: List[T] = Nil

    def push(x: T) {
        elems = x :: elems
    }

    def top: T =
        elems.head

    def pop() {
        elems = elems.tail
    }
}

object Main extends App {

    val s1 = new Stack[Int]
    s1.push(1)
    s1.pop()

    val s2 = new Stack[String]
    s2.push("A")
    s2.push("B")
    s2.pop()
}