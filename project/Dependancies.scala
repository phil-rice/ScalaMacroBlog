import sbt._

object Dependencies {
  lazy val scalaVersionNo="2.11.7"
  
  lazy val commonDependencies = Seq(
		  "org.scala-lang" % "scala-reflect" % scalaVersionNo,
     "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  )
}