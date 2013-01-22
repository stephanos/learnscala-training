package de.learnscala.uebungen

import de.learnscala.base._

class Ubng_F31_2 extends Exercise with Help /* with Disabled */ {

  TODO

  /*
  val chars = 'a' to 'z'
  val perms = chars flatMap { a =>
    chars flatMap { b =>
      if (a != b) Seq("%c%c".format(a, b))
      else Seq()
    }
  }

  val perms = for {
    a <- chars
    b <- chars
    if a != b
  } yield "%c%c".format(a, b)


  val host: Option[String] = ..
  val port: Option[Int] = ..

  val addr: Option[InetSocketAddress] =
    host flatMap { h =>
      port map { p =>
        new InetSocketAddress(h, p)
      }
    }

    val addr: Option[InetSocketAddress] = for {
      h <- host
      p <- port
    } yield new InetSocketAddress(h, p)

  */
}