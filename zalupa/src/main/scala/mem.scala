object mem extends  App {


  class Mother(val childrenCount: Int, val boobs: Int)

  class Child(val name: String, val age: Int, val long: Int, val kg: Int)

  val mother = new Mother(2, 6)

  mother.childrenCount match {

    case 0 =>  println("все впереди")

    case -1 =>  println("rip")

    case 1 =>  val David = new Child("David",294,186,54)

    case 2 =>
      val Pelmen = new Child( "Pelmen", 67 , 82 , 87)
      val Iisus = new Child ("Iisus ",74, 34,84 )
      println(Pelmen)

    case a: Int if a >= 3  => println("сама пиши")

    case _ =>






  }
  val ingredient = ("Sugar" , 25):Tuple2[String, Int]

  println(ingredient._1)
}


