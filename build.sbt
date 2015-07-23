// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

name := "scalajs-mapbox"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.6"

persistLauncher in Compile := true

persistLauncher in Test := false

testFrameworks += new TestFramework("utest.runner.Framework")

//Need to wait until new MapBox is available in WebJar:
//skip in packageJSDependencies := false

// Show more comments when using dubious features
scalacOptions += "-feature"

libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.1",
    "com.lihaoyi" %%% "utest" % "0.3.1" % "test"
)
