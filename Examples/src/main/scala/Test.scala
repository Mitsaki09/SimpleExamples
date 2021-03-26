

object Test extends App {

  case class User(FirstName: String, MiddleName: String, LastName: String)
  val firstName: Option[String] = Some("Григорий")
  val middleName: Option[String] = Some("Димонович")
  val lastName: Option[String] = Some("Ромашка")

  val FMLName: Option[User] = for {
    fn<-firstName
    mn<-middleName
    ln<-lastName

  }yield
    User(fn,mn,ln)

  println(FMLName)

}



