package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O21[T: TypeTag] extends BaseTest[T](continuous = true) {

  task(1)("salaryForClerk", "method") {
    implicit ctx =>
      mustHaveMethod {
        implicit m =>
          mustHaveParams() ^
            "Salary of clerk must be 50.000" ! {
              m.invoke() === 50000
            }
      }
  }

  task(2)("salaryForManager", "method") {
    implicit ctx =>
      mustHaveMethod {
        implicit m =>
          mustHaveParams() ^
            "Salary of manager must be 250.000" ! {
              m.invoke() === 250000
            }
      }
  }

  task(3)("salaryForBoardMember", "method") {
    implicit ctx =>
      mustHaveMethod {
        implicit m =>
          mustHaveParams() ^
            "Salary of board member must be 100.000" ! {
              m.invoke() === 100000
            }
      }
  }

  task(4)("salaryForFriendOfManagerClerk", "method") {
    implicit ctx =>
      mustHaveMethod {
        implicit m =>
          mustHaveParams() ^
            "Salary of friend-of-managers clerk must be 100.000" ! {
              m.invoke() === 100000
            }
      }
  }

  task(5)("salaryForIllegalImmigrantClerk", "method") {
    implicit ctx =>
      mustHaveMethod {
        implicit m =>
          mustHaveParams() ^
            "Salary of illegal-immigrant clerk must be 25.000" ! {
              m.invoke() === 25000
            }
      }
  }

  task(6)("salaryForIllegalImmigrantManager", "method") {
    implicit ctx =>
      mustHaveMethod {
        implicit m =>
          mustHaveParams() ^
            "Salary of illegal-immigrant manager must be 125.000" ! {
              m.invoke() === 125000
            }
      }
  }

  task(7)("salaryForIllegalImmigrantBoardMember", "method") {
    implicit ctx =>
      mustHaveMethod {
        implicit m =>
          mustHaveParams() ^
            "Salary of illegal-immigrant board member must be 50.000" ! {
              m.invoke() === 50000
            }
      }
  }
}

