import scala.util.{Failure, Success, Try}
object ExceptionAndTry extends App {


  def getInt: Int = {


    println("введите число больше 10")
    val int: Int = scala.io.StdIn.readInt()
    if (int >= 10) {
      println("это число " + int)
      int

    } else {
      throw new Exception("не")

    }
  }


  val exampleOfSuccessTry: Try[Int] = Try {
    getInt
  }
  exampleOfSuccessTry match {
    case Success(int) =>
      println(int)
      int
    case Failure(exception) =>
      println("не не")

  }


  def getAgeJava: Int = { // java style
    try {
      val age = scala.io.StdIn.readInt()
      println("Введен возраст " + age)
      age
    }
    catch {
      case e: Exception =>
        println("Введен не Int, значение по умолчанию 0")
        0
    }
  }

  def getAgeScala: Int = { // scala style
    val ageTry = Try {
      val age = scala.io.StdIn.readInt()
      age
    }
    ageTry.getOrElse(0)
    ageTry match {
      case Success(age) =>
        println("Введен возраст " + age)
        age
      case Failure(e) =>
        println("Введен не Int, значение по умолчанию 0")
        0
    }
  }


}




