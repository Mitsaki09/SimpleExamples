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


object MainFistServer extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val routes: Route =
    path("fisting" / "anal" / "size") {
      parameters("name"){ name =>
      post {
val lengthName = name.length

        complete(s"$lengthName")
      }
      }
    }~
      path("fisting" / "ana" /"insert") {
        parameters("sm".as[Int],"name") { (sm,name) =>
          post {
          complete(s"Мы фистим $name на $sm см")
          }
        }
      }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}

object MainFistClient extends App {
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val requestPostSize = HttpRequest(
    method = HttpMethods.POST,
    uri = "http://localhost:8080/word/up?word=darova"
  ) // подготовка
  val resultFutureSize: Future[HttpResponse] = Http().singleRequest(requestPostSize) // посылаем запрос на сервер
  val resultSize: HttpResponse = Await.result(resultFutureSize, Duration.Inf) // ждем, когда сервер нам ответит
  val fistSize: String =  Await.result(Unmarshal(resultSize.entity).to[String], Duration.Inf) // ждем, пока достаем из ответа сервера наши данные. Теперь это просто строка и ее можно использовать в коде дальше

  println("fistSize:" + fistSize)

  val requestInsert = HttpRequest(
    method = HttpMethods.POST,
    uri = s"http://localhost:8080/word/down?word=$fistSize"
  )
  val resultFutureInsert: Future[HttpResponse] = Http().singleRequest(requestInsert) // посылаем запрос на сервере
  val resultInsert: HttpResponse = Await.result(resultFutureInsert, Duration.Inf) // ждем, когда сервер нам ответит
  val fistInsert: String =  Await.result(Unmarshal(resultInsert.entity).to[String], Duration.Inf) // ждем, пока достаем из ответа сервера наши данные. Теперь это просто строка и ее можно использовать в коде дальше

  println("fistInsert:" + fistInsert)
}