ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.2"

Compile / scalaSource := baseDirectory.value / "src"


lazy val root = (project in file("."))
  .settings(
    name := "TP1-PCF"
  )
