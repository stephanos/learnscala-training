package de.learnscala.test.base

import scala.reflect.runtime.universe._
import scala.reflect.runtime.{currentMirror => cm}

case class TaskClass(name: String, sym: ClassSymbol, ctx: TaskContext) {

  val mirror: ClassMirror =
    ctx.mirror.reflectClass(sym)

  def inst(args: Any*): Any =
    try {
      val m = TaskMethod("constructor", sym.typeSignature.member(nme.CONSTRUCTOR).asMethod, ctx)
      m.invoke(args: _*)
    } catch {
      case e: IllegalArgumentException =>
        if (args.size <= 1)
          throw new RuntimeException("method parameter type does NOT match input value type", e)
        else
          throw new RuntimeException("method parameter types do NOT match input value types", e)
    }

  def params =
    sym.typeParams
}