

import CreateKinderCaseClass.{CreateKinder, Kinder}
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

import scala.util.Random

class FactoryKinderActor() extends Actor {
  def receive = {
    case createKinder:CreateKinder =>
      if (createKinder.toyShit == true){
        sender ! Kinder(Random.between(6, 10))
      }else{
        sender ! Kinder(Random.between(1, 5))
      }

  }
}

object CreateKinderCaseClass {
  case class CreateKinder(toyShit: Boolean)
  case class Kinder(id:Int)

}
object MainCreateKinder extends App {
  val system = ActorSystem("Actor")
  val createKinder = CreateKinder(true)
  val factoryKinderActor = system.actorOf(Props[FactoryKinderActor], name = "FactoryKinderActor")
  factoryKinderActor ! createKinder
}
