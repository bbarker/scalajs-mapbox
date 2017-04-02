// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

name := "scalajs-mapbox"

version := "0.1-RC1"

scalaVersion := "2.12.1"

scalaJSUseMainModuleInitializer in Compile := true
scalaJSUseMainModuleInitializer in Test := false

testFrameworks += new TestFramework("utest.runner.Framework")

//Need to wait until new MapBox is available in WebJar:
//skip in packageJSDependencies := false

// Show more comments when using dubious features
scalacOptions += "-feature"

libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.1",
    "com.lihaoyi" %%% "utest" % "0.4.5" % "test"
)

publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (version.value.trim.endsWith("SNAPSHOT"))
        Some("snapshots" at nexus + "content/repositories/snapshots")
    else
        Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true
publishArtifact in Test := false
organization := "io.github.bbarker"

pomExtra :=
  <url>https://github.com/bbarker/scalajs-mapbox</url>
    <licenses>
        <license>
            <name>Apache 2</name>
            <url>http://www.apache.org/licenses/</url>
        </license>
    </licenses>
    <scm>
        <url>git://github.com/bbarker/scalajs-mapbox.git</url>
        <connection>scm:git://github.com/bbarker/scalajs-mapbox.git</connection>
    </scm>
    <developers>
        <developer>
            <id>bbarker</id>
            <name>Brandon Elam Barker</name>
            <url>http://bbarker.github.io</url>
        </developer>
    </developers>

credentials += Credentials(Path.userHome / ".ivy2/.credentials")