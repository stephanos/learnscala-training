import sbt._
import Keys._

//import org.sbtidea._

object ExercisesBuild extends Build {

  import Deps._

  override lazy val settings =
    super.settings ++ Seq(
      scalaVersion := Dep.scala
    )

  lazy val root =
    Project(id = "LearnScala", base = file("."))
      //.settings(SbtIdeaPlugin.ideaSettings: _*)
      //.settings(fork in Test := true)
      .settings(parallelExecution in Test := false)
      .settings(mainClass in(Compile, run) := Some("de.learnscala.solutions.L030"))
      .settings(libraryDependencies ++= dbKit ++ utilKit ++ scalaKit ++ httpKit ++ testKit)
      .settings(resolvers ++= Seq("codahale" at "http://repo.codahale.com"))
      .settings(resolvers ++= Seq("releases" at "http://oss.sonatype.org/content/repositories/releases"))
}


object Deps {

  import Dep._

  val dbKit = Seq(h2)
  val utilKit = Seq(jodaTime)
  val httpKit = Seq() //spray, sprayIo, sprayCan, sprayClient)
  val testKit = Seq(Test.specs2, Test.mockito, Test.junit)
  val scalaKit = Seq(scalaActors, scalaCompiler, scalaLib, scalaReflect, scalaSwing)
}


object Dep {

  val scala = "2.10.0-M6"

  val akka2 = "com.typesafe.akka" % "akka-actor" % "2.0.2"
  val h2 = "com.h2database" % "h2" % "1.3.166"
  val http = "org.apache.httpcomponents" % "httpclient" % "4.2"
  val jerkson = "com.codahale" % "jerkson_2.9.1" % "0.5.0"
  val jodaTime = "joda-time" % "joda-time" % "2.1"
  val rogue = "com.foursquare" %% "rogue" % "1.1.8"
  val scalaActors = "org.scala-lang" % "scala-actors" % scala
  val scalaCompiler = "org.scala-lang" % "scala-compiler" % scala
  val scalaLib = "org.scala-lang" % "scala-library" % scala
  val scalaSwing = "org.scala-lang" % "scala-swing" % scala
  val scalaReflect = "org.scala-lang" % "scala-reflect" % scala
  val spray = "cc.spray" % "spray-server" % "1.0-M2"
  val sprayIo = "cc.spray" % "spray-io" % "1.0-M2"
  val sprayCan = "cc.spray" % "spray-can" % "1.0-M2"
  val sprayClient = "cc.spray" % "spray-client" % "1.0-M2"
  val squeryl = "org.squeryl" %% "squeryl" % "0.9.5-2"
  val unfiltered = "net.databinder" %% "unfiltered-filter" % "0.6.3"

  object Test {
    val junit = "junit" % "junit" % "4.7"
    val mockito = "org.mockito" % "mockito-all" % "1.9.0" % "test"
    val scheck = "org.scalacheck" %% "scalacheck" % "1.10.0" % "test"
    val specs2 = "org.specs2" %% "specs2" % "1.11" % "test"
  }

}