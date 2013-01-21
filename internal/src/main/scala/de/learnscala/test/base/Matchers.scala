package de.learnscala.test.base

import org.specs2._
import matcher.MatchResult
import specification._
import execute.{Failure, Pending}

import scala.reflect._
import runtime.universe._

/**
 * http://etorreborre.github.com/specs2/guide/org.specs2.guide.Matchers.html#Custom
 */
trait Matchers {

  self: Reflect with SpecificationWithJUnit =>

  protected def mustHaveObject[T: TypeTag](name: String)(f: (Any) => Example): Example = {
    getObject[T](name) match {
      case Some(o) =>
        f apply o
      case _ =>
        ("object '" + name + "' must be defined") ! {
          Pending()
        }
    }
  }

  protected def mustHaveValue[T: TypeTag](name: String)(f: (TermSymbol) => Example): Example =
    getVal[T](name) match {
      case Some(v) =>
        f apply v
      case _ =>
        ("method '" + name + "' must be defined") ! {
          Pending()
        }
    }

  protected def mustReturnMethod(name: String, res: Any, args: Any*)(implicit ctx: TaskContext): Fragments = {
    val forInp =
      if (args.isEmpty)
        ""
      else
        "for " + inputDescr(args: _*)
    mustReturnMethodDescr(name,
      " must return '" + res + "' " +(if (forInp.length > 50) "for input" else forInp), args){
        tm =>
          val apply = tm.invoke(args: _*)
          apply === res
    }
  }

  protected def mustReturnMethodDescr(name: String, descr: String, args: Any*)(res: TaskMethod => MatchResult[Any])(implicit ctx: TaskContext): Fragments =
    s"method '$name'" + descr ! {
      ctx.getMethod(name) match {
        case Some(m) =>
          res(m)
        case _ =>
          sys.error(s"method '$name' does not exist!")
      }
    }

  protected def mustHaveMethod(name: String, longDescr: Boolean = false)(f: (TaskMethod) => Fragments)(implicit ctx: TaskContext): Fragments = {
    val method = ctx.getMethod(name)
    val descr = if (longDescr) s"method '$name' " else ""
    val check =
      (descr + "must be defined") ! {
        if (method.isDefined)
          success
        else
          Failure(s"method '$name' could not be found")
      }
    if (method.isEmpty)
      check
    else
      /*check ^*/ f(method.get)
  }

  protected def withList(v: Any)(e: Traversable[_] => MatchResult[Any]): MatchResult[Any] =
    v match {
      case l: Seq[_] =>
        e(l)
      case _ =>
        sys.error("result is not a list")
    }

  protected def mustHaveClass(f: (TaskClass) => Fragments)(implicit ctx: TaskContext): Fragments =
    mustHaveClass(ctx.name)(f)

  protected def mustHaveClass(name: String)(f: (TaskClass) => Fragments)(implicit ctx: TaskContext): Fragments = {
    val cls = ctx.getClass(name)
    val check =
      ("must be defined") ! {
        if (cls.isDefined)
          success
        else
          Failure(s"class '${ctx.name}' could not be found")
      }
    if (cls.isEmpty)
      check
    else
      check ^ f(cls.get)
  }

  protected def mustHaveMethod(f: (TaskMethod) => Fragments)(implicit ctx: TaskContext): Fragments =
    mustHaveMethod(ctx.name)(f)

  protected def mustHaveParams(count: Int)(implicit tm: TaskMethod): Example = {
    ("must have " + count + " parameter" + (if (count != 1) "s" else "")) ! {
      (tm.params.flatten.size) aka "size of parameter list" must beEqualTo(count)
    }
  }

  protected def mustHaveParams(types: Class[_]*)(implicit tm: TaskMethod): Example = {
    mustHaveParams(types.size)
    // TODO: check types
  }

  protected def mustUse(descr: String, items: (String, String)*)(implicit tm: TaskMethod): Example = {
    "must use " + descr + ": " + items.map(_._1).mkString("'", "', '", "'") ! {
      val raw = tm.ctx.getMethod("_raw").get.invoke().asInstanceOf[String]
      println(raw)
      val missing =
        items.foldLeft(List[String]()) {
          (r, m) =>
            if (raw.contains(m._2))
              r
            else
              m._1 :: r
        }
      if (missing.isEmpty)
        success
      else
        Failure("code is not using required " + descr + ": " + missing.mkString("'", "', ", "'"))
    }
  }

  protected def mustNotUseMethods(mths: String*)(implicit tm: TaskMethod): Example =
    "must not use the method" + (if (mths.length > 0) "s" else "") + ": " + mths.mkString("'", "', '", "'") ! {
      val raw = tm.ctx.getMethod("_source").get.invoke().asInstanceOf[String]
      println(raw)
      val violations =
        mths.foldLeft(List[String]()) {
          (r, m) =>
            if (raw.contains(m))
              m :: r
            else
              r
        }
      if (violations.isEmpty)
        success
      else
      if (violations.size > 0)
        Failure("code uses forbidden method: " + violations.head)
      else
        Failure("code uses forbidden methods: " + violations.mkString("'", "', ", "'"))
    }

  //    def mustHaveParams(m: MethodSymbol, types: Class[_]*)(f: (MethodSymbol) => Example): Example = {
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

  protected def mustThrow[T <: Throwable](args: Any*)(implicit tm: TaskMethod, th: ClassTag[T]): Fragment = {
    val thdescr = th.runtimeClass.getSimpleName match {
      case "Throwable" | "Exception" => "an exception"
      case name => "'" + name + "'"
    }
    "must throw " + thdescr + " for " + inputDescr(args: _*) ! {
      (tm invoke args) must throwA[T]
    }
  }

  protected def mustReturn(res: Any, args: Any*)(implicit tm: TaskMethod): Fragment = {
    val forInp =
      if (args.isEmpty)
        ""
      else
        "for " + inputDescr(args: _*)
    "must return '" + res + "' " + (if (forInp.length > 50) "for input" else forInp) ! {
      val apply = tm.invoke(args: _*)
      apply === res
    }
  }

  protected def mustNotContain(things: Any*)(implicit tm: TaskMethod): Seq[Fragment] =
    things.map {
      t => t match {
        case c: COUNT => checkLimits((c, 0))
        case (c: COUNT, i: Int) => checkLimits((c, i))
        case c => sys.error("unable to check for: " + c)
      }
    }

  protected def mustNotBeLongerThan(lines: Int)(implicit tm: TaskMethod) =
    checkLimits((LINE, lines))

  protected val VAR = COUNT("var")
  protected val LINE = COUNT("line", descr = Some("lines of code"))
  protected val WHILE = COUNT("while")

  protected case class COUNT(name: String, customCode: String = null, descr: Option[String] = None) {

    val code = Option(customCode).getOrElse(name)
    val field = "_noOf" + code.capitalize + "s"
  }

  // INTERNALS ===============================================================

  private def checkLimits(thing: (COUNT, Int))(implicit tm: TaskMethod): Fragment = {
    val (item, cnt) = thing
    val descr = item.descr.getOrElse(item.name)
    val amount = if (cnt == 0) "any" else "more than " + cnt
    "must not use " + amount + " '" + descr + "'" ! {
      val i = tm.ctx.getMethod(item.field).get.invoke().asInstanceOf[Int]
      if (i > cnt)
        Failure(amount + " '" + descr + "' " + (if (cnt > 1) "are" else "is") + " not allowed in this task")
      else
        success
    }
  }

  private def inputDescr(args: Any*) =
    (args.size match {
      case 0 | 1 => "input "
      case _ => "inputs "
    }) + (args.toList match {
      case List("") => "empty String"
      case other => "'" + other.mkString("','") + "'"
    })

  private def getList[T: ClassTag : TypeTag](obj: T, m: MethodSymbol)(f: Traversable[_] => Example): Example = {
    (invoke[T](obj, m)) match {
      case null => mustNotBeNull()
      case l: Traversable[Any] => f(l)
      case _ => mustHaveType("List")
    }
  }

  private def mustHaveType(t: String): Example = {
    ("must have type: '" + t + "'") ! {
      Pending()
    }
  }

  private def mustNotBeNull(): Example = {
    ("must not be null") ! {
      Pending()
    }
  }
}