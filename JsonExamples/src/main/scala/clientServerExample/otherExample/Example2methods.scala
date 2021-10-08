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


object MainBirthdayServer extends App {


  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val routes: Route =
    path("birthday" / "getName") {
      get {
          complete("Pines")
        }
      }~
      path("birthday" / "givePresent") {
        parameters("name") { name =>
          post {
            complete(s"С днём рождения $name ")
          }
        }
      }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}

object MainBirthdayClient extends App {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher



  val request = HttpRequest(
    method = HttpMethods.GET,
    uri = "http://localhost:8080/birthday/getName"
  ) // подготовка

  val resultFuture: Future[HttpResponse] = Http().singleRequest(request) // посылаем запрос на сервер
  val result: HttpResponse = Await.result(resultFuture, Duration.Inf) // ждем, когда сервер нам ответит

val name: String =  Await.result(Unmarshal(result.entity).to[String], Duration.Inf) // ждем, пока достаем из ответа сервера наши данные. Теперь это просто строка и ее можно использовать в коде дальше




  val request2 = HttpRequest(
    method = HttpMethods.POST,
    uri = s"http://localhost:8080/birthday/givePresent?name=$name"
  )

  val resultFuture2: Future[HttpResponse] = Http().singleRequest(request2)
  val result2: HttpResponse = Await.result(resultFuture2, Duration.Inf)

  println("MainPigClient:" + Unmarshal(result2.entity).to[String])
}


object MainBirthdayClient2 extends App {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher


  val request = HttpRequest(
    method = HttpMethods.GET,
    uri = "http://localhost:8080/birthday/getName"
  )

  val finalResultFuture = for {
     resultFuture <- Http().singleRequest(request)
     name <- Unmarshal(resultFuture.entity).to[String]
     request2 = HttpRequest(
       method = HttpMethods.POST,
       uri = s"http://localhost:8080/birthday/givePresent?name=$name"
     )
     resultFuture2 <- Http().singleRequest(request2)
     finalResult = Unmarshal(resultFuture2.entity).to[String]
  } yield finalResult


   println(Await.result(finalResultFuture, Duration.Inf))
}
