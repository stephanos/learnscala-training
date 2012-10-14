package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F23_2[T: TypeTag] extends BaseTest[T] {

    //    implicit def toMyList[A](x: List[A]) = MyList(x)
    //
    //    spec("U311", enabled) {
    //
    //        "sum" >> {
    //            "must return '6' for (1,2,3)" >> {
    //                sum(List(1, 2, 3)) === 6
    //            }
    //            "must return '0' for ()" >> {
    //                sum(List()) === 0
    //            }
    //        }
    //
    //        "product" >> {
    //            "must return '6' for (1,2,3)" >> {
    //                product(List(1, 2, 3)) === 6
    //            }
    //            "must return '27' for (3,3,3)" >> {
    //                product(List(3, 3, 3)) === 27
    //            }
    //            "must return '1' for ()" >> {
    //                product(List()) === 1
    //            }
    //        }
    //
    //        "count" >> {
    //            "must return '3' for (1,2,3)" >> {
    //                count(List(1, 2, 3)) === 3
    //            }
    //            "must return '0' for ()" >> {
    //                count(List()) === 0
    //            }
    //        }
    //
    //        "contains" >> {
    //            "must return 'true' for (1,2,3) and 3" >> {
    //                contains(List(1, 2, 3), 3) === true
    //            }
    //            "must return 'true' for (1,2,3) and 9" >> {
    //                contains(List(1, 2, 3), 9) === false
    //            }
    //            "must return 'false' for () and 3" >> {
    //                contains(List[Int](), 3) === false
    //            }
    //        }
    //
    //        "last" >> {
    //            "must return 'Some(3)' for (1,2,3)" >> {
    //                last(List(1, 2, 3)) === Some(3)
    //            }
    //            "must return 'Nil' for ()" >> {
    //                last(List()) === None
    //            }
    //        }
    //
    //        "reverse" >> {
    //            "must return '(3,2,1)' for (1,2,3)" >> {
    //                reverse(List(1, 2, 3)) === toMyList(List(3, 2, 1))
    //            }
    //            "must return '()' for ()" >> {
    //                reverse(List()) === toMyList(List())
    //            }
    //        }
    //
    //        "map" >> {
    //            "must return '(2,4,6)' for (1,2,3)" >> {
    //                U311.map(List(1, 2, 3), (i: Int) => i * 2) === toMyList(List(2, 4, 6))
    //            }
    //            "must return '()' for ()" >> {
    //                U311.map(List[Int](), (i: Int) => i * 2) === toMyList(List())
    //            }
    //        }
    //
    //        "filter" >> {
    //            "must return even numbers from (1,2,3,4)" >> {
    //                filter(List(1, 2, 3, 4), (i: Int) => i % 2 == 0) === toMyList(List(2, 4))
    //            }
    //            "must return even numbers from (1,3,5)" >> {
    //                filter(List(1, 3, 5), (i: Int) => i % 2 == 0) === toMyList(List())
    //            }
    //            "must return '()' for ()" >> {
    //                filter(List[Int](), (i: Int) => i % 2 == 0) === toMyList(List())
    //            }
    //        }
    //
    //        "unique" >> {
    //            "must return '(1,2,3)' for (1,2,3)" >> {
    //                unique(List(1, 2, 3)) === toMyList(List(1, 2, 3))
    //            }
    //            "must return '(1,2)' for (1,2,2)" >> {
    //                unique(List(1, 2, 2)) === toMyList(List(1, 2))
    //            }
    //            "must return '()' for ()" >> {
    //                unique(List())=== toMyList(List())
    //            }
    //        }
    //    }

//    def rewriteImperativeToFunctional() {
//         //This unit test succeeds! But, the code that is called is written 'Java style',
//        //it contains a lot of boilerplate code. Your job is to rewrite the code, get rid of the
//        //loops and variabels, and use only functions.
//        val anton1 = Person(15, "Anton1", "Jansen")
//        val anton2 = Person(17, "Anton2", "Janssen")
//        val anton3 = Person(18, "Anton3", "Jansssen")
//        val peter1 = Person(17, "Peter1", "Peterson")
//        val peter2 = Person(19, "Peter2", "Petersson")
//        val jason = Person(21, "Jason", "Jasonsson")
//
//        val result = BasicListManipulationExercise02.separateTheMenFromTheBoys(List(jason, anton1, anton2, anton3, peter1, peter2))
//        assert(List(List("Anton1", "Anton2", "Peter1"), List("Anton3", "Peter2", "Jason")) === result)
//
//      }

}