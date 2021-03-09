object AgeExeption extends App {
  try {
    println("напишите возраст")
    val questionAge: Int = scala.io.StdIn.readInt()

    if (questionAge >= 0) {
      println(questionAge)
    } else {
      throw new Exception("жопа")
    }


  }
//  catch {
//
//   case e: Exception =>
//     println("не тот возраст , ты дебил?" + e.getMessage )

//}
}