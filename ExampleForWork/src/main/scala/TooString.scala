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

  case class Animal(have: Boolean) {
    override def toString: String = {
      s"You have dog it's $have  "
    }
  }

  val animal = Animal(true)
  println(animal)

















  case class Human1(name: String,age: Int) {
    def str: Unit = {
      println("Чувака зовут" + name + " и ему" + age + "лет")
    }
  }
  val human4 = Human1("sdg",1)
  println(human4.str)







  case class Human5(name: String, age: Int) {
    def myString: String = {
      s"Чувака зовут $name, и ему $age лет"
    }

  }
}
