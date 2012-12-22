package de.learnscala.test.base

import scala.reflect.runtime.universe._
import scala.reflect.runtime.{currentMirror => cm}

case class TaskMethod(sym: MethodSymbol, ctx: TaskContext) {

    val mirror: MethodMirror =
        ctx.mirror.reflectMethod(sym)

    def invoke(args: Any*): Any =
        mirror.apply(args: _*)
}