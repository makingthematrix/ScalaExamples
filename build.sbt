
ThisBuild / version := "0.1.0-SNAPSHOT"

val _scalaVersion = "3.7.1"

name := "ScalaExamples"
licenses := Seq("GPL 3.0" -> url("https://www.gnu.org/licenses/gpl-3.0.en.html"))
ThisBuild / scalaVersion := _scalaVersion
ThisBuild / versionScheme := Some("semver-spec")
Test / scalaVersion := _scalaVersion

val standardOptions = Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-encoding",
  "utf8"
)

val scala3Options = Seq(
  "-explain",
  "-Wsafe-init",
  "-Ycheck-all-patmat",
  "-Wunused:imports"
)

developers := List(
  Developer(
    "makingthematrix",
    "Maciej Gorywoda",
    "makingthematrix@protonmail.com",
    url("https://github.com/makingthematrix"))
)


lazy val root = (project in file("."))
  .settings(
    name := "ScalaExamples",
    libraryDependencies ++= Seq(
			"org.typelevel" %% "cats-core" % "2.13.0",
			"org.typelevel" %% "cats-effect" % "3.6.2",
      //Test dependencies
      "org.scalameta" %% "munit" % "1.1.1" % "test"
    ),
    scalacOptions ++= standardOptions ++ scala3Options
  )

testFrameworks += new TestFramework("munit.Framework")