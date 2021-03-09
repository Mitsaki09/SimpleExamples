import scala.util.{Failure, Success, Try}

object ColdWeaponExample extends App {

  def getAge: Int = {
    try {
      println("введите возраст")
      val age = scala.io.StdIn.readInt()
      println("ваш  возраст " + age)
      age
    }
    catch {
      case _: Exception =>
        getAge
    }
  }

  val exampleOfSuccessTry: Try[Int] = Try(1)
  exampleOfSuccessTry match {
    case Success(value) =>
      println("Success")
      value
    case Failure(exception) =>
      println("Failure")
      0
  }


}

