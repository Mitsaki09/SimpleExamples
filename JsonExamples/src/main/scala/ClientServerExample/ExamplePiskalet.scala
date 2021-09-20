package ClientServerExample

import ClientServerExample.MainPhoneServer1.Phone
import ClientServerExample.MainPiskaletServer1.Piskalet
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

object MainPiskaletServer1 extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher




  case class Piskalet(cartridges: Int, model: String,price:Int)
  object Piskalet {
    implicit val encoder: Encoder[Piskalet] = deriveEncoder[Piskalet] // закодирует в джисон
    implicit val decoder: Decoder[Piskalet] = deriveDecoder[Piskalet] // разакадирует из джисона
  }



  val routes: Route =
    path("example" / "json") {
      get {

        val piskalet = Piskalet(12,"iPhone", 6960)

        /* val json =
          s"""
            |{
            |  "mark" : "${phone.mark}",
            |  "model" : "${phone.model}"
            |}
            |""".stripMargin*/

        val resp = HttpResponse(
          status = 200,
          entity = HttpEntity(MediaTypes.`application/json`, Piskalet.encoder.apply(piskalet).toString()) // указываем, что мы хотим вернуть джисон
          //entity = HttpEntity(MediaTypes.application/json, json)
        )
        complete(resp)
      }
    }


  Http().bindAndHandle(routes, "localhost", 8081)
  println("Сервер стартанул")

}

object MainPiskaletClient1 extends App {
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
  println("ОТВЕТ СЕРВЕРА:" + Unmarshal(result.entity).to[Piskalet]) // превращаем джисон в кейс класс
}