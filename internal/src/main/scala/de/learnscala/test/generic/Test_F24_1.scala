package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_F24_1[T: TypeTag] extends BaseTest[T]() {

  val forbiddenMethods = List("map", "filter", "flatMap")

  override def fs =
    task(1)("printAllTitles", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "must print the titles of all books" ! {
                val out = captureOutput(m.invoke())._2
                out must contain("Programming In Scala")
                out must contain("Programming Scala")
                out must contain("Durchstarten mit Scala")
                out must contain("Java Virtual Machine")
                out must contain("Functional Programming for Java Developers")
                out must contain("Patterns of Enterprise Application Architecture")
                out must contain("Programming Scala")
              }
              }
        }
    } ^ task(2)("titlesWithAuthorMartin", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "must have titles of books with author 'Martin'" ! {
                withList(m.invoke()) {
                  _.toSeq must containAllOf(List("Programming In Scala", "Patterns of Enterprise Application Architecture"))
                }
              }
            }
        }
    } ^ task(3)("isbnsWithAuthorS", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "must have ISBNs of books where author's lastname starts with 'S'" ! {
                withList(m.invoke()) {
                  _.toSeq must containAllOf(List("3868020640", "0321127420"))
                }
              }
            }
        }
    } ^ task(4)("priceAndTitleOfScalaBooks", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "must have list of title and prices where 'Scala' is in the title" ! {
                withList(m.invoke()) {
                  _.toSeq must containAllOf(List(("Programming In Scala" -> 36.95f), ("Programming Scala" -> 27.95f),
                    ("Durchstarten mit Scala" -> 24.90f), ("Programming Scala" -> 22.95f)))
                }
              }
            }
        }
    } ^ task(5)("titlesNoLongerAvailable", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "must have list of title that are no longer available" ! {
                withList(m.invoke()) {
                  _.toSeq must containAllOf(List("Java Virtual Machine", "Patterns of Enterprise Application Architecture"))
                }
              }
            }
        }
    } ^ task(6)("titlesOutOfStock", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams() {
              "must have list of title that are out of stock" ! {
                withList(m.invoke()) {
                  _.toSeq must containAllOf(List("Programming In Scala"))
                }
              }
            }
        }
    }

  /* ^ task(7)("authorsWithMultipleBooks", "method") {
       implicit ctx =>
         mustHaveMethod {
           implicit m =>
             mustHaveParams() ^
               "must have list of authors that have more than 1 book" ! {
                 val l = m.invoke()
                 l match {
                   case li: List[_] =>
                     li must containAllOf(List("Bill Venners"))
                   case _ =>
                     sys.error("result is not a list")
                 }
               }
         }
     } ^ task(8)("the3MostCommonWordsInTitles", "method") {
           implicit ctx =>
             mustHaveMethod {
               implicit m =>
                 mustHaveParams() ^
                   "must have list of the 3 most commonly used words in the book titles" ! {
                     val l = m.invoke()
                     l match {
                       case li: List[_] =>
                         li must have size(3)
                         li must containAllOf(List("Java", "Scala", "Programming"))
                       case _ =>
                         sys.error("result is not a list")
                     }
                   }
             }
         } */
}