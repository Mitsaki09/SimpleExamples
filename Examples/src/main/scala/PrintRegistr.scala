object PrintRegistr extends App {

  case class FIO(name: String, lastName: String)

  case class NickName(nick: String)

  case class FioOrNick(fOrN: Either[FIO, NickName])

  case class Registraion(dataOpt: Option[FioOrNick])

  val fio = FIO("Валера", "Валеров")
  val nickname = NickName("ВалераМашина")
  val fioOrNick = FioOrNick(Right(nickname))
  val registraion = Registraion(Some(fioOrNick))

  println(registraion)




}