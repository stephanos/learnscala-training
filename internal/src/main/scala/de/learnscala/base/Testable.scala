package de.learnscala.base

import language.experimental.macros
import collection.mutable.ListBuffer

trait Testable {

    type Tsk = Task

    var tasks = ListBuffer[Task]()

    protected def register(num: Int, t: Task) {
        tasks += t
    }

    protected def task(code: Any): Any = macro Macro.singleTask

    protected def task(num: Int)(code: Any): Any = macro Macro.task
}