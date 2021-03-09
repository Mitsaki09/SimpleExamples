object user extends App {
  class User ( val age: Int  , val name: String )
  val user = new User (1,"Ddd")
  val user2 = new User (1,"Ddd")

  println(user.age)
  println(user.name)

}
