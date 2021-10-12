package otherExample

object StringInterpolation extends App {
  // sСтрока Interpolator
  val name = "James"
  println(s"Hello, $name")
  println("---------------------------------------------------------------------------------------------------------------------------------------------")


  case class Human(name: String)

  val human = Human("Amina")
  println(s"Hello, $human")
  println("---------------------------------------------------------------------------------------------------------------------------------------------")


  case class Human1(name: String)

  val human1 = Human1("Amina")
  println(s"Hello, ${human1.name}")
  println("---------------------------------------------------------------------------------------------------------------------------------------------")

  println(s"1 + 1 = ${1 + 1}")

  println("----------------------------fInterpolator-----------------------------------------------------------------------------------------------------------------")

  //fInterpolator

  val height = 1.9d
  val name3 = "James"
  println(f"$name3%s is $height%2.2f meters tall")
  /*
  %s - это тип(String), %2.2f означает - Double
  https://docs.scala-lang.org/overviews/core/string-interpolation.html
  смотри тут ключевые слова

*/
  println("-------------------------------------rawInterpolator--------------------------------------------------------------------------------------------------------")
  //rawInterpolator

  println(s"a\nb") //    \n специальный символ , переносит на новую строку. с s работает
  println(raw"a\nb") // спец.символы не работают


}
