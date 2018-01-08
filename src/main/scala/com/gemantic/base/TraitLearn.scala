package com.gemantic.base

/**
  * @author Yezhiwei
  * @date 18/1/6
  */
object TraitLearn {

  def main(args: Array[String]): Unit = {
    // 当做接口使用的特质
    val logger = new ConsoleLogger
    logger.log("console log message...")

    // 带有具体实现的特质
//    val accountAction = new AccountAction
//    accountAction.withdraw(1000)

    // 带有特质的对象
    val accountActionLogger = new AccountAction with FileLogged with TimestampLogged with ShortLogged
    accountActionLogger.withdraw(1000)

    val accountActionLogger1 = new AccountAction with FileLogged with ShortLogged with TimestampLogged
    accountActionLogger1.withdraw(1000)
  }
}


trait Logger {
  def log(msg: String)
}

// 有默认实现，但是什么也没有做
trait Logged {
  def log(msg: String) {}
}


class ConsoleLogger extends Logger with Serializable {
  override def log(msg: String): Unit = println(msg)
}

trait ConsoleLoggerImp {
  def log(msg: String) {println(msg)}
}

//class AccountAction extends Account with ConsoleLoggerImp {
//
//  def withdraw(amount: Double): Unit = {
//    if (amount > nowBalance) {
//      log("insufficient funds")
//    } else {
//      log("enough funds")
//    }
//  }
//}

class AccountAction extends Account with Logged {

  def withdraw(amount: Double): Unit = {
    if (amount > nowBalance) {
      log("insufficient funds")
    } else {
      log("enough funds")
    }
  }
}

trait FileLogged extends Logged {
  override def log(msg: String): Unit = println("saving file : " + msg)
}

// 为日志增加时间戳
trait TimestampLogged extends Logged {
  override def log(msg: String): Unit = super.log(new java.util.Date() + " " +  msg)
}

// 如果日志内容长度超过10，截断
trait ShortLogged extends Logged {
  override def log(msg: String): Unit = super.log(if (msg.length <= 10) msg else msg.substring(0, 10) + "...")
}