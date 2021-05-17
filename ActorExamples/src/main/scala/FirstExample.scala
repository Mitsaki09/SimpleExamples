import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

class HelloActor extends Actor {

  import HelloActor._

  /* У любого актора есть метод receive - который принимает частично примененную функцию
   Частично примененная функция - это просто match {case ...}
  Если case с условием есть то функция будет делать то что закодите, если нет не единого case подходящего под условие то ошибка

   Выходит, что тут мы можем делать все что и в match, потому что это он и есть,
   Например тут актор реагирует на одно сообщение и есть обработка для всех остальных сообщенией по умолчанию*/
  def receive = {
    case "Ты Жопа" => println("Ты заставил меня написать Ты Жопа")
    case str: String  if str.length>10 => println("строка больше 10")
    case 666 => println("Ты чёрт?")
    case int: Int if int > 1 => println("вы ввели "+ int)

    case Sperma(nalich, sizeSp) if nalich == true =>println(sizeSp)
    case Sperma(true, sizeSp) =>println(sizeSp)
    case sperma: Sperma => println(sperma)

    case _ => println("Шо?")

  }
}

object HelloActor {
  case class Sperma(nalichie:Boolean, size: Int)
}



object Main extends App {

  val system = ActorSystem("HelloSystem") // хранилище для всех акторов
/*
  ВСЕ акторы должны быть созданы только через хранилище, по этому вы не сможете создать их через new
   Для создания актора нужно заставить хранилище его создать и ввернуть ссылку (почтовый адрес для сообщений)*/
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")  // создание актора


  /* передаем актору сообщение (хотя на самом деле передаем сообщение на его ссылку - почтовый адресс)
   в будущем возможны ситуации, что ссылка у нас еще есть, а актор уже сдох - тогда будет ошибка и такое сообщение попадет в особому актору-мусорке*/

  helloActor ! "Ты Жопа"  // "Ты заставил меня написать Ты Жопа"
  helloActor ! "11111111111" // "Ты чёрт?"
  helloActor ! "в" // huh?
  helloActor ! 666 // "Ты чёрт?"
  helloActor !  7 // huh?
  helloActor !  HelloActor.Sperma(true, 15)

}