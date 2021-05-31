
import OgameActor.{Ogame, Player}
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class PlayerActor extends Actor {
  def receive = {
    case player: Player =>
      println(player)

  }
}

class OgameActor extends Actor {
  def receive = {
    case ogame:Ogame =>
      ogame.player ! Player(ogame.res)

  }
}

object OgameActor {
  case class Player(str: String)
  case class Ogame(player: ActorRef,res:String)
}
object MainOgameWorker extends App {
  val system = ActorSystem("Actor")
  val playerActor = system.actorOf(Props[PlayerActor], name = "Player")
  val ogame = Ogame(playerActor, "ня")
  val ogameActor = system.actorOf(Props[OgameActor], name = "ogameActor")
  ogameActor ! playerActor
}


