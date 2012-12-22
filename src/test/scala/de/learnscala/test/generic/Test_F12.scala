package de.learnscala.test.generic

import de.learnscala.test.base.BaseTest
import scala.reflect.runtime.universe._
import org.specs2.specification._
import org.specs2.execute.{Pending, Result}

abstract class Test_F12[T: TypeTag] extends BaseTest[T] {

    task(1)("union", "method") {
        (mn, target) =>
            mustHaveMethod("u1") {
                m =>
                    mustHaveParams(m)

                    "u1 must contain '1'" ! {
                        tryOrPending {
                            invoke(target, m) === true
                        }
                    }
            }

            mustHaveMethod("u2") {
                m =>
                    mustHaveParams(m)

                    "u2 must contain '2'" ! {
                        tryOrPending {
                            invoke(target, m) === true
                        }
                    }
            }
            mustHaveMethod("u3") {
                m =>
                    mustHaveParams(m)

                    "u3 must NOT contain '3'" ! {
                        tryOrPending {
                            invoke(target, m) === false
                        }
                    }
            }
    }

    task(2)("intersect", "method") {
        (mn, target) =>
            mustHaveMethod("i1") {
                m =>
                    mustHaveParams(m)

                    "i1 must contain '1'" ! {
                        tryOrPending {
                            invoke(target, m) === true
                        }
                    }
            }

            mustHaveMethod("i2") {
                m =>
                    mustHaveParams(m)

                    "i2 must NOT contain '2'" ! {
                        tryOrPending {
                            invoke(target, m) === false
                        }
                    }
            }
            mustHaveMethod("i3") {
                m =>
                    mustHaveParams(m)

                    "i3 must NOT contain '3'" ! {
                        tryOrPending {
                            invoke(target, m) === false
                        }
                    }
            }
    }

    task(3)("intersect", "method") {
        (mn, target) =>
            mustHaveMethod("d1") {
                m =>
                    mustHaveParams(m)

                    "d1 must NOT contain '1'" ! {
                        tryOrPending {
                            invoke(target, m) === false
                        }
                    }
            }

            mustHaveMethod("d2") {
                m =>
                    mustHaveParams(m)

                    "d2 must contain '2'" ! {
                        tryOrPending {
                            invoke(target, m) === true
                        }
                    }
            }
            mustHaveMethod("d3") {
                m =>
                    mustHaveParams(m)

                    "d3 must NOT contain '3'" ! {
                        tryOrPending {
                            invoke(target, m) === false
                        }
                    }
            }
    }

    private def tryOrPending(fn: => Result) = {
        try {
            fn
        } catch {
            case th: Throwable =>
                println(th.getCause)
                th.getCause match {
                    case e: NotImplementedError =>
                        Pending()
                    case _ =>
                        throw th
                }
        }
    }
}