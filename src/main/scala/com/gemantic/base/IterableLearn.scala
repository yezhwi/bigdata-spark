package com.gemantic.base

/**
  * @author Yezhiwei
  * @date 18/1/10
  */
object IterableLearn extends App{

  val digits = List(4, 2)

  println("head " + digits.head)
  println("tail " + digits.tail)

  // 右结合性
  println(9 :: digits)
  println(List(1, 3) :: 9 :: Nil)

  // 求列表的和
  println(digits.sum)

  println("--" * 10)

  // 1 已经存在，不会被重复添加
  println(Set(1, 2, 3) + 1)

  // 链式哈希集可以记住元素被插入的顺序
  val weekdays = scala.collection.mutable.LinkedHashSet("Mo", "Tu", "We", "Th", "Fr")
  println("weekdays " + weekdays)

  // 按照已排顺序来访问集中的元素
  println(scala.collection.mutable.SortedSet(2, 4, 1, 5))

  val digitsSet = Set(2, 5, 9)
  // 检查某个值是否在集合中
  println(digitsSet.contains(3))
  println(digitsSet.contains(5))

  // 某个集合中的所有元素是否包含在另一个集合中
  println(Set(2, 4).subsetOf(digitsSet) )
  println(Set(2, 5).subsetOf(digitsSet) )

  val set1 = Set(1, 2)
  val set2 = Set(2, 4)

  // 并 | 或 ++ 或 union
  println("====并 | 或 ++ 或 union====")
  println(set1 | set2)
  println(set1 ++ set2)
  println(set1 union set2)
  // 差 &~ 或 -- 或 diff
  println("====差 &~ 或 -- 或 diff====")
  println(set1 &~ set2)
  println(set1 -- set2)
  println(set1 diff set2)
  // 交 & 或 intersect
  println("====交 & 或 intersect====")
  println(set1 & set2)
  println(set1 intersect set2)

  println("--" * 10)

  val names = List("Perter", "Paul", "Mary")
  println("names to upperCase" + names.map(_.toUpperCase))

  def ulcase(s: String) = Vector(s.toUpperCase, s.toLowerCase)
  // 函数返回的是一个值
  println(names.map(ulcase(_)))

  // 函数返回的是一个集合
  println(names.flatMap(ulcase(_)))

  println("--" * 10)


  // 相当于(((1 + 2) + 3) + 4) + 5
  println("从1加到5的和")
  println(List(1, 2, 3, 4, 5).reduceLeft(_ + _))


  println("初始值为6，从左到右将1加到5的和")
  println(List(1, 2, 3, 4, 5).foldLeft(6)(_ + _))
  println((6 /: List(1, 2, 3, 4, 5))(_ + _))

  println("统计字符串中每个字符出现的次数")
  val m = (Map[Char, Int]() /: "Mississipyyz") (
    (m, c) => m + (c -> (m.getOrElse(c, 0) + 1))
  )
  for((k, v) <- m) {
    println(k, v)
  }

  println("产出所有中间结果和最后的和")
  println((1 to 10).scanLeft(0)(_ + _))

  println("--" * 10)

  val prices = List(50.0, 20.0, 9.8)
  val quantities = List(10, 20, 50)

  println(prices zip quantities)

  // 计算每类商品的价格列表
  println((prices zip quantities).map(p => p._1 * p._2))

  // 所有物件的总价
  println((prices zip quantities).map(p => p._1 * p._2).sum)

  // 将对应位置的元素组成一个pair，若列表长度不一致，自身列表比较短的话使用thisElem进行填充，对方列表较短的话使用thatElem进行填充
  println(prices.zipAll(List(2, 3), 0, 3))
  println(prices.zipAll(List(2, 3, 4, 6), 0, 3))
}
