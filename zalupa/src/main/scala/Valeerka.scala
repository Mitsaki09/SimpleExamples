object Valeerka extends App {

  class Human(var name: String, var age: Int) { // да, тут var - так делать нельзя но для примера можно. Теперь мы можем менять значения

    def setAge(newAge: Int): Unit =  {
      age = newAge
    }
    def setName(newName: String): Unit =  {
      name = newName
    }

    def print(): Unit = {
      println(s"Имя - $name, возраст - $age")
    }
  }

  val valerka = new Human("Valerka", 25)

  while(true) {

    print("Введите команду:")
    val str: String = scala.io.StdIn.readLine()

    str match {
      case "setAge" =>
        print("Введите новый возраст:")
        val newAgeFromConcole: Int = scala.io.StdIn.readInt()
        valerka.setAge(newAgeFromConcole)
      case "setName" =>
        print("Введите новае имя")
        val newNameFromConcole: String = scala.io.StdIn.readLine()
        valerka.setName(newNameFromConcole)
      case "print" =>
        valerka.print()
      case "exit" =>
        System.exit(1)
      case _ =>
    }
  }

}
