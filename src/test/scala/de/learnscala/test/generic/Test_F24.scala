package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F24[T: TypeTag] extends BaseTest[T] {

    //        "titlesWithAuthorMartin must have titles of books with author 'Martin'" >> {
    //            checkType[List[String]](titlesWithAuthorMartin, "titlesWithAuthorMartin", enabled) {
    //                res =>
    //                    res must containAllOf(List("Programming In Scala", "Patterns of Enterprise Application Architecture"))
    //            }
    //        }
    //
    //        "isbnsWithAuthorS must have ISBNs of books where author's lastname starts with 'S'" >> {
    //            checkType[List[String]](isbnsWithAuthorS, "isbnsWithAuthorS", enabled) {
    //                res =>
    //                    res must containAllOf(List("3868020640", "0321127420"))
    //            }
    //        }
    //
    //        "priceAndTitleOfScalaBooks must have list of title and prices where 'Scala' is in the title" >> {
    //            checkType[List[String]](priceAndTitleOfScalaBooks, "priceAndTitleOfScalaBooks", enabled) {
    //                res =>
    //                    res must containAllOf(List(("Programming In Scala" -> 36.95f), ("Programming Scala" -> 27.95f),
    //                        ("Durchstarten mit Scala" -> 24.90f), ("Programming Scala" -> 22.95f)))
    //            }
    //        }
    //
    //        "titlesOutOfStock " >> {
    //            checkType[List[String]](titlesOutOfStock, "titlesOutOfStock", enabled) {
    //                res =>
    //                    res must containAllOf(List("Java Virtual Machine", "Patterns of Enterprise Application Architecture"))
    //            }
    //        }
    //    }
}