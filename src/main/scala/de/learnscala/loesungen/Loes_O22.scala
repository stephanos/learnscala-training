package de.learnscala.loesungen

import de.learnscala.base.Solution

class Loes_O22 extends Solution {

  abstract class OpTree
  case class Leaf(value: Int) extends OpTree
  case class Node(operator: Char, left: OpTree, right: OpTree) extends OpTree

  def solve(tree: OpTree): Int =
    tree match {
      case Leaf(v) => v
      case Node(op, left, right) =>
        op match {
          case '+' => solve(left) + solve(right)
          case '-' => solve(left) - solve(right)
          case '*' => solve(left) * solve(right)
          case '/' => solve(left) / solve(right)
        }
    }


  // ===============================================================
  // TESTS
  // ===============================================================

  task {
    def s1 = solve(Leaf(5))

    def s2 = solve(Node('+', Leaf(5), Leaf(5)))

    def s3 = solve(Node('*', Leaf(5), Leaf(5)))

    def s4 = solve(Node('/', Leaf(5), Leaf(5)))

    def s5 = solve(Node('-', Leaf(5), Leaf(5)))

    def s6 = solve(Node('+', Node('-', Leaf(10), Leaf(2)), Node('*', Leaf(5), Leaf(5))))
  }
}