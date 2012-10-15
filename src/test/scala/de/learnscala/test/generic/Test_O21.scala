package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O21[T: TypeTag] extends BaseTest[T] {

    task(1)("salaryForClerk", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "Salary of clerk must be 50.000" >> {
                        invoke(target, m) === 50000
                    }
            }
    }

    task(2)("salaryForManager", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "Salary of manager must be 250.000" >> {
                        invoke(target, m) === 250000
                    }
            }
    }

    task(3)("salaryForBoardMember", "method") {
        (mn, target) =>
            mustHaveMethod(mn) {
                m =>
                    mustHaveParams(m)

                    "Salary of board member must be 100.000" >> {
                        invoke(target, m) === 100000
                    }
            }
    }

    task(4)("salaryForfriendOfManagerClerk", "method") {
           (mn, target) =>
               mustHaveMethod(mn) {
                   m =>
                       mustHaveParams(m)

                       "Salary of friend-of-managers clerk must be 100.000" >> {
                           invoke(target, m) === 100000
                       }
               }
       }

    task(5)("salaryForIllegalImmigrantClerk", "method") {
           (mn, target) =>
               mustHaveMethod(mn) {
                   m =>
                       mustHaveParams(m)

                       "Salary of illegal-immigrant clerk must be 25.000" >> {
                           invoke(target, m) === 25000
                       }
               }
       }

    task(6)("salaryForIllegalImmigrantManager", "method") {
           (mn, target) =>
               mustHaveMethod(mn) {
                   m =>
                       mustHaveParams(m)

                       "Salary of illegal-immigrant manager must be 125.000" >> {
                           invoke(target, m) === 125000
                       }
               }
       }

    task(7)("salaryForIllegalImmigrantBoardMember", "method") {
           (mn, target) =>
               mustHaveMethod(mn) {
                   m =>
                       mustHaveParams(m)

                       "Salary of illegal-immigrant board member must be 50.000" >> {
                           invoke(target, m) === 50000
                       }
               }
       }
}

