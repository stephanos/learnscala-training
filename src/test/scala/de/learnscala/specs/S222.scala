package de.learnscala.specs

import de.learnscala.uebungen.U222._
import de.learnscala.base.BaseTest

class S222 extends BaseTest {

    spec("U222", enabled) {

        "last" >> {
            "must return 'Some(1)' for List(1)" >> {
                last(List(1)) === Some(1)
            }
            "must return 'Some(3)' for List(1,2,3)" >> {
                last(List(1,2,3)) === Some(3)
            }
            "must return 'Some(5)' for List(1,2,3,4,5)" >> {
                last(List(1,2,3,4,5)) === Some(5)
            }
            "must return 'None' for List()" >> {
                last(List()) must beNone
            }
        }

        "third" >> {
            "must return 'Some(3)' for List(1,2,3)" >> {
                third(List(1,2,3)) === Some(3)
            }
            "must return 'Some(3)' for List(1,2,3,4,5)" >> {
                third(List(1,2,3,4,5)) === Some(3)
            }
            "must return 'None' for List(1,2)" >> {
                third(List(1,2)) === None
            }
            "must return 'None' for List(1)" >> {
                third(List(1)) === None
            }
            "must return 'None' for List()" >> {
                third(List()) === None
            }
        }

        "palindrome" >> {
            "must return 'false' for List(1,2,3)" >> {
                palindrome(List(1,2,3)) === false
            }
            "must return 'false' for List(1,2,1,2)" >> {
                palindrome(List(1,2,1,2)) === false
            }
            "must return 'true' for List(1,2,1)" >> {
                palindrome(List(1,2,1)) === true
            }
            "must return 'true' for List(1)" >> {
                palindrome(List(1)) === true
            }
            "must return 'true' for List(1,2,3,2,1)" >> {
                palindrome(List(1,2,3,2,1)) === true
            }
            "must return 'true' for List()" >> {
                palindrome(List()) === true
            }
        }
    }
}