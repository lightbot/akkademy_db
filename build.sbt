name := "akkademy_db"

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "2.2.4" % "test",
    "com.typesafe.akka" %% "akka-actor" % "2.3.11",
    "com.typesafe.akka" %% "akka-testkit" % "2.3.11" % "test"
)
