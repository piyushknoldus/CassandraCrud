name := "CassandraCrud"

version := "1.0"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  "com.datastax.cassandra" % "cassandra-driver-extras" % "3.0.0",
  "com.typesafe"               %  "config"           % "1.3.1",
  "ch.qos.logback"                 %  "logback-classic"                   % "1.1.7",
  "com.typesafe.scala-logging"     %% "scala-logging"                     % "3.4.0"
)

fork in (IntegrationTest, run) := true
