package de.learnscala.base

import language.experimental.macros
import collection.mutable

trait Testable {

  type Tsk = Task
  type Qiz = Quiz

  var _quiz = mutable.Map[Int, Quiz]()
  var _tasks = mutable.Map[Int, Task]()

  protected def registerTask(num: Int, t: Task) {
    assert(!_tasks.contains(num), s"Task #$num is already registered!")
    _tasks(num) = t
  }

  protected def registerQuiz(num: Int, q: Quiz) {
    assert(!_quiz.contains(num), s"Quiz #$num is already registered!")
    _quiz(num) = q
  }

  protected def task(code: Any): Any = macro TaskMacro.singleTask

  protected def task(num: Int)(code: Any): Any = macro TaskMacro.task

  protected def quiz(body: Any) {
  }

  protected def quiz(num: Int)(text: String)(answer: Any): Any = macro QuizMacro.quiz
}