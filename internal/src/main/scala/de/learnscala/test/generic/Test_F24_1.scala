package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F24_1[T: TypeTag] extends BaseTest[T] {

  val forbiddenMethods = List("map", "filter", "flatMap")

  override def fs =
    task(1)("titlesWithAuthorMartin", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() ^
              shouldNotUseMethods(forbiddenMethods: _*) ^
              "must have titles of books with author 'Martin'" ! {
                val l = m.invoke()
                l match {
                  case li: List[_] =>
                    li must containAllOf(List("Programming In Scala", "Patterns of Enterprise Application Architecture"))
                  case _ =>
                    sys.error("result is not a list")
                }
              }
        }
    } ^
      task(2)("isbnsWithAuthorS", "method") {
        implicit ctx =>
          mustHaveMethod {
            implicit m =>
              mustHaveParams() ^
                shouldNotUseMethods(forbiddenMethods: _*) ^
                "must have ISBNs of books where author's lastname starts with 'S'" ! {
                  val l = m.invoke()
                  l match {
                    case li: List[_] =>
                      li must containAllOf(List("3868020640", "0321127420"))
                    case _ =>
                      sys.error("result is not a list")
                  }
                }
          }
      } ^
      task(3)("priceAndTitleOfScalaBooks", "method") {
        implicit ctx =>
          mustHaveMethod {
            implicit m =>
              mustHaveParams() ^
                shouldNotUseMethods(forbiddenMethods: _*) ^
                "must have list of title and prices where 'Scala' is in the title" ! {
                  val l = m.invoke()
                  l match {
                    case li: List[_] =>
                      li must containAllOf(List(("Programming In Scala" -> 36.95f), ("Programming Scala" -> 27.95f),
                        ("Durchstarten mit Scala" -> 24.90f), ("Programming Scala" -> 22.95f)))
                    case _ =>
                      sys.error("result is not a list")
                  }
                }
          }
      } ^
      task(4)("titlesOutOfStock", "method") {
        implicit ctx =>
          mustHaveMethod {
            implicit m =>
              mustHaveParams() ^
                shouldNotUseMethods(forbiddenMethods: _*) ^
                "must have list of title and prices where 'Scala' is in the title" ! {
                  val l = m.invoke()
                  l match {
                    case li: List[_] =>
                      li must containAllOf(List("Java Virtual Machine", "Patterns of Enterprise Application Architecture"))
                    case _ =>
                      sys.error("result is not a list")
                  }
                }
          }
      }
}