name := "play-java-intro"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "org.apache.httpcomponents" % "httpcore" % "4.4.6",
  "org.apache.httpcomponents" % "httpclient" % "4.5.2" //to make http request
)

