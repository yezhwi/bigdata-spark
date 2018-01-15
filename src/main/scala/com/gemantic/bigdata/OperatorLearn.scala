package com.gemantic.bigdata

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author Yezhiwei
  * @date 18/1/12
  */
object OperatorLearn extends App {

  val conf = new SparkConf().setAppName("OperatorLearn").setMaster("local")
  val sc = new SparkContext(conf)

  // map
  val animal = sc.parallelize(List("dog", "salmon", "salmon", "rat", "elephant"))
//  println(animal.map(_.length).collect.foreach(println))
//  val len = animal.map(_.length)
//
//  val c = animal.zip(len)
//  println(c.collect.foreach(println))

  // flatMap
//  println("=" * 10 + "flotMap" + "=" * 10)
//  println(animal.flatMap(x => List(x, x.length)).collect.foreach(print))

  // mapPartitions
//  println("=" * 10 + "mapPartitions" + "=" * 10)
//  println(animal.mapPartitions(iter => iter.filter(_.length > 3)).collect.foreach(println))


  // glom
//  val a = sc.parallelize(1 to 10, 3)
//  println(a.glom.collect.map{x => x.foreach(elem => print(elem + " ")); println})

  // union
//  val felidae = sc.parallelize(List("cat", "tiger"))
//  val zoo = animal ++ felidae
//  println(zoo.collect.foreach(println))

  // cartesian
//  val x = sc.parallelize(List(1,2,3,4,5))
//  val y = sc.parallelize(List(6,7,8,9,10))
//  val carRDD = x.cartesian(y)
//  println(carRDD.collect.foreach(elem => elem match {
//      case (x, y) => println(x + " " + y)
//    }
//  ))

//  val groupByRDD = a.groupBy(x => if (x % 2 == 0) "even" else "odd")
////  Array[(String, Seq[Int])] = Array((even,ArrayBuffer(2, 4, 6, 8)), (odd,ArrayBuffer(1, 3, 5, 7, 9)))
//  groupByRDD.collect.map(elem => elem match {
//    case (x: String, y: Iterable[Int]) => println(x.mkString + " : " + y.mkString(", "))
//    case _ => "..."
//  })

  // filter
//  val evenRDD = a.filter(_ % 2 == 0)
//  println(evenRDD.collect.mkString(", "))

  // distinct
//  println(animal.distinct.collect.mkString(", "))

  // subtract
//  val a = sc.parallelize(1 to 9, 3)
//  val b = sc.parallelize(1 to 3, 3)
//  val c = a.subtract(b)
//  println(c.collect.mkString(", "))

  // sample
//  println(a.sample(false, 0.5, 10).collect.mkString(", "))
//  println(a.sample(true, 0.5, 10).collect.mkString(", "))

  // takeSample
//  println(a.takeSample(false, 5, 10).mkString(", "))
//  println(a.takeSample(true, 5, 10).mkString(", "))

  // mapValues
//  val lenAnimal = animal.map(x => (x.length, x))
//  println(lenAnimal.mapValues("|" + _ + "|").collect.mkString(", "))

  // reduceByKey
//  val lenRDD = animal.map(x => (x.length, x))
//  println(lenRDD.reduceByKey(_ + _).collect.mkString(", "))

  // cogroup
//  val a = sc.parallelize(List(1, 2, 1, 3), 1)
//  val b = a.map((_, "b"))
//  val c = a.map((_, "c"))
//  println(b.cogroup(c).collect.mkString(", "))

//  val a = sc.parallelize(List("dog", "salmon", "salmon", "rat", "elephant"), 3)
//  val b = a.keyBy(_.length)
//  println(b.collect.mkString(", "))
//  val c = sc.parallelize(List("dog","cat","gnu","salmon","rabbit","turkey","wolf","bear","bee"), 3)
//  val d = c.keyBy(_.length)
//  println(d.collect.mkString(", "))

  // join
//  println(b.join(d).collect.mkString(", "))
  // leftOuterJoin
//  println(b.leftOuterJoin(d).collect.mkString(", "))
  // rightOuterJoin
//  println(b.rightOuterJoin(d).collect.mkString(", "))

  // collectAsMap
//  val a = sc.parallelize(List(1, 2, 1, 3), 1)
//  val b = a.zip(a)
//  println(b.collectAsMap.foreach(elem => elem match {
//    case (k, v) => println(k + "->" + v)
//  }))

  // lookup
//  val a = sc.parallelize(List("dog", "tiger", "lion", "cat", "panther", "eagle"), 2)
//  val b = a.map(x => (x.length, x))
//  println(b.lookup(5).mkString(", "))

  // cache
  println(animal.getStorageLevel)
  val animalCache = animal.cache
  println(animal.getStorageLevel)
  println(animalCache.getStorageLevel)
  println(animalCache.map(_.length).collect.foreach(println))
  println(animalCache.map(_.length).collect.foreach(println))

  sc.stop()
}
