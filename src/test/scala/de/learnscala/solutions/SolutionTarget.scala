package de.learnscala
package solutions

import de.learnscala.base._

trait SolutionTarget {

    self: Target =>

    override def path =
        "de.learnscala.solutions"

    override def name =
        self.code.replace('U', 'L')
}