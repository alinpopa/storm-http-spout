import sbt._
import Keys._
import sbt.{Build => SbtBuild}
import org.sbtidea.SbtIdeaPlugin._
import com.typesafe.sbt.SbtStartScript._
import xerial.sbt.Pack._

object Build extends SbtBuild {
  val commonSettings =
  packSettings ++
  Seq(
    organization := "storm",
    scalaVersion := "2.11.0",
    crossPaths := false,
    ideaExcludeFolders := ".idea" :: ".idea_modules" :: Nil,
    scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation"),
    javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation"),
    fork in Test := false,
    packMain := Map("httpstream" -> "storm.SampleApp"),
    resolvers ++= Seq(
      "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
      "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
      "Apache Snapshots" at "https://repository.apache.org/content/repositories/snapshots/",
      "Github releases" at "http://oss.sonatype.org/content/repositories/github-releases",
      "Clojars" at "http://clojars.org/repo"
    ),
    libraryDependencies ++= Seq(
      "org.apache.storm" % "storm-core" % "0.9.2-incubating" % "compile"
    )
  ) ++ startScriptForClassesSettings

  lazy val root = Project(
    id = "storm-http-spout",
    base = file("."),
    settings = commonSettings
  )
}

