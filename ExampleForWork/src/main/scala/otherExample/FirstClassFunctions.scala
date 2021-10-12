package otherExample

object FirstClassFunctions extends App {
  //First-Class Functions
  def sum2numbers(a: Int, b: Int): Unit = {
    println(a + b)
  }

  // Это обычная функция
  val sum2numbersFunction: (Int, Int) => Unit = (a, b) => println(a + b)


  def funncct(a: Int, b: Int, c: String): Int = {
    println(c)
    a + b
  }

  val cccc: (Int, Int, String) => Int = (a, b, c) => {
    println(c)
    a + b
  }
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

  println(str(true))

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

  //def bar(opr: Int => String): String = ???

  //val gg: (Int => String) => String = ???


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


  object DD {
    def one: Int = 1

    def two(): Int = 2
  }

  object DD2 {

    val dd = DD.one _
    val ddd = DD.two _


  }

  def minus(a: Int, b: Int): Int = a - b

  val minusFive: Int => Int = minus(_, 5) //  частично примененная функция (partially applied function)
  println(minusFive(7))


  def in(): Int = 6

  def in2(): Int = 6

  val gggg = in _ // если мы хотим превратить метод без парамметров в функцию, то пишем _
  val ggggg = in2 _


  abstract class Human6(val weight: Int, val height: Int, val age: Int)

  class Soldat(weight: Int, height: Int, age: Int) extends Human6(weight, height, age)

  class Tractorist(weight: Int, height: Int, age: Int) extends Human6(weight, height, age)

  val soldatFunct: (Int, Int, Int) => Soldat = (weight, height, age) => new Soldat(124, 421, 12)
  val TractoristFunct: (Int, Int, Int) => Tractorist = (weight, height, age) => new Tractorist(124, 421, 12)


  val functHuman: (Int, Int, Int) => Soldat = soldatFunct(_, _, _)

  val human: Human6 = functHuman(2, 4, 5)


  class Pilot(val name: String, val rang: String)

  class Plain(val pilot: Pilot, val modelPlain: String, val agePlain: Int)

  val plainFunct: (Pilot, String, Int) => Plain = (pilot, modelPlain, agePlain) => new Plain(pilot, modelPlain, agePlain)
  val functPlain2: Pilot => Plain = plainFunct(_, "Куроносец", 1984) // пишем тип функции только тот, который у _
  val functPlain3 = plainFunct(_, "Куроносец", 1984) // пишем тип функции только тот, который у _


  case class Cat(bubenchiki: Boolean, nameCat: String)

  val catFunct: (Boolean, String) => Cat = (bubenchiki, nameCat) => Cat(bubenchiki, nameCat)

  val catFunct2: (Boolean, Cat) => Cat = (needKastrirovat, cat) => {
    if (needKastrirovat == true) {

      cat.copy(bubenchiki = false)

    } else
      cat
  }


  class Glist(val dlina: Int, val diametr: Int, val ves: Int)

  val glist1 = new Glist(55, 1, 30)
  val glist2 = new Glist(60, 2, 20)
  val glist3 = new Glist(53, 1, 28)
  val glist4 = new Glist(51, 3, 41)
  val glist5 = new Glist(50, 2, 13)
  val glist6 = new Glist(415, 523, 1651)
  val SpisokGlistov = Seq(glist1, glist2, glist3, glist4, glist5)




  // .length - метод length (), который возвращает количество символов(в нашем случае глистов), содержащихся в строковом объекте.

  val glistFunct1: Seq[Glist] => Int = seqGli => seqGli.length

  val glistFunct2: Seq[Glist] => Int = seqGll => seqGll.map(x => x.ves).sum


  val glistFunct3: (Seq[Glist], Glist) => Seq[Glist] = (seqGll: Seq[Glist], gl: Glist) => seqGll :+ gl

  println(glistFunct3(SpisokGlistov, glist6))



  // :+ если мы хотим к списку доавить ещё один элемент, то мы не можем написать SeqGlist + glist 6 , мы должны написать :+   SeqGlist :+ glist 6
  // если мы хотим добавить к списку ещё один список, то мы пишем :++

  def sum(a: Int, b: Int): Int = {

    a + b
  }


  println(sum(1, 1))


  def foo(a: Int) = {
    println(a)
    println(a)
  }

  def foo2(a: => Int) = {
    println(a)
    println(a)
  }

  def give5(a: Int): Int = {
    println("Кому-то нужна " + a)
    a
  }

  foo(give5(5))
  foo(give5(6))

}
