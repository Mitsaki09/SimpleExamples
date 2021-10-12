package otherExample

object ObjectEquality extends App {

  val str: String = "Str"

  // 1) сравниваем содержимое
  val res1: Boolean = str == "Str"
  println(res1) // true
  val res2: Boolean = str == "strAAAAAAAAAAAAAAAAA"
  println(res2) // false


  // 2) сравниваем переменную
  // Все строки в программе лежат в пулле строк - список всех строчек. По умолчанию там нет повторений строчек,
  // по этому если мы хотим выделить именно новую строчку то надо писать new String
  val res3 = str eq new String("Str")
  println(res3) // false

  val res4 = str eq str
  println(res4) // true


  case class Human(age: Int)

  val human1 = Human(18)
  val human2 = Human(100)
  val human3 = Human(18)

  val res5 = human1 eq human2
  println(res5) // false

  val res6 = human1 eq human1
  println(res6) // true

  val res7 = human1 eq human3
  println(res7) // false, потому что это разные переменные

}
