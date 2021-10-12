package otherExample

object Generic extends App {

  def myPrint[T](a: T): Unit = {
    println("myPrint" + a)
  }

  myPrint(5)
  myPrint("5")
  myPrint(???)


  class Box[T](value: T) {
    def getValue: T = value
  }

  val boxString = new Box[String]("Hello")
  val res1: String = boxString.getValue

  val intString = new Box[Int](55)
  val res2: Int = intString.getValue


  type Name = Either[String, String]

  class Human(name: Name)

  new Human(Left("dd"))

  type FirstLastName = (String, String) // Кортеж
  val firstLast: FirstLastName = ("John", "Week")

  type FirstLastName2 = Tuple2[String, String]
  val firstLast2: FirstLastName2 = "John" -> "Week" // синтаксически  сахар, работает только для Tuple2
  val firstLast3: FirstLastName2 = Tuple2.apply("John", "Week")


  type Jopa = (Human, Box[Box[Human]], Option[Int], String)


  abstract class Human5 {
    def sum(a: Int, b: Int)
  }

  val human5: Human5 = new Human5 {
    override def sum(a: Int, b: Int): Unit = a + b
  }


  case class Student[T](id: T, name: String)

  type StudentInt = Student[Int]
  type StudentDouble = Student[Double]

}
