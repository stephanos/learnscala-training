package de.learnscala
package solutions

import de.learnscala.base._

trait SolutionTarget {

    self: Target =>

    override def fullPath =
        "de.learnscala.solutions" + self.code.replace('U', 'L')
}