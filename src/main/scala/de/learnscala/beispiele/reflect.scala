package de.learnscala.beispiele
package reflect

import scala.reflect.runtime.universe._

object Main extends App {

    def paramInfo[T](x: T)(implicit tag: TypeTag[T]) {
        val targs = tag.tpe match {
            case TypeRef(_, _, args) => args
        }
        println(s"type of $x has type arguments $targs")
    }

    paramInfo(42)
    paramInfo(List(1, 2))
    paramInfo(42, 3.14159, Option("now is the time"))
}