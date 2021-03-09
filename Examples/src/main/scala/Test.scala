object Test extends App {

  object CLAL {
    def printName(first: String, last: String): Unit = {
      println(first + " " + last)
    }

  }

  CLAL.printName("John", "Smith")  // Prints "John Smith"
  CLAL.printName(first = "John", last = "Smith")  // Prints "John Smith"
  CLAL.printName(last = "Smith", first = "John")  // Prints "John Smith"




}
object Vasya extends App {

class Human(firstName:String = "Василий ",lastName:String="Пупкин ",age:Int = 36) {
  println(firstName + lastName + age )

  }
val da = new Human()
  val net = new Human(firstName = "Андрюша ",age = 5 )
}
object GavnoNaZavtra extends App{

  class NeHuman (kakashkapervaja:String = "зелёная",kakashkavtoraja:String = "нежноголубосалатово вонючая ") {
    println(kakashkapervaja+kakashkavtoraja)
  }
  val Aminochka = new NeHuman(kakashkapervaja = "пахнет ромашками,обычная ",kakashkavtoraja = "вся в блёстках")
  val RodionSuka = new NeHuman()
  val Da = new NeHuman(kakashkavtoraja = " Артём")


}