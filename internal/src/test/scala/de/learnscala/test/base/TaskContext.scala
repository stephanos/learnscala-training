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
        getMember(name) flatMap (_ match {
            case mth: MethodSymbol => Some(TaskMethod(mth, this))
            case _ => None
        })


    // INTERNALS ==================================================================================

    private def getMembers(p: (Symbol) => Boolean): Iterable[Symbol] =
        sym.typeSignature.members collect {
            case m if p(m) => m
        }

    private def getMember(name: String): Option[Symbol] =
        sym.typeSignature.member(newTermName(name)) match {
            case NoSymbol => None
            case s: Symbol => Some(s)
            case _ => None
        }
}