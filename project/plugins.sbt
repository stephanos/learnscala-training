logLevel := Level.Warn

// Repository: Typesafe
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Plugin: IntelliJ
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.0.0")

// Plugin: Eclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.1.0-RC1")