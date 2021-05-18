import SumMain.{PokupkaSvinki}
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.ask

import scala.concurrent.duration._
import akka.util.Timeout

import scala.concurrent.{Await, Future}

class SumMinusActor extends Actor {

  def receive = {
    case pokupkaSvinki:PokupkaSvinki =>
      sender ! pokupkaSvinki.kg*pokupkaSvinki.price
    case _ => println("Шо?")

  }
}


object SumMain extends App {
  implicit val duration: Timeout = 2.seconds
  case class PokupkaSvinki(kg:Int,price:Int )

  val pokupkaSvinki = PokupkaSvinki(12,4)

  val system = ActorSystem("HelloSystem")
  val pokupkaSvinkiActor = system.actorOf(Props[SumMinusActor], name = "pokupkasvinki")

  val pokupkaSvinkiFuture: Future[Any] = pokupkaSvinkiActor ? pokupkaSvinki
   println(Await.result(pokupkaSvinkiFuture, Duration.Inf))
}