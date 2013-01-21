package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._
import xml.XML

abstract class Test_xml[T: TypeTag] extends BaseTest[T]() {

  lazy val getXML = XML.load(this.getClass.getResourceAsStream("/movies.xml"))(0)

  override def fs =
    task(1)("movieToXml", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(3) {
              1 === 1
            }
        }
    } ^ task(2)("releaseDateOfPsycho", "method") {
      implicit ctx =>
        mustHaveMethod {
          implicit m =>
            mustHaveParams(1) {
              1 === 1
            }
          //mustReturn(1960, getXML)
        }
    }
}

