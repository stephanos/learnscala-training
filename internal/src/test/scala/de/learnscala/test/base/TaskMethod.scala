package de.learnscala.test.base

import scala.reflect.runtime.universe._
import scala.reflect.runtime.{currentMirror => cm}

case class TaskMethod(sym: MethodSymbol, ctx: TaskContext) {

    val mirror: MethodMirror =
        ctx.mirror.reflectMethod(sym)

    def invoke(args: Any*): Any =
        try {
            mirror.apply(args: _*)
        } catch {
            case e: IllegalArgumentException =>
                if (args.size <= 1)
                    throw new RuntimeException("method parameter type does NOT match input value type", e)
                else
                    throw new RuntimeException("method parameter types do NOT match input value types", e)
        }

    def params =
        sym.paramss
}