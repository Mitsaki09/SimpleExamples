object jhgf {


  val ApplePrice: Double = 15
  val PearSPrice: Double = 41
  val BananasPrice: Double = 26

  println("сколько Apple?")
  val QuestionApple: Int = scala.io.StdIn.readInt
  println("сколько Pears?")
  val QuestionPearS: Int = scala.io.StdIn.readInt
  println("сколько Bananas?")
  val QuestionBananas: Int = scala.io.StdIn.readInt



  val Price = QuestionApple  *  ApplePrice +  QuestionPearS * PearSPrice + QuestionBananas * BananasPrice


  println(Price)

}
