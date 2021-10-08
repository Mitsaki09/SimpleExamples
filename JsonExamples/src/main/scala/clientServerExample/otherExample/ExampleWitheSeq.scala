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


object SeqVarServer extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  var seqEmpty:Seq[String] = Seq()

  val routes: Route =
    path("name" / "add") {
      post {
        parameters("name") { name =>

          seqEmpty = seqEmpty:+name

          complete("ok")
        }
      }
    }~
      path("name" / "all") {
        get {
            complete(s"${seqEmpty.mkString(",") }")

        }
      }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}

object SeqVarClient extends App {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val request1 = HttpRequest(
    method = HttpMethods.POST,
    uri = "http://localhost:8080/name/add?name=Radya"
  )

  val resultFutur1e: Future[HttpResponse] = Http().singleRequest(request1)
  val result1: HttpResponse = Await.result(resultFutur1e, Duration.Inf)

  println("SeqVarClient:" + Unmarshal(result1.entity).to[String])


  val request2 = HttpRequest(
    method = HttpMethods.GET,
    uri = "http://localhost:8080/name/all"
  )

  val resultFuture2: Future[HttpResponse] = Http().singleRequest(request2)
  val result2: HttpResponse = Await.result(resultFuture2, Duration.Inf)

  println("SeqVarClient:" + Unmarshal(result2.entity).to[String])


}