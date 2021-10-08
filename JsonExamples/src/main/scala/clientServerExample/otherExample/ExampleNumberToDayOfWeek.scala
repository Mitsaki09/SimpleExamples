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


object NumberToDayOfWeekServer extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val routes: Route =
    path("numberToDayOfWeek") {
      parameters("number".as[Int]){ number =>
        post {
val numberMatch = number match {
  case number1 if number == 1 => "Понедельник"
  case number2 if number == 2 => "Вторник"
  case number3 if number == 3 => "Среда"
  case number4 if number == 4 => "Четверг"
  case number5 if number == 5 => "Пятницв"
  case number6 if number == 6 => "Суббота"
  case number7 if number == 7 => "Воскресенье"
  case _ => "ОШБИКА"
}

          complete(s"$numberMatch")
        }
      }
    }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}

object NumberToDayOfWeekClient extends App {
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher


  val request = HttpRequest(
    method = HttpMethods.POST,
    uri = "http://localhost:8080/numberToDayOfWeek?number=5"
  )

  val resultFuture: Future[HttpResponse] = Http().singleRequest(request)
  val result: HttpResponse = Await.result(resultFuture, Duration.Inf)

  println("NumberToDayOfWeekClient:" + Unmarshal(result.entity).to[String])
}