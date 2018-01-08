package com.gemantic.base

/**
  * @author Yezhiwei
  * @date 18/1/8
  */
object OptionLearn extends App {

  val site: Map[String, String] = Map("baidu" -> "www.baidu.com", "google" -> "www.google.com")
  val value1 = site.get("Yezhiwei")
  val value2: Option[String] = site.get("Yezhiwei")
  val value3: Option[String] = site.get("baidu")

  println("value1 " + value1)
  println("value2 " + value2)
  println("value3 " + value3)
  println()
  println("show value2 " + show(value2))
  println("show value3 " + show(value3))


  def show(v: Option[String]) = v match {

    case Some(v) => v
    case None => "?"
  }
}


