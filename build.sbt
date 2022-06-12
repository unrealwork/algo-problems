// Project name (artifact name in Maven)
name := "Solved problems from different sites on Scala"

version := "0.0.1"

scalaVersion := "2.11.7"

scalacOptions ++= Seq("-deprecation")

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// grading libraries
libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test


// for funsets
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4"
libraryDependencies += "org.testng" % "testng" % "6.13.1" % Test
libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.7" % Test
