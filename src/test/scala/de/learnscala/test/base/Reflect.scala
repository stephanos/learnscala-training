package de.learnscala.test.base

import scala.reflect.runtime.universe._
import scala.reflect.runtime.{currentMirror => cm}

/**
 * http://dcsobral.blogspot.de/2012/07/json-serialization-with-reflection-in.html
 * http://stackoverflow.com/questions/12218641/scala-2-10-what-is-a-typetag-and-how-do-i-use-it
 */
trait Reflect {

    // Class

    def getInstance[T: TypeTag](args: Any*) = {
        val typ = typeOf[T]
        val constructor = typ.members.find(_.kind == "constructor").get.asMethodSymbol
        cm reflectClass typ.typeSymbol.asClassSymbol reflectConstructor constructor apply (args: _*)
    }

    /*
    def hasInterface[T, I] = {
        typeOf[T]
    }
    */


    // Objects

    def getObject(name: String): Option[Any] =
        tryopt(cm reflectModule(cm staticModule name) instance)


    // Members

    /*
    val members = typeOf[MyClass].members.filter(_.isValue).filter(_.typeSignature match {
      case tpe if tpe <:< typeOf[ThirdParty] => true
      case NullaryMethodType(tpe) if tpe <:< typeOf[ThirdParty] => true
      case MethodType(Nil, tpe) if tpe <:< typeOf[ThirdParty] => true
      case _ => false
    })
    */

    def getMembers[T: TypeTag](p: (Symbol) => Boolean): Iterable[Symbol] =
        typeOf[T].members collect {
            case m if p(m) => m
        }

    def getMember[T: TypeTag](name: String): Option[Symbol] =
        typeOf[T].member(newTermName(name)) match {
            case NoSymbol => None
            case s: Symbol => Some(s)
            case _ => None
        }

    // val

    def getVal[T: TypeTag](name: String): Option[TermSymbol] =
        getMember[T](name) flatMap (_ match {
            case term: TermSymbol if(term.isValue) => Some(term)
            case _ => None
        })

    // Term

    def getTerm[T: TypeTag](name: String): Option[TermSymbol] =
        getMember[T](name) flatMap (_ match {
            case term: TermSymbol => Some(term)
            case _ => None
        })


    // Method

    def getMethod[T: TypeTag](name: String): Option[MethodSymbol] =
        getMember[T](name) flatMap (_ match {
            case mth: MethodSymbol => Some(mth)
            case _ => None
        })


    // Invoke

    def invoke[T: TypeTag](obj: T, name: String, args: Any*): Option[Any] =
        getMethod[T](name) map (invoke(obj, _, args))

    def invoke[T: TypeTag](obj: T, mth: MethodSymbol, args: Any*): Any =
        cm reflect(obj) reflectMethod(mth) apply(args: _*)

    def read[T: TypeTag](obj: T, t: TermSymbol, args: Any*): Any =
        cm reflect(obj) reflectField (t) get


    // Signature

    def getSignature(s: Symbol): Type =
        s typeSignature

    def getParams(s: Symbol): List[Symbol] =
        s.typeSignature match {
            case MethodType(params, _) => params
            case _ => List()
        }


    // ReturnType

    def getReturnType[T: TypeTag](name: String): Option[Type] =
        getMember[T](name) map (getReturnType[T](_))

    def getReturnType[T: TypeTag](s: Symbol): Type =
        getSignature(s) match {
            case NullaryMethodType(rt) => rt
            case MethodType(_, rt) => rt
            case PolyType(_, MethodType(_, rt)) => rt
        }


    // INTERNALS ===============================================================

    private def tryopt[T](fn: => T): Option[T] = {
        try {
            Some(fn)
        } catch {
            case _: Throwable => None
        }
    }
}


/*

val members:List[Symbol] = aType.members
val justImplicits = members.filter(member => member.hasModifier(Modifier.`implicit`))


def intMethods[T: TypeTag](v: T) = {
    val IntType = typeOf[Int]
    val vType = typeOf[T]
    val methods = vType.nonPrivateMembers.collect {
        case m: MethodSymbol => m -> m.typeSignatureIn(vType)
    }
    methods collect {
        case (m, mt@NullaryMethodType(tpe)) if tpe =:= IntType => m -> mt
        case (m, mt@MethodType(_, tpe)) if tpe =:= IntType => m -> mt
        case (m, mt@PolyType(_, MethodType(_, tpe))) if tpe =:= IntType => m -> mt
    }
}
*/