object Condition extends App {

  val trigger: Boolean = true // false , лог.перемен. которая может быть истин. или ложью

  if (trigger) {
    println("+")

  } else {
    println("-")
  }
  val password: String = "tyit"
  if (password == "qwerty") {
    println("password is correct")
  } else {
    println("password is not correct")

  }
  val isStringEquals: Boolean = password == "qwerty"



}
