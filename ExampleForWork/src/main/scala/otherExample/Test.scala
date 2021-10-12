package otherExample

object Test extends App {

  val x = 3 //переменная которую нельзя изменить

  var x2 = 3 //переменная которую можно изменить
  x2 = 6
  println(x2)


  def fdf(first: Int, too: Option[Int]): Unit = {

    too.isEmpty == too.getOrElse(1)


  }
}
