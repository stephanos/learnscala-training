import sbt._
import Keys._

object ExercisesBuild extends Build {

    import Deps._

    override lazy val settings =
        super.settings ++ Seq(

            version := "1.0",

            scalaVersion := Dep.scala,
            scalaBinaryVersion := Dep.scalaM,
            libraryDependencies ++= dbKit ++ utilKit ++ httpKit ++ scalaKit ++ testKit,

            fork in Test := true,
            parallelExecution in Test := false,

            resolvers ++= Seq("codahale" at "http://repo.codahale.com"),
            resolvers ++= Seq("typesafe" at "http://repo.typesafe.com/typesafe/releases/"),
            resolvers ++= Seq("releases" at "http://oss.sonatype.org/content/repositories/releases")
        )

    lazy val root =
        Project(id = "LearnScala", base = file("."))
            .dependsOn(internal % "test->test;compile->compile")

    lazy val internal =
        Project(id = "internal", base = file("internal"))
}


object Deps {

    import Dep._
    import Http._, Util._, Test._

    val dbKit =
        Seq()

    val utilKit =
        Seq(jodaTime, jodaConvert)

    val httpKit =
        Seq()

    val testKit =
        Seq(specs2, mockito, scheck, stest, junit)

    val scalaKit =
        Seq(/*scalaActors, scalaSwing,*/ scalaReflect /*scalaCompiler, scalaLib*/)
}


object Dep {

    val scalaM = "2.10"
    val scala = scalaM + ".0"

    val scalaActors = "org.scala-lang" % "scala-actors" % scala
    val scalaCompiler = "org.scala-lang" % "scala-compiler" % scala
    val scalaLib = "org.scala-lang" % "scala-library" % scala
    val scalaReflect = "org.scala-lang" % "scala-reflect" % scala
    val scalaSwing = "org.scala-lang" % "scala-swing" % scala

    object Http {

        val dispatch = "net.databinder.dispatch" %% "core" % "0.9.1"
        val http = "org.apache.httpcomponents" % "httpclient" % "4.2"
        val spray = "cc.spray" %% "spray-server" % "1.0-M2"
        val sprayIo = "cc.spray" %% "spray-io" % "1.0-M2"
        val sprayCan = "cc.spray" %% "spray-can" % "1.0-M2"
        val unfiltered = "net.databinder" %% "unfiltered-filter" % "0.6.3"
    }

    object Util {

        val jodaTime = "joda-time" % "joda-time" % "2.1"
        val jodaConvert = "org.joda" % "joda-convert" % "1.2"
    }

    object Database {

        val h2 = "com.h2database" % "h2" % "1.3.168"
        val slick = "com.typesafe" %% "slick" % "0.11.1"
    }

    object Test {

        val junit = "junit" % "junit" % "4.10" % "test"
        val mockito = "org.mockito" % "mockito-all" % "1.9.0" % "test"
        val scheck = "org.scalacheck" %% "scalacheck" % "1.10.0" % "test"
        val specs2 = "org.specs2" %% "specs2" % "1.13" % "test"
        val stest = "org.scalatest" %% "scalatest" % "1.9.1" % "test"
        val smock = "org.scalamock" %% "scalamock-core" % "3.0-M3" % "test"
    }

}