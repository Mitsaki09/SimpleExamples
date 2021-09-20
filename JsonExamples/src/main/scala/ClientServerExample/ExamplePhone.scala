package ClientServerExample

import ClientServerExample.MainPhoneServer1.Phone
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpEntity, HttpMethods, HttpRequest, HttpResponse, MediaTypes}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.{Decoder, Encoder, Printer}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object MainPhoneServer1 extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher




  case class Phone(mark: String, model: String)
  object Phone {
    implicit val encoder: Encoder[Phone] = deriveEncoder[Phone] // закодирует в джисон
    implicit val decoder: Decoder[Phone] = deriveDecoder[Phone] // разакадирует из джисона
  }



  val routes: Route =
    path("example" / "json") {
      get {

        val phone = Phone("iPhone", "12s")

        /* val json =
          s"""
            |{
            |  "mark" : "${phone.mark}",
            |  "model" : "${phone.model}"
            |}
            |""".stripMargin*/

        val resp = HttpResponse(
          status = 200,
          entity = HttpEntity(MediaTypes.`application/json`, Phone.encoder.apply(phone).toString()) // указываем, что мы хотим вернуть джисон
          //entity = HttpEntity(MediaTypes.application/json, json)
        )
        complete(resp)
      }
    }


  Http().bindAndHandle(routes, "localhost", 8081)
  println("Сервер стартанул")

}

object MainPhoneClient1 extends App {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val request = HttpRequest(
    method = HttpMethods.GET,
    uri = "http://localhost:8081/example/json"
  )

  val resultFuture: Future[HttpResponse] = Http().singleRequest(request)
  val result: HttpResponse = Await.result(resultFuture, Duration.Inf)

  println(result.status)
  println("ОТВЕТ СЕРВЕРА:" + Unmarshal(result.entity).to[Phone]) // превращаем джисон в кейс класс
}