

import HumanName.Human
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class HumantActor() extends Actor {
  def receive = {
    case str:String =>
      println(str)
case human:Human =>
  self ! human.name+human.lastName
  }
}

object HumanName {
  case class Human(name:String,lastName: String)

}
object MainHuman extends App {
  val system = ActorSystem("Actor")
  val human = Human("Родиончик", "Муж")
  val humanActor = system.actorOf(Props[HumantActor], name = "humantActor")
  humanActor ! human
}
