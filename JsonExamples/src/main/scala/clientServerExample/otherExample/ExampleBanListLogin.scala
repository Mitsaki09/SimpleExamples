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

object MainBanListLoginServer extends App {
  case class Pig(name: String, age: Int, weight: Int, children: Int, tits: Int)

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  case class User(loginUser: String)

  val banListForUser :Seq[String] = Seq("SUCHKA,ABOBUS,DIMATUCHKA,TEDDY,DIMENTOR")

  object User {
    implicit val encoder: Encoder[User] = deriveEncoder[User]
    implicit val decoder: Decoder[User] = deriveDecoder[User]
  }

  val routes: Route =
    path("user" ) {
      parameters("login") { login =>
        post {
        val user = User(login)
          val cont = user.loginUser.contains(banListForUser)
          if (cont == true ){
            val resp = HttpResponse(
              status = 401)
            complete(resp)
          }else{

            val randomInt = (1 to 100).toList

            scala.util.Random.shuffle(randomInt).take(1)


            complete("zaglotus" + user.loginUser + randomInt )
          }

        }
      }

    }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")
}


object MainBanListLoginClient extends App {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val request = HttpRequest(
    method = HttpMethods.POST,
    uri = "http://localhost:8080/user?login=SUCHKAaa"
  )

  val resultFuture: Future[HttpResponse] = Http().singleRequest(request)
  val result: HttpResponse = Await.result(resultFuture, Duration.Inf)

  println("MainEatClient:" + Unmarshal(result.entity).to[String])
}