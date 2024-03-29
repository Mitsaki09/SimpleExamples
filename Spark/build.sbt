name := "Spark"

version := "0.1"

scalaVersion := "2.12.11"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.0"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.4.0"


libraryDependencies += "org.postgresql" % "postgresql" % "42.2.23"