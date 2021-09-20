package ClientServerExample

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpMethods, HttpRequest, HttpResponse}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}


object MainParamkServer extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val routes: Route =
    path("create" / "param") {
      parameters("int1".as[Int].optional, "int2".as[Int].optional, "int3".as[Int].optional) { (int1, int2, int3) =>
        get {

val sum = int1.getOrElse(0)+ int2.getOrElse(0) +int3.getOrElse(0)
          complete(s"$sum")
        }
      }
    }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}

object MainParamClient extends App {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val request = HttpRequest(
    method = HttpMethods.GET,
    uri = "http://localhost:8080/create/param?int1=1&int2=2&int3=4"
  )

  val resultFuture: Future[HttpResponse] = Http().singleRequest(request)
  val result: HttpResponse = Await.result(resultFuture, Duration.Inf)

  println("MainParamClient:" + Unmarshal(result.entity).to[String])
}