import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.ask

import scala.concurrent.duration._
import akka.util.Timeout

import scala.concurrent.{Await, Future}
class Food2 extends Actor {

  import FoodMain2.FoodSeq

  def receive = {
    case foodSeq: FoodSeq =>
    val filterForCalories = foodSeq.seqOfFood.map(_.calories).filter(_> 100)
      sender ! filterForCalories
    case _ => println("Шо?")
  }
}

object FoodMain2 extends App {
  implicit val duration: Timeout = 2.seconds

  case class Food(name: String,calories: Int)
  case class FoodSeq(seqOfFood: Seq[Food])

  val grecha = Food("Гречка",20)
  val meat = Food("Мяско",250)
  val foodSeq = FoodSeq(Seq(grecha,meat))

  val system = ActorSystem("fooooood")
  val foodActor = system.actorOf(Props[Food2], name = "actorFood")

  val foodFuture: Future[Any] = foodActor ? foodSeq
  println(Await.result(foodFuture, Duration.Inf))





}