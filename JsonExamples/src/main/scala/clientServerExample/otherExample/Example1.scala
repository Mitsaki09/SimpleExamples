package clientServerExample.otherExample

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpMethods, HttpRequest, HttpResponse}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}


object MainPhoneServer extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val routes: Route =
    path("example" / "string") {
      get {

        println("Кто-то вызвал метод example/string")
        complete("это просто строка, никакого Джисона Стетхема и уважения")

      }
    }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}

object MainPhoneClient extends App {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val request = HttpRequest(
    method = HttpMethods.GET,
    uri = "http://localhost:8080/example/string"
  )

  val resultFuture: Future[HttpResponse] = Http().singleRequest(request)
  val result: HttpResponse = Await.result(resultFuture, Duration.Inf)

  println("MainPhoneClient:" + Unmarshal(result.entity).to[String])
}