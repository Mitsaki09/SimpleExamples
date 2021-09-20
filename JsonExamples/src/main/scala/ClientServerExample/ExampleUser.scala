package ClientServerExample

import ClientServerExample.MainPhoneServer1.Phone
import ClientServerExample.MainPiskaletServer1.Piskalet
import ClientServerExample.MainUserServer.User
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

object MainUserServer extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher




  case class User(id: Int, login: String,password:String)
  object User {
    implicit val encoder: Encoder[User] = deriveEncoder[User] // закодирует в джисон
    implicit val decoder: Decoder[User] = deriveDecoder[User] // разакадирует из джисона
  }
/*  val user1 = User(1,"ABOBUS2017", "QWERTY")
  val user2 = User(2,"KOREYKADASHKA", "DASHATOP")
  val user3 = User(3,"YAZAGEEV2020", "PIDORI")*/

var seqUsers:Seq[User] = Seq()


  val routes: Route =
    path("user" / "create" ) {
      parameters("login","password") { (login,password) =>
        post {
          val seed = new java.util.Date().hashCode
          val rand = new scala.util.Random(seed)
          val someNum = rand.nextInt
          val user1 = User(someNum,"ABOBUS2017", "QWERTY")

          seqUsers= seqUsers:+user1


          val resp = HttpResponse(
            status = 200,
            entity = HttpEntity(MediaTypes.`application/json`, User.encoder.apply(user1).toString()) // указываем, что мы хотим вернуть джисон

          )
          complete(resp)
        }
      }
    }~
      path("user" ) {
        get {
          parameters("id") { id =>
      val a = seqUsers.find(someId => someId.id == id)
            a match {
              case Some(n) =>
                val resp = HttpResponse(
                  status = 200,
                  entity = HttpEntity(MediaTypes.`application/json`, User.encoder.apply(n).toString()) // указываем, что мы хотим вернуть джисон

                )
                complete(resp)

              case None =>
            val resp = HttpResponse(
            status = 200


            )
            complete(resp)
            }




          }
        }
      }

  Http().bindAndHandle(routes, "localhost", 8081)
  println("Сервер стартанул")

}

object MainUserClient extends App {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val request = HttpRequest(
    method = HttpMethods.GET,
    uri = "http://localhost:8081/user/create?login=koreykadasha&yagei"
  )

  val resultFuture: Future[HttpResponse] = Http().singleRequest(request)
  val result: HttpResponse = Await.result(resultFuture, Duration.Inf)


  val request2 = HttpRequest(
    method = HttpMethods.POST,
    uri = s"http://localhost:8080/user?id=12"
  )

  val resultFuture2: Future[HttpResponse] = Http().singleRequest(request2)
  val result2: HttpResponse = Await.result(resultFuture2, Duration.Inf)

  println(result.status)
  println("ОТВЕТ СЕРВЕРА:" + Unmarshal(result.entity).to[User]) // превращаем джисон в кейс класс
}