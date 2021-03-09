object Nalog extends App {


  //println("введите зп")
  //  val QuestionZp: Int  = scala.io.StdIn.readInt


  // println("минус сколько?")
  // val QuestionMinus: Int = scala.io.StdIn.readInt


  //  def sum: Int={

  //  QuestionZp - QuestionMinus


  object zpNalog {

    def strWithPrefix(zp: Int, nalog: Int): Int = zp - nalog
  }
val objavlenije: Int = zpNalog.strWithPrefix(1000,15)
  println(objavlenije)

}