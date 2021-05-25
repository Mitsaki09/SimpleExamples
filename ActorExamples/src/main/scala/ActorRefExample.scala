import ZodaniyaActor.{ZadanieForWorker, Zodanie}
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class WorkerActor extends Actor {
  def receive = {
    case zodanie: Zodanie =>//4
   println(zodanie)//5

  }
}

class BossActor extends Actor {//
  def receive = {
    case zodanieForWorker:ZadanieForWorker =>//2
      self
      zodanieForWorker.worker ! Zodanie(zodanieForWorker.taskDescription)//3

  }
}

object ZodaniyaActor {
  case class Zodanie(description: String)
  case class ZadanieForWorker(worker: ActorRef, taskDescription: String)
}
object MainBossWorker extends App {
  val system = ActorSystem("Actor")
  val workerActor = system.actorOf(Props[WorkerActor], name = "workerActor")
  val zadanieForWorker = ZadanieForWorker(workerActor, "KOL")
  val bossActor = system.actorOf(Props[BossActor], name = "bossActor")
  bossActor ! zadanieForWorker//1
}


