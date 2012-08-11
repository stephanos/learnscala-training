package de.learnscala.exercises

import de.learnscala.base.BaseTest
import org.specs2.execute.Pending

class S030 extends BaseTest("U030") {

    def specs =
        task(1, "answer to life")(spec1) ^
            task(2, "signum")(spec2) ^
            task(3, "absMax")(spec3)

    
    def spec1: FS = {
        val name = "isTheAnswerToLifeTheUniverseAndEverything"
        println(target)
        println(target.getClass())
        println(getMembers(target, _ => true))
        getMethod(target, name) match {
            case Some(m) =>
                "which returns 'true' for value '42'" ! {
                    invoke(target, m, 42) === true
                } ^
                    "which returns 'false' for values NOT '42'" ! {
                        invoke(target, m, 0) === false
                        invoke(target, m, 101) === false
                        invoke(target, m, -101) === false
                    }
            case _ =>
                "have a method called '" + name + "'" ! {
                    Pending()
                }
        }
    }

    def spec2: FS = {
        val name = "signum"
        getMethod(target, name) match {
            case Some(m) =>
                "which returns '-1' for negative numbers" ! {
                    invoke(target, m, -1) === -1
                    invoke(target, m, -10) === -1
                } ^
                    "which returns '1' for positive numbers" ! {
                        invoke(target, m, 1) === 1
                        invoke(target, m, 10) === 1
                    }
            case _ =>
                "have a method called '" + name + "'" ! {
                    Pending()
                }
        }

    }

    def spec3: FS = {
        val name = "absMax"
        getMethod(target, name) match {
            case Some(m) =>
                "which returns TODO" >> {
                    invoke(target, m, 0, 0) === 0
                    // TODO
                }
            case _ =>
                "have a method called '" + name + "'" ! {
                    Pending()
                }
        }
    }
}
