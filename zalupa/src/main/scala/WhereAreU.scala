object WhoAreU extends App {
  println("введи своё имя,бич:")
  val name: String = scala.io.StdIn.readLine()
  if (name == "Амина") {
    println("привет,Любимая")
  } else {
    if (name == "Равиолька") {
      println("привет,Любимый , няяяяяя:")
    } else {
      println("ты кто,бич?")
    }
  }
}


object WhoAreU2 extends App {
  println("введи своё имя,бич:")
  val name: String = scala.io.StdIn.readLine()

  name match { // матч патерн
    case "Амина" => println("привет,Любимая")
    case "Равиолька" => println("привет,Любимый")
    case _ => println("Ты кто?")

  }

}


object YourAge extends App {
  println("сколько тебе лет, бич?:")
  val age: Int = scala.io.StdIn.readInt()


  age match {
    case 16 => println("ну почти")
    case 17 => println("ну почти")
    case _ if (age >= 21) => println("старик")
    case _ if (age >= 18) => println("поздравляем, из-за тебя никого не посадят")
    case _ => println("уходи")

  }

}


