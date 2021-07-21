object AuxiliaryConstructors extends App {
  case class Human(name:String,age:Int) {

    def this(firstName:String, lastName:String, age:Int) = this(firstName + " ня " + lastName, age)

  }


  val human = Human("Аминяша",19)

  val human2 = new Human("Аминяша", "Котик",19)

  println(human2)
  println(human)
}
