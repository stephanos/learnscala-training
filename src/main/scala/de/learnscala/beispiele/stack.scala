package de.learnscala.beispiele
package stack

/**
 * Typ-Parameter, List
 */
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
  s1.push('a')
  println(s1.top)
  s1.pop()
  println(s1.top)

  val s2 = new Stack[String]
  s2.push("A")
  s2.push("B")
  println(s2.top)
  s2.pop()
  println(s2.top)
}