package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O22[T: TypeTag] extends BaseTest[T] {

    //        "sum" >> {
    //            "must return '5' for Leaf(5)" >> {
    //                s1 === 5
    //            }
    //            "must return '5' for Node('+', Leaf(5), Leaf(5))" >> {
    //                s2 === 10
    //            }
    //            "must return '5' for Node('*', Leaf(5), Leaf(5))" >> {
    //                s3 === 25
    //            }
    //            "must return '5' for Node('/', Leaf(5), Leaf(5))" >> {
    //                s4 === 1
    //            }
    //            "must return '5' for Node('-', Leaf(5), Leaf(5))" >> {
    //                s5 === 0
    //            }
    //            "must return '5' for Node('+', Node('-', Leaf(10), Leaf(2)), Node('*', Leaf(5), Leaf(5))" >> {
    //                s6 === 33
    //            }
    //        }
    //    }
}

