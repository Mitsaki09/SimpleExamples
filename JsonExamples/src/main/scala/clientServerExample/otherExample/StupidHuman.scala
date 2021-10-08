package clientServerExample.otherExample

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

object MainStipidHumanServer extends App {
  case class Intelligence(convolutions: Int, brainWeight: Int)

  object Intelligence {
    implicit val encoder: Encoder[Intelligence] = deriveEncoder[Intelligence]
    implicit val decoder: Decoder[Intelligence] = deriveDecoder[Intelligence]
  }

  case class HumanPig(name: String = "Дима", intelligence: Option[Intelligence])

  object HumanPig {
    implicit val encoder: Encoder[HumanPig] = deriveEncoder[HumanPig]
    implicit val decoder: Decoder[HumanPig] = deriveDecoder[HumanPig]
  }

  case class IqPig(answer: Int)

  object IqPig {
    implicit val encoder: Encoder[IqPig] = deriveEncoder[IqPig]
    implicit val decoder: Decoder[IqPig] = deriveDecoder[IqPig]
  }



  var humanPig = HumanPig(intelligence = None)

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val routes: Route =
    path("pig" / "view") {
      get {
        complete(humanPig)
      }
    } ~
      path("pig" / "rename") {
        parameters("name") { name =>
          post {
            val newhumanPig = humanPig.copy(name = name)
            humanPig = newhumanPig
            complete(newhumanPig)
          }
        }
      } ~
      path("pig" / "intellect") {
        (post & entity(as[Intelligence])) { myIntelligence =>

          val newIntelligence = humanPig.copy(intelligence = Some(myIntelligence))
          humanPig = newIntelligence
          complete(humanPig)
        }
      } ~
      path("pig"/"iq") {
        get {
          val calculating = humanPig.intelligence.map(v => v.brainWeight / v.convolutions).getOrElse(0)

          val iqPig = IqPig(calculating)
          complete(iqPig)
        }
      }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}
