package de.learnscala.test.base

import org.specs2._
import specification._
import execute.{Failure, Pending}

import scala.reflect._
import runtime.universe._

/**
 * http://etorreborre.github.com/specs2/guide/org.specs2.guide.Matchers.html#Custom
 */
trait Matchers {

    self: Reflect with SpecificationWithJUnit =>

    def mustHaveObject[T: TypeTag](name: String)(f: (Any) => Example): Example = {
        getObject[T](name) match {
            case Some(o) =>
                f apply o
            case _ =>
                ("object '" + name + "' must be defined") ! {
                    Pending()
                }
        }
    }

    def mustHaveValue[T: TypeTag](name: String)(f: (TermSymbol) => Example): Example =
        getVal[T](name) match {
            case Some(v) =>
                f apply v
            case _ =>
                ("method '" + name + "' must be defined") ! {
                    Pending()
                }
        }

    def mustHaveMethod[T: TypeTag](name: String)(f: (MethodSymbol) => Example): Example = {
        getMethod[T](name) match {
            case Some(m) =>
                f apply m
            case _ =>
                ("method '" + name + "' must be defined") ! {
                    Pending()
                }
        }
    }

    def mustHaveMethod2(f: (TaskMethod) => Fragments)(implicit ctx: TaskContext): Fragments = {
        val method = ctx.getMethod(ctx.name)
        val check =
            ("must be defined") ! {
                if (method.isDefined)
                    success
                else
                    Failure(s"method '${ctx.name}' could not be found")
            }
        if (method.isEmpty)
            check
        else
            check ^ f(method.get)
    }

    def mustHaveParams(m: MethodSymbol, count: Int): Example = {
        "must have " + count + " parameter" ! {
            getParams(m) aka "parameter list" must haveSize(count)
        }
    }

    def mustHaveParams(m: MethodSymbol, types: Class[_]*): Example = {
        mustHaveParams(m, types.size)
        // TODO: check types
    }

    def mustHaveParams2(types: Class[_]*)(implicit tm: TaskMethod): Example = {
        val count = types.size
        ("must have " + (if(count == 0) "no" else count) + " parameter" + (if (count != 1) "s" else "")) ! {
            (tm.params.flatten.size) aka "size of parameter list" must beEqualTo(count)
        }
        // TODO: check types
    }

//    def mustHaveParams2(m: MethodSymbol, types: Class[_]*)(f: (MethodSymbol) => Example): Example = {
//        val shouldHave = types.size
//        val doesHave = getParams(m)
//
//        if(shouldHave != doesHave.size) {
//            "must have " + shouldHave + " parameter" ! {
//                doesHave aka "parameter list" must haveSize(shouldHave)
//            }
//        }
//
//        // TODO: check types ?
//
//        f(m)
//    }

    /*
    def methodMustHaveType[T: TypeTag](m: MethodSymbol, typ: T)(f: (MethodSymbol) => Example): Example = {
        val shouldHave = typ
        val doesHave = getReturnType(m)

        if(shouldHave != doesHave) {
            ("must have type: '" + name + "'") >> {
                Pending()
            }
        }

        f((m, shouldHave))
    }
    */

    def mustThrow[T <: Throwable](args: Any*)(implicit tm: TaskMethod, th: ClassManifest[T]): Fragment = {
        val thdescr = th.runtimeClass.getSimpleName match {
            case "Throwable" | "Exception" => "an exception"
            case name => "'" + name + "'"
        }
        "must throw " + thdescr + " for " + inputDescr(args: _*) ! {
            (tm invoke args) must throwA[T]
        }
    }

    def mustReturn(res: Any, args: Any*)(implicit tm: TaskMethod): Fragment =
        "must return '" + res + "' for " + inputDescr(args: _*) ! {
            val apply = tm.invoke(args: _*)
            apply === res
        }

    def mustNotContain(things: Any*)(implicit tm: TaskMethod): Seq[Fragment] = {
        things.map {
            t => t match {
                case c: COUNT => checkLimits((c, 0))
                case (c: COUNT, i: Int) => checkLimits((c,i))
                case c => sys.error("unable to check for: " + c)
            }
        }
    }

    private def checkLimits(thing: (COUNT, Int))(implicit tm: TaskMethod): Fragment = {
        val (item, cnt) = thing
        val amount = if (cnt == 0) "any" else "more than " + cnt
        "must not use " + amount + " '" + item.name + "'" ! {
            val i = tm.ctx.getMethod(item.field).get.invoke().asInstanceOf[Int]
            if (i > cnt)
                Failure("'" + item.name + "' is not allowed in this task")
            else
                success
        }
    }

    case class COUNT(name: String, customCode: String = null) {
        val code = Option(customCode).getOrElse(name)
        val field = "_noOf" + code.capitalize + "s"
    }
    val VAR = COUNT("var")
    val WHILE = COUNT("while")

    def inputDescr(args: Any*) =
        (args.size match {
            case 0 | 1 => "input "
            case _ => "inputs "
        }) + (args.toList match {
            case List("") => "empty String"
            case other => "'" + other.mkString("','") + "'"
        })

    def getList[T : ClassTag : TypeTag](obj: T, m: MethodSymbol)(f: Traversable[_] => Example): Example = {
        (invoke[T](obj, m)) match {
            case null => mustNotBeNull()
            case l: Traversable[Any] => f(l)
            case _ => mustHaveType("List")
        }
    }

    def mustHaveType(t: String): Example = {
        ("must have type: '" + t + "'") ! {
            Pending()
        }
    }

    def mustNotBeNull(): Example = {
        ("must not be null") ! {
            Pending()
        }
    }
}