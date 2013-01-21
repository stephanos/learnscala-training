package de.learnscala.test.base

import org.specs2._
import matcher.MatchResult
import specification._
import execute.{Error, Failure, Pending}

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
    mustReturnMethodDescr(name,
      " must return '" + res + "' " + inputDescr(args: _*), args) {
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
    if (method.isEmpty)
      (if (longDescr) s"method '$name' " else "") + "must be defined" ! {
        if (method.isDefined)
          success
        else
          Failure(s"method '$name' could not be found")
      }
    else
      f(method.get)
  }

  /*
  protected def mustReturnList(args: Any*)(name: String, descr: String)(m: Traversable[_] => MatchResult[Any])(implicit tm: TaskMethod): MatchResult[Any] =
    mustReturnList(args) {
      l =>
        s"method '$name'" + descr ! {
          m(l)
        }
    }
    */

  protected def mustReturnList(args: Any*)(f: (Seq[Any]) => Fragment)(implicit tm: TaskMethod): Fragment =
    mustHaveResult(args: _*) {
      v => v match {
        case null =>
          ("must not be null") ! {
            v must not beNull
          }
        case l: Seq[Any] =>
          f(l)
        case _ =>
          ("must have type 'Seq'") ! {
            v must beAnInstanceOf[Seq[_]]
          }
      }
    }

  protected def withList(v: Any)(f: (Seq[Any]) => MatchResult[Any]): MatchResult[Any] =
    v match {
      case null => v must not beNull
      case l: Seq[Any] => f(l)
      case _ => v must beAnInstanceOf[Seq[_]]
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
    /*check ^*/ f(cls.get)
  }

  protected def mustHaveMethod(f: (TaskMethod) => Fragments)(implicit ctx: TaskContext): Fragments =
    mustHaveMethod(ctx.name)(f)

  protected def mustHaveParams(count: Int)(f: => Fragments)(implicit tm: TaskMethod): Fragments = {
    val t = tm.params.flatten.size == count
    val check =
      ("must have " + count + " parameter" + (if (count != 1) "s" else "")) ! {
        if (t)
          success
        else
          Failure(s"method '${tm.name}' must have a parameter list of size '$count'")
      }
    if (!t)
      check
    else
      f
  }

  protected def mustHaveParams(types: Class[_]*)(f: => Fragments)(implicit tm: TaskMethod): Fragments = {
    mustHaveParams(types.size)(f)
    // TODO: check types
  }

  protected def mustHaveResult(args: Any*)(f: (Any) => Fragment)(implicit tm: TaskMethod): Fragment = {
    val res =
      try {
        Left(tm.invokeWithExcp(args: _*))
      } catch {
        case e: IllegalArgumentException =>
          Right(("must have correct parameter list" + inputDescr(args: _*)) ! {
            Error(e)
          })
        case e: Throwable =>
          Right(("must not throw an exception" + inputDescr(args: _*)) ! {
            Error(e)
          })
      }
    res.fold(l => f(l), r => r)
  }

  protected def mustUse(descr: String, items: (String, String)*)(implicit tm: TaskMethod): Example = {
    "must use " + descr + ": " + items.map(_._1).mkString("'", "', '", "'") ! {
      val raw = tm.ctx.getMethod("_raw").get.invoke().asInstanceOf[String]
      //println(raw)
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
      //println(raw)
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

  private def mustThrow[T <: Throwable](longDescr: Boolean)(args: Any*)(implicit tm: TaskMethod, th: ClassTag[T]): Fragment = {
    val thdescr = th.runtimeClass.getSimpleName match {
      case "Throwable" | "Exception" => "an exception"
      case name => "'" + name + "'"
    }
    val descr = if (longDescr) s"method '${tm.name}' " else ""
    (descr + "must throw " + thdescr + inputDescr(args: _*)) ! {
      (tm.invokeWithExcp(args: _*)) must throwA[T]
    }
  }

  protected def mustThrowMethod[T <: Throwable](name: String, args: Any*)(implicit ctx: TaskContext, th: ClassTag[T]): Fragments =
    mustHaveMethod(name, true) {
      implicit m =>
        Fragments.create(mustThrow(true)(args: _*))
    }

  protected def mustThrow[T <: Throwable](args: Any*)(implicit tm: TaskMethod, th: ClassTag[T]): Fragment =
    mustThrow(false)(args: _*)

  protected def mustReturnAsString(res: Any, args: Any*)(implicit tm: TaskMethod): Fragment =
    mustHaveResult(args: _*) {
      r =>
        if (r == null)
          "must not be 'null' " + inputDescr(args: _*) ! {
            r must not beNull
          }
        else
          compareReturn(res, args: _*)(r.toString)
    }

  protected def mustReturn(res: Any, args: Any*)(implicit tm: TaskMethod): Fragments =
    mustHaveParams(args.length) {
      mustHaveResult(args: _*) {
        r =>
          compareReturn(res, args: _*)(r)
      }
    }

  protected def compareReturn(excp: Any, args: Any*)(act: Any)(implicit tm: TaskMethod): Fragment = {
    "must return '" + excp + "' " + inputDescr(args: _*) ! {
      act === excp
    }
  }

  protected def mustNotContain(thing: Any)(implicit ctx: TaskContext): Fragment =
    mustNotContains(thing).head

  protected def mustNotContains(things: Any*)(implicit ctx: TaskContext): Seq[Fragment] =
    things.map {
      t => t match {
        case c: COUNT => checkLimits((c, 0))
        case (c: COUNT, i: Int) => checkLimits((c, i))
        case c => sys.error("unable to check for: " + c)
      }
    }

  protected def mustNotBeLongerThan(lines: Int)(implicit ctx: TaskContext) =
    checkLimits((LINE, lines))

  protected val VAR = COUNT("var")
  protected val LINE = COUNT("line", descr = Some("lines of code"))
  protected val WHILE = COUNT("while")

  protected case class COUNT(name: String, customCode: String = null, descr: Option[String] = None) {

    val code = Option(customCode).getOrElse(name)
    val field = "_noOf" + code.capitalize + "s"
  }

  // INTERNALS ===============================================================

  private def checkLimits(thing: (COUNT, Int))(implicit ctx: TaskContext): Fragment = {
    val (item, cnt) = thing
    val descr = item.descr.getOrElse(item.name)
    val amount = if (cnt == 0) "any" else "more than " + cnt
    "must not use " + amount + " '" + descr + "'" ! {
      val i = ctx.getMethod(item.field).get.invoke().asInstanceOf[Int]
      if (i > cnt)
        Failure(amount + " '" + descr + "' " + (if (cnt > 1) "are" else "is") + " not allowed in this task")
      else
        success
    }
  }

  private def inputDescr(args: Any*): String = {
    val tmp =
      if (args.isEmpty)
        ""
      else
        " for " + (args.size match {
          case 0 | 1 => "input "
          case _ => "inputs "
        }) + (args.toList match {
          case List("") => "empty String"
          case other => "'" + other.mkString("','") + "'"
        })
    if (tmp.length > 50) "for input" else tmp // shorten ??
  }
}