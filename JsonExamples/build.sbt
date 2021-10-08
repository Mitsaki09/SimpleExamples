name := "JsonExamples"

version := "0.1"

scalaVersion := "2.13.5"


val circeVersion = "0.12.3"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

val akkaVersion = "2.6.3"
val akkaHttpVersion = "10.1.9"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,

  "de.heikoseeberger" %% "akka-http-circe" % "1.36.0" excludeAll(ExclusionRule(organization = "de.heikoseeberger")),
  "io.circe" %% "circe-parser" % "0.13.0-RC1",
  "io.circe" %% "circe-generic" % "0.13.0-RC1",
  "org.scalatest" %% "scalatest" % "3.2.2"
)
libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.3.2",
  "org.postgresql" % "postgresql" % "42.2.10",
  "com.github.tminglei" %% "slick-pg_core" % "0.18.1"
)