object Pridmet extends App {
  val vasia = new Man("Vasia", "Grob", "Borisovich")
  val petia = new Man("Petia", "Stolb", "Igorovich")

  val prefix = "mr"

  val vasiaFullName: String = vasia.fullName(prefix)


  val petiaFullName: String = petia.fullName(prefix)

  val friends: String = vasiaFullName + " " + petiaFullName

  println(friends)

}

class Man(val firstName: String, val lastName: String, val middleName: String) {
  def fullName(prefix: String): String = {
    prefix + " " + firstName + " " + lastName + " " + middleName
  }
  
  def fullNameWithPrint(prefix: String): Unit = {
    println(prefix + " " + firstName + " " + lastName + " " + middleName)
  }

}
