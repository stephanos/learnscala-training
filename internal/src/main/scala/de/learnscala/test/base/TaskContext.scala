package de.learnscala.test.base

import de.learnscala.base.Task
import scala.reflect.runtime.universe._
import scala.reflect.runtime.{currentMirror => cm}
import reflect.ClassTag

case class TaskContext(name: String, task: Task) {

  val mirror: InstanceMirror =
    cm.reflect(task)

  val sym: ClassSymbol =
    cm.classSymbol(task.getClass)

  def getClass(name: String): Option[TaskClass] =
    getMember[ClassSymbol](name) map { s => TaskClass(name, s, this) }

  def readField[A](name: String): A = {
    val sym = getMember[TermSymbol](name).get
    mirror.reflectField(sym).get.asInstanceOf[A]
  }

  def getMethod(name: String): Option[TaskMethod] =
    getMember[MethodSymbol](name) map { s => TaskMethod(name, s, this) }


  // INTERNALS ==================================================================================

  private def getMember[T <: Symbol : ClassTag](name: String): Option[T] =
    (sym.typeSignature.members collect {
      case s: T if (s.name.toString == name) => s
    }).headOption
}