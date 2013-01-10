package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._
import xml.XML

abstract class Test_E20[T: TypeTag] extends BaseTest[T] {

    lazy val getXML = XML.load(this.getClass.getResourceAsStream("/movies.xml"))(0)

    override def fs =
        task(1)("releaseDateOfPsycho", "method") {
            implicit ctx =>
                mustHaveMethod {
                    implicit m =>
                        mustHaveParams(1) ^
                            mustReturn(1960, getXML)
                }
        }
}

