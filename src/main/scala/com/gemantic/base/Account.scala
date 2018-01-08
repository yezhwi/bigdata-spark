package com.gemantic.base

/**
  * @author Yezhiwei
  * @date 18/1/4
  */
class Account {

  val id = Account.newUniqueNumber()

  private var balance = 0.0

  def deposit(amount: Double): Double = {
    balance += amount
    balance
  }

  def nowBalance = balance;

}

object Account {
  private var lastNumber = 0

  private def newUniqueNumber() = {
    lastNumber += 1
    lastNumber
  }
}


//object Main {
//  def main(args: Array[String]): Unit = {
//    val account = new Account
//    println(account.id)
//    println(account.deposit(1))
//    println("=" * 10)
//
//    val account1 = new Account
//    println(account1.id)
//    println(account1.deposit(10))
//    println("=" * 10)
//
//    println("a " + account.nowBalance + "; b " + account1.nowBalance)
//  }
//}

object Main extends App {
  println("=" * 10)
}