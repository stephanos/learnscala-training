package de.learnscala
package solutions

import de.learnscala.base.BaseTest

trait SolutionTest {

    self: BaseTest =>

    override def getFullPath =
        "de.learnscala.solutions." + code.replaceFirst("U", "L")
}