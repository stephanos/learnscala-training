package de.learnscala.base

import collection.mutable
import language.experimental.macros

trait Testable {

    var tasks = new mutable.MutableList[Task]()

    protected def register(t: Task) {
        tasks += t
    }

    protected class Task {

        val _noOfIfs = 0
        val _noOfVars = 0
        val _noOfVals = 0
        val _noOfDefs = 0
        val _linesOfCode = 0
    }

    protected object Task {

        def apply(num: Int)(code: Any): Any = macro Macro.apply
    }

}