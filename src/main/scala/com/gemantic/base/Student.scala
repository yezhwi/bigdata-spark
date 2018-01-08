package com.gemantic.base

/**
  * @author Yezhiwei
  * @date 18/1/4
  */
class Student private (val sno: Int, val name: String){

  override def toString: String = {
    "sno " + sno + " name " + name
  }
}

object Student {
  private var sno = 0

  private def newSno = {
    sno += 1
    sno
  }


  def apply(name: String): Student = {

    println("call apply method...")
    new Student(newSno, name)
  }
}

object StudentMain extends App {
  // no new
  val student1 = Student("Yezhiwei")
  println(student1.toString)

  println("*" * 10)
  val student2 = Student("Yezhiwei")
  println(student2.toString)
}
