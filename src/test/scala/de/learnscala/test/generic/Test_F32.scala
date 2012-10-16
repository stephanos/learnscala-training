package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F32[T: TypeTag] extends BaseTest[T] {

  task(1)("incr", "method") {
    (mn, target) =>

      mustHaveMethod(mn) {
        m =>
          mustHaveParams(m)

          "must return '10'" >> {
            invoke(target, m) === 10
          }
      }
  }

  task(2)("print2Digits", "method") {
    (mn, target) =>

      mustHaveMethod(mn) {
        m =>
          mustHaveParams(m, 1)

          "must print '60' for '60'" >> {
            captureOutput(invoke(target, m, 60))._2 === "60"
          }
          "must print '05' for '5'" >> {
            captureOutput(invoke(target, m, 5))._2 === "05"
          }
      }
  }
}