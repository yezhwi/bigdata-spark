package com.gemantic.bigdata

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author Yezhiwei
  * @date 17/12/27
  */

object WordCount {
  def main (args: Array[String]){


    val conf = new SparkConf().setAppName("WordCount")
    // 设置序列化器为KryoSerializer。
    conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    val sc = new SparkContext(conf)

    val inputRDD = sc.textFile("README.md")
    val pythonLinesRDD = inputRDD.filter(line => line.contains("Python"))
    val wordsRDD = pythonLinesRDD.flatMap(line => line.split(" "))
    val countsRDD = wordsRDD.map(word => (word, 1)).reduceByKey(_ + _)

    countsRDD.saveAsTextFile("outputFile")
    sc.stop()
  }
}
