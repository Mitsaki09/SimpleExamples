import com.typesafe.scalalogging.Logger

object Main extends App {

  println("Привет, друг")

  /*
  trace
  debug
  info
  warn
  error
*/
  //--------------------------------------------------------------------------------------------------------------------
  val logger = Logger[this.type]

  case class User(name:String,password:String)

  println("Введите имя: ")
  val questionName = scala.io.StdIn.readLine()
  logger.info(questionName)

  println("Введите пароль: ")
  val questionPassword = scala.io.StdIn.readLine()
  logger.debug(questionPassword)

  if(questionPassword == "qwerty"){
    logger.warn(questionPassword)
  }

  if(questionPassword.length <= 7){
    logger.error(questionPassword)
  }
  //--------------------------------------------------------------------------------------------------------------------

case class Okorochka(taste:String,fry:Int)
  val okorochka = Okorochka("вкусно",12)

  okorochka match {
    case _ if okorochka.fry == 5 => logger.info (okorochka.toString)
    case _ if okorochka.fry >= 6 => logger.warn (okorochka.toString)
    case _ if okorochka.fry == 2 => logger.error (okorochka.toString)

  }


  //--------------------------------------------------------------------------------------------------------------------
  // тизменять уровень лоирования в <root level="trace"> файл logback.xml

  logger.trace("trace msg")
  logger.debug("debug msg") // при разработке, чтобы посмотреть что лежит в переменных
  logger.info("info msg") // просто сообщение, аналог println
  logger.warn("warn msg") // когда случилась фигня, но мы с ней сами разобрались,
                          // например, когда ввели имя с маленькой буквы, а мы автоматически сделали с заглавной
  logger.error("error msg") // сюда мы передаем Exceptions


  logger.debug("my password if qwerty")

  val myException = new Exception("Test msg")
  logger.error("myException is ", myException)
}
