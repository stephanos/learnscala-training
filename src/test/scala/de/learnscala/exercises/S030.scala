package de.learnscala.exercises

import de.learnscala.base.BaseTest

class S030 extends BaseTest(U030) {

    def specs =
        task(1, "answer to life")(spec1) ^
            task(2, "")(spec2) ^ task(3, "")(spec3)

    def spec1 = {

        val name = "isTheAnswerToLifeTheUniverseAndEverything"
        val mth = getMethod[T](name)

        "have a method called '" + name + "'" ! {
            mth must beSome
        } ^
            "which returns 'true' for value '42'" ! {
                invoke(ubng, mth.get, 42) === true
            } ^
            "which returns 'false' for values NOT '42'" ! {
                invoke(ubng, mth.get, 0) === false
                invoke(ubng, mth.get, 101) === false
                invoke(ubng, mth.get, -101) === false
            }
    }

    def spec2 = {
        val name = "signum"
        val mth = getMethod[T](name)

        "have a method called '" + name + "'" >> {
            mth must beSome
        }
        "which returns '-1' for negative numbers" >> {
            val m = mth.get
            invoke(ubng, m, -1) === -1
            invoke(ubng, m, -10) === -1
        }
        "which returns '1' for positive numbers" >> {
            val m = mth.get
            invoke(ubng, m, 1) === 1
            invoke(ubng, m, 10) === 1
        }
    }

    def spec3 = {
        val name = "absMax"
        val mth = getMethod[T](name)

        "have a method called '" + name + "'" >> {
            mth must beSome
        }
        "which returns TODO" >> {
            invoke(ubng, mth.get, 0, 0) === 0
            // TODO
        }
    }
}
