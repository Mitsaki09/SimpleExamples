
import OneActorCaseClass.{A, B}
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class OneActor extends Actor {
  def receive = {
    case a:A =>
      println(a)
    case b:B =>
      b.link ! A(b.str)

  }
}
object  OneActorCaseClass {
  case class A(description: String)
  case class B(link: ActorRef, str: String)
}
object MainOneActor extends App {
  val system = ActorSystem("Actor")
  val OneActor1 = system.actorOf(Props[OneActor], name = "a")
  val b = B(OneActor1, "str")
  val OneActor2 = system.actorOf(Props[OneActor], name = "b")
  OneActor1 ! b
}


