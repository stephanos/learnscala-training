package de.learnscala.base

import collection.mutable
import language.experimental.macros
import de.learnscala.base.Testable.Task

trait Testable {

    var tasks = new mutable.MutableList[Task]()

    protected def register(t: Task) {
        tasks += t
    }

    def Task(num: Int)(code: Any): Any = macro Macro.apply

}

object Testable {

    class Task {

        val _noOfIfs = 0
        val _noOfVars = 0
        val _noOfVals = 0
        val _noOfDefs = 0
        val _linesOfCode = 0
    }
}