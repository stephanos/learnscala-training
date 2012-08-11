package de.learnscala.base

import scala.reflect.runtime.universe._
import scala.reflect.runtime.{currentMirror => cm}

/**
 * http://dcsobral.blogspot.ch/2012/07/json-serialization-with-reflection-in.html
 */
trait Reflect {

    def getObject(name: String) =
        tryopt(cm.reflectModule(cm.staticModule(name)))

    def getMember[T: TypeTag](name: String): Option[Symbol] =
        typeOf[T].member(newTermName(name)) match {
            case NoSymbol => None
            case s => Some(s)
        }

    def getMethod[T: TypeTag](obj: T, name: String): Option[MethodSymbol] =
        getMember[T](name) flatMap (_ match {
            case mth: MethodSymbol => Some(mth)
            case _ => None
        })

    def getMethod[T: TypeTag](name: String): Option[MethodSymbol] =
        getMember[T](name) flatMap (_ match {
            case mth: MethodSymbol => Some(mth)
            case _ => None
        })

    /*
    def invoke[T: TypeTag](obj: T, name: String, args: Any*): Option[Any] =
        getMethod[T](name) map (invoke(obj, _, args))
    */

    def invoke[T: TypeTag](obj: T, mth: MethodSymbol, args: Any*): Any =
        cm.reflect(obj).reflectMethod(mth).apply(args)

    def getMembers[T: TypeTag](p: (Symbol) => Boolean): Iterable[Symbol] =
        typeOf[T].members collect {
            case m if p(m) => m
        }

    def getSignature[T: TypeTag](s: Symbol): Type =
        s.typeSignature

    def getParents[T: TypeTag]: List[Type] =
        typeOf[T].parents

    /*
    def getReturnType[T: TypeTag](name: String): Option[Type] =
        getMember[T](name) map (getReturnType[T](_))

    def getReturnType[T: TypeTag](s: Symbol): Type =
        getSignature[T](s) match {
            case NullaryMethodType(rt) => rt
            case MethodType(_, rt) => rt
            case PolyType(_, MethodType(_, rt)) => rt
        }
    */


    private def tryopt[T](fn: => T): Option[T] = {
        try {
            Some(fn)
        } catch {
            case _ => None
        }
    }
}
