package de.learnscala.test.base

import de.learnscala.base.Task
import scala.reflect.runtime.universe._
import scala.reflect.runtime.{currentMirror => cm}

case class TaskContext(name: String, task: Task) {

    val mirror: InstanceMirror =
        cm.reflect(task)

    val sym: ClassSymbol =
        cm.classSymbol(task.getClass)


    def getMethod(name: String): Option[TaskMethod] =
        getMember(name) flatMap {
            case mth: MethodSymbol => Some(TaskMethod(name, mth, this))
            case _ => None
        }


    // INTERNALS ==================================================================================

    private def getMember(name: String): Option[Symbol] =
        (sym.typeSignature.members collect {
            case s: Symbol if (s.name.toString == name) => s
        }).headOption
}