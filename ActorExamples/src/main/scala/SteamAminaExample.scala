import CreateCaseCLass.{Amina, Steam}
import akka.actor.{Actor, ActorRef, ActorSystem, Props}


class SteamActor extends Actor{
  def receive = {
    case steam: Steam =>
      println(steam)

  }
}
class AminaActor(steam: ActorRef) extends Actor{
  def receive ={
    case amina:Amina =>
      steam ! Steam(amina.nervi)
  }
}
object CreateCaseCLass{
  case class Steam(nameGame:String)
  case class Amina(nervi:String)
}
object MainSteamAmina extends App{
  val system = ActorSystem("Actor")
  val steamActor = system.actorOf(Props[SteamActor], name = "steamActor")
  val amina = Amina("много")
  val aminaActor = system.actorOf(Props[AminaActor], name = "aminaActor")
  aminaActor ! steamActor
}
