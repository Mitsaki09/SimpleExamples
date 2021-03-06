import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.ask

import scala.concurrent.duration._
import akka.util.Timeout

import scala.concurrent.{Await, Future}
class Food1 extends Actor {

  import FoodMain.FoodSeq

  def receive = {
    case foodSeq: FoodSeq =>
      val sum = foodSeq.seqOfFood.map(_.calories).sum
sender ! sum

  }
}

  object FoodMain extends App {
    implicit val duration: Timeout = 2.seconds

    case class Food(name: String,calories: Int)
    case class FoodSeq(seqOfFood: Seq[Food])

    val rise = Food("Рис",120)
    val okorok = Food("Окорок",250)
    val foodSeq = FoodSeq(Seq(rise,okorok))

        val system = ActorSystem("fooooood")
        val foodActor = system.actorOf(Props[Food1], name = "actorFood")

        val foodFuture: Future[Any] = foodActor ? foodSeq
        println(Await.result(foodFuture, Duration.Inf))


//просто пример
    println("foodSeq: " + foodSeq)
    println("foodSeq.seqOfFood: " + foodSeq.seqOfFood)
    println("foodSeq.seqOfFood.map(_.calories): " + foodSeq.seqOfFood.map(_.calories))

}