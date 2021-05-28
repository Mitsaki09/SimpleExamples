
import CreateSausageCaseClass.{Sausage, WhoToFeed}
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

import scala.util.Random



class HumanActor() extends Actor {
  def receive = {
    case sausage: Sausage=>
      sausage
  }
}
class CookActor() extends Actor {
  def receive = {
    case whoToFeed:WhoToFeed=>
     val int= Random.between(1, 2)
      val sausage = Sausage()
      if (int == 1){
  whoToFeed.human1 ! sausage
      }else {
        whoToFeed.human2 ! sausage
      }

  }
}

object CreateSausageCaseClass {
  case class Sausage(taste: String="нраица",
                     cheese:Boolean=true)
case class WhoToFeed(human1: ActorRef,
                     human2: ActorRef)



}
object MainSausageWhoToFeed extends App {
  val system = ActorSystem("Actor")
  val aminaActor = system.actorOf(Props[HumanActor], name = "aminaActor")
  val leshaActor = system.actorOf(Props[HumanActor], name = "leshaActor")
  val cookActor = system.actorOf(Props[CookActor], name = "CookActor")

  val whoToFeed = WhoToFeed(aminaActor,leshaActor)
  cookActor!whoToFeed
}