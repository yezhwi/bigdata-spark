package com.gemantic.base

import java.awt.Color

/**
  * @author Yezhiwei
  * @date 18/1/8
  */
object MatchLearn  extends App {

  val ch: Char = '-'

  val sign = ch match {
    case '+' => 1
    case '-' => -1
    case _ => 0
  }

  println("sign " + sign)

  // match 还可以是非数字类型的
  val color = Color.RED
  val c = color match {
    case Color.RED => "red"
    case Color.BLACK => "black"
    case _ => "pink"
  }

  println("color is " + c)

  val param = '4'

  val matchResult = param match {
    case '+' => 1
    case '-' => -1
    case _ if Character.isDigit(param) => Character.digit(param, 10)
    case _ => 0
  }

  println("match result " + matchResult)

  val param1 = '4'

  val matchResult1 = param match {
    case '+' => 1
    case '-' => -1
    case ch if Character.isDigit(ch) => Character.digit(ch, 10)
    case _ => 0
  }

  println("match result1 : " + matchResult1)


  print("*" * 10)
  print("Type")
  println("*" * 10)
  def patternType(obj: Any) = obj match {
    case x: Int => x
    case s: String => s
    case _: BigInt => Int.MaxValue
    case _ => 0
  }

  println(patternType(1))
  println(patternType("1"))
  println(patternType(BigInt.apply(10)))
  println(patternType(BigDecimal.apply(10)))

  print("*" * 10)
  print("Array")
  println("*" * 10)
  def patternArray(obj: Array[Any]) = obj match {
    // 匹配包含0的数组
    case Array(0) => "0"
    // 匹配任意两个元素的数组，并将这两个元素分别绑定到x 和 y 变量
    case Array(x, y) => x + " <-> " + y
    // 匹配以0开始的数组
    case Array(0, _*) => "0 ..."
    case _ => "something else"
  }

  println(patternArray(Array(0)))
  println(patternArray(Array(1, 2)))
  println(patternArray(Array(0, 2, 4)))
  println(patternArray(Array(2, 4, 6)))


  print("*" * 10)
  print("List")
  println("*" * 10)
  def patternList(obj: List[Int]) = obj match {
    // 匹配包含0的List
    case 0 :: Nil => "0"
    // 匹配任意两个元素的List，并将这两个元素分别绑定到x 和 y 变量
    case x :: y :: Nil => x + " <-> " + y
    // 匹配以0开始的List
    case 0 :: tail => "0 ..."
    case _ => "something else"
  }

  println(patternList(List(0)))
  println(patternList(List(1, 2)))
  println(patternList(List(0, 2, 4, 6, 8)))
  println(patternList(List(2, 4, 6, 8)))


  print("*" * 10)
  print("Tuple")
  println("*" * 10)
  def patternTuple(x: Int, y: Int) = (x, y) match {
    // 匹配包含0的List
    case (0, _) => "0 ... "
    // 匹配任意两个元素的List，并将这两个元素分别绑定到x 和 y 变量
    case (y, 0) => y + " 0 "
    case _ => "tuple something else"
  }

  println(patternTuple(0, 1))
  println(patternTuple(2, 0))
  println(patternTuple(1, 2))
}
