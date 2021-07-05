object TooString extends App {

  case class Human(name: String, age: Int) {
    override def toString: String = {
      s"Чувака зовут $name, и ему $age лет"
    }

     def myString: String = {
      s"Чувака зовут $name, и ему $age лет"
    }
  }

  val human = Human("Радюша", 25)

  println(human.toString)
  println(human)
  println(human.myString)




}
