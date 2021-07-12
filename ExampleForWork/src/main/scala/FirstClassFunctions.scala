object FirstClassFunctions extends App {


  //First-Class Functions
  def sum2numbers(a: Int, b: Int): Int = a + b

  // Это обычная функция
  val sum2numbersFunction: (Int, Int) => Int = (a, b) => a + b
  println(sum2numbersFunction(5, 5))
  // (Int, Int)           2 параметра типа Int
  // => Int               тип, который возвращаем
  // (a, b)               имена параметров
  // => a + b             тело функции


  val mult2numbers: (Int, Int) => Int = (a, b) => a * b
  println(mult2numbers(2, 2))

  /*===========================================================================================================================================================================================================================*/
  //Higher-Order Functions - это функция, которая принимает или возвращает другую функцию


  def makeOperation(operation: (Int, Int) => Int, a: Int, b: Int): Int = {
    operation(a, b)
  }

  def str(str: Boolean): Either[String, Int] = {
    if (str == true) {
      Left("жумайсынба")
    } else {
      Right(12)
    }
  }

  def takeStrDes(opr: Boolean => Either[String, Int], a: Boolean): String = {
    opr(a).toString
  }

  println(takeStrDes(str, true))
  println(takeStrDes(str, false))


  case class Human(name: String, gender: Boolean)

  def boy(name: String): Human = {
    Human(name, true)
  }

  def girl(name: String): Human = {
    Human(name, false)
  }

  def roditAmugus(o: String => Human, name: String): Human = {
    o(name)
  }

  roditAmugus(boy, "fgbfdctr")
  roditAmugus(girl, "fhnft")


  case class Ship(weight: Double, age: Int)

  case class Flot(ship: Ship, country: String)

  def createShip(weight: Double, age: Int) = Ship(weight, age)

  def createFlot(createShip: (Double, Int) => Ship, age: Int): Flot = ???


  case class Dick(name: String)

  case class Eggs(name: String)

  def dick(name: String): Dick = {
    Dick(name)
  }

  def eggs(name: String): Eggs = {
    Eggs(name)
  }

  def crt(dick: String => Dick, eggs: String => Eggs) = {
    val penis: Dick = dick("penis1")
    dick("penis2")
    dick("penis3")
  }

  crt(dick, eggs)

  /*===========================================================================================================================================================================================================================*/

  case class Motherboard(name: String)

  case class GraphicsCard(name: String)

  case class PK(motherboard: Motherboard, graphicsCard: GraphicsCard)

  def createMotherboard(name: String): Motherboard = {
    Motherboard(name)
  }

  def createGraphicsCard(name: String): GraphicsCard = {
    GraphicsCard(name)
  }

  def crt2(motherboard: String => Motherboard, graphicsCard: String => GraphicsCard) = {
    motherboard("1")
    graphicsCard("2")

  }

  def bar(opr: Int => String): String = ???

  val gg: (Int => String) => String = ???


  def temp(): Int => String = {
    val numberToString: Int => String = number => {
      number.toString
    }
    numberToString
  }


  def fo(): Int => Int = {
    val sumFunct: Int => Int = a => a + 100
    sumFunct
  }





}


