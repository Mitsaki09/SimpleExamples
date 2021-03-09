object PaswordWxample extends App {
  println("введите пароль")
  try {
    val firstQuestion: String = scala.io.StdIn.readLine()

    if (firstQuestion == "12345") {
      throw new Exception("неть2")
    }

    if (firstQuestion == "qwerty") {
      throw new Exception("неть3") {

      }

    }
      if (firstQuestion.length > 4) {
        println("пароль" + firstQuestion)
      } else {

          throw new Exception("неть") {

          }
        }




    }


}




