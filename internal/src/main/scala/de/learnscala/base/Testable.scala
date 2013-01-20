package de.learnscala.base

import language.experimental.macros
import collection.mutable.ListBuffer

trait Testable {

  type Tsk = Task
  type Qiz = Quiz

  var _quiz = ListBuffer[Quiz]()
  var _tasks = ListBuffer[Task]()

  protected def registerTask(num: Int, t: Task) {
    _tasks += t
  }

  protected def registerQuiz(num: Int, q: Quiz) {
    println(q)
    _quiz += q
  }

  protected def task(code: Any): Any = macro TaskMacro.singleTask

  protected def task(num: Int)(code: Any): Any = macro TaskMacro.task

  protected def quiz(body: Any) {
  }

  protected def quiz(num: Int)(text: String)(answer: Any): Any = macro QuizMacro.quiz
}