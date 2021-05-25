import Create5CaseClass.{One, Three, Two}
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class ActorA extends Actor{
  def receive= {
    case one: One =>
      one.two ! Two(one.msg,self)
  }
}
class ActorB extends Actor{
def receive={
  case two:Two =>
    two.three ! Three(two.msg,self)
}
}

object Create5CaseClass{
  case class One(msg: String,two:ActorRef)
  case class Two(msg: String,three:ActorRef)
  case class Three(msg: String,four:ActorRef)
  case class Four(msg: String,five:ActorRef)
  case class Five(msg: String)

}
object MainActorAActorB extends App{
  val system = ActorSystem("Actor")
  val aActor = system.actorOf(Props[ActorA],name = "ActorA")
  val actorB = system.actorOf(Props[ActorB],name = "ActorB")
  val one = One("vs",actorB)
  aActor ! one

}
