object PovarExample extends App {

  sealed class Nach(val value: String)
  case object Schk extends Nach("Шоколадная")
  case object Kar extends Nach("Карамельная ")

  sealed class Prisip(val value: String)
  case object Zv extends Prisip("звёздочки")
  case object Pzd extends Prisip("пёздочки ")


  case class PriceKonfeta(price:Int)
  case class PriceSchokoladka(price:Int)
  case class PricePirojenka(price:Int)
  case class PriceZefirka(price:Int)


  class Sweetness(name: String, price: Int) {
    def getName: String = {
      name
    }

    def getPrice: Int = {
      price
    }
  }

  class Konfeta(name: String, price: Int, nachinka: Option[Nach]) extends Sweetness(name, price) {
    def getNachinka: Option[Nach] = {
      nachinka
    }
  }
  class Schokoladka(name: String, price: Int, nachinka2: Option[Nach]) extends Sweetness(name, price) {
    def getNachinka2: Option[Nach] = {
      nachinka2}
  }
  class Pirojenka(name: String, price: Int, nachinka3: Option[Nach]) extends Sweetness(name, price) {
    def getNachinka3: Option[Nach] = {
      nachinka3}
  }
  class Zefirka(name: String, price: Int, prisip: Option[Prisip]) extends Sweetness(name, price) {
    def getNachinka4: Option[Prisip] = {
      prisip
    }
  }

  implicit val price1: PriceKonfeta = PriceKonfeta(13)
  implicit val price2: PriceSchokoladka = PriceSchokoladka(154)
  implicit val price3: PricePirojenka = PricePirojenka(475)
  implicit val price4: PriceZefirka = PriceZefirka(3475)


  def getSweetness(sweetneesStr: String, nach: Option[Nach],prisip: Option[Prisip]): Sweetness = {
    sweetneesStr.toUpperCase() match {
      case "КОНФЕТА" => spawnall.createKonfeta(nach)
      case "ШОКОЛАДКА" => spawnall.createSchokoladka(nach)
      case "ПИРОЖЕНКА" => spawnall.createPirojenka(nach)
      case "ЗЕФИРКА" => spawnall.createZefirka(prisip)

    }
  }

  object spawnall {
    def createKonfeta(nach: Option[Nach])(implicit price: PriceKonfeta): Konfeta = new Konfeta("Nya", price.price,nach)
    def createSchokoladka(nachinka2: Option[Nach])(implicit price: PriceSchokoladka): Schokoladka = new Schokoladka("Чёрная жопа",price.price,nachinka2)
    def createPirojenka(nachinka3: Option[Nach])(implicit price: PricePirojenka): Pirojenka = new Pirojenka("булочки женщины",price.price,nachinka3)
    def createZefirka(prisip: Option[Prisip])(implicit price: PriceZefirka): Zefirka = new Zefirka("маленькая пёздочка",price.price,prisip)
  }




  println(Console.BLUE_B + Console.BLACK +"                                                          В ы    н а    п р о г р а м м е ")
  println(Console.YELLOW_B +Console.BLACK + "                                                        С ъ е ш ь    и л и    у м р и ")
  println(Console.BLACK + "Что будем готовить?(конфета, шоколадка, пироженка, зефирка)")
  val questionWhat: String = scala.io.StdIn.readLine()
  questionWhat match {
    case strKonf: String if strKonf.toUpperCase() == "КОНФЕТА" => println(Console.BLUE_B + Console.BLACK + "начинку добавляем?(да,нет)")
      val questionNachWithKonf: String = scala.io.StdIn.readLine()
      questionNachWithKonf match {
        case strKonf2: String if strKonf2.toUpperCase() == "ДА" => println(Console.YELLOW_B + Console.BLACK + "Какую?(Шоколадная,Карамельная)")
          val questionNachWithKonf2: String = scala.io.StdIn.readLine()
          questionNachWithKonf2 match {
            case strShok1: String if strShok1.toUpperCase() == "ШОКОЛАДНАЯ" => println(Console.BLUE_B  + Console.BLACK + "ваш заказ оформляется, подождите(тварь)")

            case strKaram1: String if strKaram1.toUpperCase() == "КАРАМЕЛЬНАЯ" => println(Console.BLUE_B  + Console.BLACK+ "ваш заказ оформляется, подождите(тварь)")
          }

        case strKonf3: String if strKonf3.toUpperCase() == "НЕТ" => println(Console.YELLOW_B + Console.BLACK + "Без начинки")

        case _ => println(Console.BLACK_B+Console.RED + "ничего не понял, пошёл вон")
      }
    case strShok: String if strShok.toUpperCase() == "ШОКОЛАДКА" => println(Console.MAGENTA_B + "начинку добавляем?")
    case strPir: String if strPir.toUpperCase() == "ПИРОЖЕНКА" => println(Console.MAGENTA_B + "начинку добавляем?")
    case strZefir: String if strZefir.toUpperCase() == "ЗЕФИРКА" => println(Console.MAGENTA_B + "присыпку добавляем?")
    case _ => println(Console.BLACK_B+Console.RED+ "ничего не понял, пошёл вон")


  }



}


