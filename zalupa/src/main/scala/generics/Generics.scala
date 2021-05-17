package generics

object Generics1 extends App {
  case class Pirat[A](id: A, name: String)

/*   A - это дырка для типа. Позволяет не указывать тип поля в момент создания
   В этом примере мы указали айдишник неопредленного типа А,
   а затем создали два экземпляра с разными типами айдишников*/
  val piratWithIntId = Pirat[Int](15, "Валерка")
  val piratWithStringId = Pirat[String]("myId1", "Валерка")
 /* Вы уже использовали это много раз. Посмотрите на Option(_), Try(_), Either(_,_) Future(_)
   Все они имеют дженерик - дырку в описание что и позволяем писать нам Option(1), Option("str") и тд
   Дырок может быть несколько, например в Either(_,_) их две*/
}
