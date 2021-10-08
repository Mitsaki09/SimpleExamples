package clientServerExample.otherExample

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpMethods, HttpRequest, HttpResponse}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object MainEatServer extends App {
  case class Pig(name: String, age: Int, weight: Int, children: Int, tits: Int)

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  case class Eat(eatWont: String)

  val seqEat: Seq[String] = Seq("sup", "nichego", "penis")

  object Eat {
    implicit val encoder: Encoder[Eat] = deriveEncoder[Eat]
    implicit val decoder: Decoder[Eat] = deriveDecoder[Eat]
  }

  val routes: Route =
    path("dinner" / "want") {
      parameters("eat") { eat =>
        post {
          val eatDinner = Eat(eat)
          if (seqEat.contains(eatDinner.eatWont)) {
            val resp = HttpResponse(
              status = 404)
            complete(resp)
          } else {
            complete(eatDinner.eatWont)
          }
        }
      }

    }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")
}


object MainEatClient extends App {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val request = HttpRequest(
    method = HttpMethods.POST,
    uri = "http://localhost:8080/dinner/want?eat=sup"
  )

  val resultFuture: Future[HttpResponse] = Http().singleRequest(request)
  val result: HttpResponse = Await.result(resultFuture, Duration.Inf)

  println("MainEatClient:" + Unmarshal(result.entity).to[String])
}