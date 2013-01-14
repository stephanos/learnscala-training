package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._

abstract class Test_O12[T: TypeTag] extends BaseTest[T](continuous = true) {

  val objn = "Point"

  /*
    test("p1") {
        implicit ctx =>
            mustHaveMethod {
              implicit m =>
                    mustHaveParams() ^
                    "must create instance for coordinates (5,5)" ! {
                        m.invoke().toString === "[5,5]"
                    }
            }
    }

    test("p2") {
        implicit ctx =>
            mustHaveMethod {
              implicit m =>
                    mustHaveParams() ^
                    "must create instance for coordinates (5,5) for parameter '5'" ! {
                        m.invoke().toString === "[5,5]"
                    }
            }
    }

    test("p3") {
        implicit ctx =>
            mustHaveMethod {
              implicit m =>
                    mustHaveParams() ^
                    "must throw exception for 2 negative coordinates" ! {
                        m.invoke() must throwA[Throwable]
                    }
            }
    }

    test("p4") {
        implicit ctx =>
            mustHaveMethod {
              implicit m =>
                    mustHaveParams() ^
                    "must throw exception for 1 negative coordinate" ! {
                        m.invoke() must throwA[Throwable]
                    }
            }
    }
    */
}