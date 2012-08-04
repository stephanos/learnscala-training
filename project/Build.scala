import sbt._
import Keys._
//import org.sbtidea._

object ExercisesBuild extends Build with Deps {

    override lazy val settings =
        super.settings ++ Seq(
            scalaVersion := "2.10.0-M6"
        )

    lazy val root =
        Project(id = "LearnScala", base = file("."))
            //.settings(libraryDependencies ++= Seq(http))
            .settings(libraryDependencies ++= Seq(Test.specs2, Test.mockito, Test.junit))
            //.settings(SbtIdeaPlugin.ideaSettings: _*)
            .settings(resolvers ++= Seq("releases" at "http://oss.sonatype.org/content/repositories/releases"))
}


trait Deps {

    val akka2 = "com.typesafe.akka" % "akka-actor" % "2.0.2"
    val h2 = "com.h2database" % "h2" % "1.3.166"
    val http = "org.apache.httpcomponents" % "httpclient" % "4.2"
    val jodaTime = "joda-time" % "joda-time" % "2.1"
    val spray = "cc.spray" % "spray-server" % "1.0-M2"
    val sprayIo = "cc.spray" % "spray-io" % "1.0-M2"
    val sprayCan = "cc.spray" % "spray-can" % "1.0-M2"
    val sprayClient = "cc.spray" % "spray-client" % "1.0-M2"


    object Test {
        val junit = "junit" % "junit" % "4.7"
        val mockito = "org.mockito" % "mockito-all" % "1.9.0" % "test"
        val scheck = "org.scalacheck" %% "scalacheck" % "1.10.0" % "test"
        val specs2 = "org.specs2" %% "specs2" % "1.11" % "test"
    }

}