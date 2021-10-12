package otherExample

object StripMargin extends App{

  val speech1 = """Four score and
                 #seven years ago""".stripMargin('#')

  println(speech1)

  val speech2 = """Four score and
                 |seven years ago""".stripMargin

  println(speech2)
}
