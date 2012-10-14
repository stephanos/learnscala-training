package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O21[T: TypeTag] extends BaseTest[T] {

    //        "Salary of clerk must be 50.000" >> {
    //            salaryForClerk === 50000
    //        }
    //
    //        "Salary of manager must be 250.000" >> {
    //            salaryForManager === 250000
    //        }
    //
    //        "Salary of board member must be 100.000" >> {
    //            salaryForBoardMember === 100000
    //        }
    //
    //        "Salary of friend-of-managers clerk must be 100.000" >> {
    //            salaryForfriendOfManagerClerk === 100000
    //        }
    //
    //        "Salary of illegal-immigrant clerk must be 25.000" >> {
    //            salaryForIllegalImmigrantClerk === 25000
    //        }
    //
    //        "Salary of illegal-immigrant manager must be 125.000" >> {
    //            salaryForIllegalImmigrantManager === 125000
    //        }
    //
    //        "Salary of illegal-immigrant board member must be 50.000" >> {
    //            salaryForIllegalImmigrantBoardMember === 50000
    //        }
    //    }
}

