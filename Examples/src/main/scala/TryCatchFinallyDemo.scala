object TryCatchFinallyDemo extends App {

  println("password:")
  val userPassword: String = scala.io.StdIn.readLine()

  try { // начало зоны, где мы ожидаем ошибку

    if (userPassword == "qwerty") {
      println("секретные данные")
    } else {
      throw new WrongPasswordException() // без throw работать не будет
    }


    println("Введите номер счета")
    val cardNumber: String = scala.io.StdIn.readLine()

    println("Введите код подтверждения с смс")
    val code: String = scala.io.StdIn.readLine()


    if (code == "1234") {
      println("я скидываю высе деньги куда-то на счет " + cardNumber)
    } else {
      throw new Exception("Неверный код из смс") // без throw работать не будет
    }

  } //конец зоны, где мы ожидаем ошибку
  catch { // блок, который должен следовать сразу после блока Try. Ловит все ошибки
    case e: WrongPasswordException =>
      println("e.getMessage:" + e.getMessage)
      println("Это точно проблема с паролем")

    case e: Exception =>
      println("e.getMessage:" + e.getMessage)
      println("что-то пошло не так")
  }
  finally {
    println("Этот блок сработает в любом случае")
  }
}

class WrongPasswordException() extends Exception("=============> wrong password")
