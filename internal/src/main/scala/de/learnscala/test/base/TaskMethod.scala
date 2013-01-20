package de.learnscala.test.base

import scala.reflect.runtime.universe._
import scala.reflect.runtime.{currentMirror => cm}

case class TaskMethod(name: String, sym: MethodSymbol, ctx: TaskContext) {

  val mirror: MethodMirror =
    ctx.mirror.reflectMethod(sym)

  def invoke(args: Any*): Any =
    try {
      mirror.apply(args: _*)
    } catch {
      case e: IllegalArgumentException =>
        val actTypes = params.flatMap(_.map(_.typeSignature)).mkString("'", "', '", "'")
        val expTypes = args.map(_.getClass.getSimpleName).mkString("'", "', '", "'")

        if (args.size <= 1)
          throw new RuntimeException(s"method parameter type ($actTypes) does NOT expected type ($expTypes)", e)
        else
          throw new RuntimeException(s"method parameter types ($actTypes) do NOT match expected types ($expTypes)", e)
    }

  def params =
    sym.paramss
}