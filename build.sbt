name := "TwitterActor"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies += "org.twitter4j" % "twitter4j-core" % "4.0.3"
libraryDependencies += "org.twitter4j" % "twitter4j-async" % "4.0.3"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"
libraryDependencies += "com.typesafe.akka" %% "akka-cluster" % "2.3.11"