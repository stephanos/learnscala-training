package de.learnscala.specs

import de.learnscala.uebungen.U060._
import de.learnscala.base.BaseTest

class S060 extends BaseTest {

    spec("S060", enabled) {

        "half" >> {
            "must calculate half of 10" >> {
                half(10) === 5
            }
            "must calculate half of 100" >> {
                half(100) === 50
            }
            "must calculate half of -10" >> {
                half(-10) === -5
            }
            "must throw Exception for 3" >> {
                half(3) must throwA[Throwable]
            }
            "must throw Exception for 5" >> {
                half(5) must throwA[Throwable]
            }
        }

        "username" >> {
            "must return 'Bob' for '1' and close connection" >> {
                val c = new Connection("oracle")
                username(c, 1) === "Bob"
                !c.isOpen aka "connection closed" must_== true
            }
            "must return 'Jim' for '2' and close connection" >> {
                val c = new Connection("oracle")
                username(c, 2) === "Jim"
                !c.isOpen aka "connection closed" must_== true
            }
            "must print 'no user found' if 'NoSuchElementException' is thrown, close connection and return null" >> {
                val c = new Connection("oracle")
                val (r, out) = captureOutput(username(c, 5))
                r.getOrElse(null) === null
                out.trim === "no user found"
                !c.isOpen aka "connection closed" must_== true
            }
            "must print 'invalid user id' if 'IllegalArgumentException' is thrown, close connection and return null" >> {
                val c = new Connection("oracle")
                val (r, out) = captureOutput(username(c, 0))
                r.getOrElse(null) === null
                out.trim === "invalid user id"
                !c.isOpen aka "connection closed" must_== true
            }
            "must print 'connection not open' if 'RuntimeException' is thrown; and return null" >> {
                val c = new Connection("")
                val (r, out) = captureOutput(username(c, 1))
                r.getOrElse(null) === null
                out.trim === "connection not open"
            }
        }
    }
}