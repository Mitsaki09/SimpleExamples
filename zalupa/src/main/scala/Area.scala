object Area extends App {
  println("что хотите решить?:")
  val name: String = scala.io.StdIn.readLine()
  if (name == "+") {
    println("решаем на +,")
    println("введите a:")
    val a: Int = scala.io.StdIn.readInt()
    println("введите b:")
    val b: Int = scala.io.StdIn.readInt()
    println(a + b)


  } else {
    println("решаем на -")
    println("введите a:")
    val a: Int = scala.io.StdIn.readInt()
    println("введите b:")
    val b: Int = scala.io.StdIn.readInt()
    println(a - b)

  }

}

object Area2 extends App {
  println("введите a:")
  val a: Int = scala.io.StdIn.readInt()

  println("введите b:")
  val b: Int = scala.io.StdIn.readInt()

  println("что хотите решить?:")
  val name: String = scala.io.StdIn.readLine()

  if (name == "+") {
    println("решаем на +,")
    println(a + b)
  } else {
    println("решаем на -")
    println(a - b)
  }

}




