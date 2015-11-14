import Dependencies._

lazy val commonSettings = Seq(
  version := "0.1.0",
  scalaVersion := "2.11.7",
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
  libraryDependencies ++= commonDependencies
)
  
lazy val macroDefn = (project in file("macroDefn")).settings(commonSettings: _*)

lazy val macroUser = (project in file("macroUser")).settings(commonSettings: _*).dependsOn(macroDefn)

lazy val root = project.aggregate(macroDefn, macroUser)


