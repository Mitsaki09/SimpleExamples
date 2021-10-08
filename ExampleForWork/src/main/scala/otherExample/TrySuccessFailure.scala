import scala.util.{Failure, Success, Try}

class TrySuccessFailure {
// Try хранит в себе два значения. Success - как в Either Left (правильное) или Failure как Right в Either, Try используется для ловли ошибок
  // чтобы ловить ошибки, в Success результат успешный, в Failure если ошибка
  def sumPositiveWithTry(a: Int, b: Int): Try[Int] = {
    Try {
      if (a < 0 || b < 0) {
        throw new Exception("А либо Б меньше 0")
      } else a + b
    }
  }

  val tryResult: Try[Int] = sumPositiveWithTry(5, -10)
  tryResult match {
    case Success(sum) => println(sum)
    case Failure(exception) => println(exception)
  }

  val ttOpt: Option[Int] = tryResult.toOption
  val ttEither: Either[Throwable, Int] = tryResult.toEither
  val tt: Int = tryResult.getOrElse(0)

  val `try`: Try[Int] = Try(5)
  val trySucces: Try[Int] = Success(5)
  val tryFailure: Try[Int] = Failure(new Exception("fdbdf"))


  val res: Try[Int] = for {
    res1 <- sumPositiveWithTry(5, 5)
    res2 <- sumPositiveWithTry(6, -6)
    res3 <- sumPositiveWithTry(7, 7)
  } yield res1 + res2 + res3

}
