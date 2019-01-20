name := "intellij-escaped-output-bug"

version := "0.1"

scalaVersion := "2.11.11"

val sparkVersion = "2.3.0"
val scalaTestVersion = "3.0.4"
val sparkFastTestsVersion = "0.16.0"

resolvers += "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % sparkVersion % Provided,
  "org.scalatest" %% "scalatest" % scalaTestVersion % Test,
  "MrPowers" % "spark-fast-tests" % sparkFastTestsVersion % Test
)