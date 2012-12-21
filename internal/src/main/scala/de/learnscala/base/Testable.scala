package de.learnscala.base

import language.experimental.macros

trait Testable {

    protected class Task {

    }

    protected object Task {
        def apply(num: Int)(code: Any): Any = macro Macro.apply
    }
}