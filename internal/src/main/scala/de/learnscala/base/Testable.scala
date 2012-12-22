package de.learnscala.base

import collection.mutable
import language.experimental.macros

trait Testable {

    type Tsk = Task

    var tasks = Array.fill[Task](25)(null)

    protected def register(num: Int, t: Task) {
        tasks(num - 1) = t
    }

    protected def task(num: Int)(code: Any): Any = macro Macro.apply
}