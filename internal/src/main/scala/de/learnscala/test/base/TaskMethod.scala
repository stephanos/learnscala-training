package de.learnscala.test.base

import scala.reflect.runtime.universe._
import scala.reflect.runtime.{currentMirror => cm}

case class TaskMethod(name: String, sym: MethodSymbol, ctx: TaskContext) {

  val mirror: MethodMirror =
    ctx.mirror.reflectMethod(sym)

  private def _invoke(bubbleUp: Boolean, args: Any*): Any =
    try {
      mirror.apply(args: _*)
    } catch {
      case e: IllegalArgumentException =>
        val actTypes = params.flatMap(_.map(_.typeSignature)).mkString("'", "', '", "'")
        val expTypes = args.map(_.getClass.getSimpleName).mkString("'", "', '", "'")

        if (args.size <= 1)
          throw new IllegalArgumentException(s"method parameter type ($actTypes) does NOT match expected type ($expTypes)", e)
        else
          throw new IllegalArgumentException(s"method parameter types ($actTypes) do NOT match expected types ($expTypes)", e)

      case e: Throwable if(!bubbleUp) =>
        e
    }

  def invoke(args: Any*): Any =
    _invoke(false, args: _*)

  def invokeWithExcp(args: Any*): Any =
    _invoke(true, args: _*)

  def params =
    sym.paramss
}