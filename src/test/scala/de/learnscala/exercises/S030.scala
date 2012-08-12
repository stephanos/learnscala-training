package de.learnscala.exercises

import de.learnscala.base.BaseTest
import org.specs2.execute.Pending

class S030 extends BaseTest("U030") {

    "Task #1" >> {

        val name = "isTheAnswerToLifeTheUniverseAndEverything"

        println(target)
        println(target.getClass())
        println(getMembers(target, _ => true))
        getMethod(target, name) match {
            case Some(m) =>
                "which returns 'true' for value '42'" >> {
                    invoke(target, m, 42) === true
                }
                "which returns 'false' for values NOT '42'" >> {
                    invoke(target, m, 0) === false
                    invoke(target, m, 101) === false
                    invoke(target, m, -101) === false
                }
            case _ =>
                "have a method called '" + name + "'" >> {
                    1 === 0
                    //Pending()
                }
        }
    }

    "Task #2" >> {

        val name = "signum"

        getMethod(target, name) match {
            case Some(m) =>
                "which returns '-1' for negative numbers" >> {
                    invoke(target, m, -1) === -1
                    invoke(target, m, -10) === -1
                }
                "which returns '1' for positive numbers" >> {
                    invoke(target, m, 1) === 1
                    invoke(target, m, 10) === 1
                }
            case _ =>
                "have a method called '" + name + "'" >> {
                    1 === 0
                    Pending()
                }
        }
    }

    "Task #3" >> {

        val name = "absMax"

        getMethod(target, name) match {
            case Some(m) =>
                "which returns TODO" >> {
                    invoke(target, m, 0, 0) === 0
                    // TODO
                }
            case _ =>
                "have a method called '" + name + "'" >> {
                    Pending()
                }
        }
    }
}