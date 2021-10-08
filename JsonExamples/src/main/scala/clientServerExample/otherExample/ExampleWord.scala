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


object MainWordServer extends App {


  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val routes: Route =
    path("word" / "up") {
      parameters("word") { word =>
        post {
          val wordUpper = word.toUpperCase
          complete(s"$wordUpper")
        }
      }
    }~
      path("word" / "down") {
        parameters("word") { word =>
          post {
            val wordLow = word.toLowerCase()
            complete(s"$wordLow ")
          }
        }
      }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}

object MainWordClient2 extends App {
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val requestPostUpper = HttpRequest(
    method = HttpMethods.POST,
    uri = "http://localhost:8080/word/up?word=darova"
  ) // подготовка
  val resultFutureUpper: Future[HttpResponse] = Http().singleRequest(requestPostUpper) // посылаем запрос на сервер
  val resultUpper: HttpResponse = Await.result(resultFutureUpper, Duration.Inf) // ждем, когда сервер нам ответит
  val wordUpper: String =  Await.result(Unmarshal(resultUpper.entity).to[String], Duration.Inf) // ждем, пока достаем из ответа сервера наши данные. Теперь это просто строка и ее можно использовать в коде дальше

  println("wordUpper:" + wordUpper)

  val requestPostLower = HttpRequest(
    method = HttpMethods.POST,
    uri = s"http://localhost:8080/word/down?word=$wordUpper"
  )
  val resultFutureLower: Future[HttpResponse] = Http().singleRequest(requestPostLower) // посылаем запрос на сервере
  val resultLower: HttpResponse = Await.result(resultFutureLower, Duration.Inf) // ждем, когда сервер нам ответит
  val wordLower: String =  Await.result(Unmarshal(resultLower.entity).to[String], Duration.Inf) // ждем, пока достаем из ответа сервера наши данные. Теперь это просто строка и ее можно использовать в коде дальше

  println("wordLower:" + wordLower)

}
