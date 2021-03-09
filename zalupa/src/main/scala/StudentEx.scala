object StudentEx extends App{

  sealed class Um
  case object Yes extends Um
  case object No extends Um


  class Human(val name : String,val firstname: String, val age: Int) {
    // общий метод, есть у всех кто наследует Human
    def fullName: Unit = {
      println(name + " " + firstname)
    }
  }

  class Student(nickname : String, firstname: String,  age: Int, val money: Float) extends Human(nickname, firstname, age) // extends - наследование
  class Teacher(name : String, firstname: String, age: Int, val smart: Um) extends Human(name, firstname, age) {
    // после описания класса в скобках { ... } - это тело (body) класса
    // по скольку эти методы в теле класса Teacher, то они есть только у учителей
    def getSalary(): Unit = { // метод
      println("Ура, мне пришла зарплата")
    }

    def sum(a: Int, b : Int): Unit  = {
      val summaChisel: Int = a + b
      println("Сумма чисел " + summaChisel)
    }

  }

  val Rodin = new Student("Rodin","Ofatenko",24,846284626)
  val Aminya = new Student("Aminya", "Ofatenko",18,0)


  val Arkadii = new Teacher("Arkadii", "Viva", 64,Yes)


  Arkadii.getSalary() // вызов метода Teacher
  Arkadii.sum(100, 200) // вызов метода Teacher

  Rodin.fullName // вызов метода Human
  Arkadii.fullName // вызов метода Human

}
