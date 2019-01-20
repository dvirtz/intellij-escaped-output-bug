package com.github.dvirtz.intellij.escaped.output.bug

import com.github.mrpowers.spark.fast.tests.DataFrameComparer
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.scalatest.FunSuite

class Test extends FunSuite with DataFrameComparer {

  lazy val spark: SparkSession = {
    SparkSession
      .builder()
      .master("local")
      .appName("spark session")
      .getOrCreate()
  }

  Logger.getLogger("org").setLevel(Level.ERROR)

  test("simple"){
    import spark.implicits._
    val sourceDF = Seq(
      (1),
      (5)
    ).toDF("number")

    val expectedDF = Seq(
      (5),
      (1)
    ).toDF("number")

    assertSmallDataFrameEquality(sourceDF, expectedDF)
    // throws a DatasetSchemaMismatch exception
  }
}
