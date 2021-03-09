object Tren extends App {

  val aOpt: Option[Int] = ???
  aOpt match {
    case Some(a) =>

      if (a >= 1) {


        try {
          throw new Exception
        }
        catch {
          case e: Exception =>
            println("ошибка" + e.getMessage)
        }
      }

    case None =>
  }
}
