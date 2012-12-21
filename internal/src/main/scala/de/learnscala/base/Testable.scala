package de.learnscala.base

import language.experimental.macros

trait Testable {

    def printf(format: String, params: Any*): Unit = macro Macro.printf_impl

    protected object Task {
        def apply(num: Int)(code: Any): Any = macro Macro.analyze_impl
    }

    protected def task(num: Int)(code: Any): Any = macro Macro.analyze_impl
}