package com.gemantic.base

/**
  * @author Yezhiwei
  * @date 18/1/8
  */
object CaseClassLearn extends App {


  def patternAmount(amount: Amount) = amount match {
      case Dollar(v) => "$" + v
      case Currency(v, u) => "I got " + v + " " + u
//      case Nothing => "Nothing"
//      case _ => ""
  }


  println(patternAmount(Dollar(1.0)))
  println(patternAmount(Currency(1.0, "RMB")))
  println(patternAmount(Nothing))
}

abstract class Amount
//sealed abstract class Amount

case class Dollar(value: Double) extends Amount

case class Currency(value: Double, unit: String) extends Amount

// 样例对象
case object Nothing extends Amount
