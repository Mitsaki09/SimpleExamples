package clientServerExample.otherExample

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpMethods, HttpRequest, HttpResponse}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import clientServerExample.otherExample.MainFormServer.{AllUser, LoginUser}
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}


object MainFormServer extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val forbidden: Seq[String] = Seq("PIZDAHUIKA","DICK","VAGINA","SVINKA","AMINA")

  case class AllUser(userName: String, login: String, gender: String)

  object AllUser {
    implicit val encoder: Encoder[AllUser] = deriveEncoder[AllUser]
    implicit val decoder: Decoder[AllUser] = deriveDecoder[AllUser]
  }

  case class LoginUser(login: String)

  object LoginUser {
    implicit val encoder: Encoder[LoginUser] = deriveEncoder[LoginUser]
    implicit val decoder: Decoder[LoginUser] = deriveDecoder[LoginUser]
  }

  case class BanLogin(login: String)

  object BanLogin {
    implicit val encoder: Encoder[BanLogin] = deriveEncoder[BanLogin]
    implicit val decoder: Decoder[BanLogin] = deriveDecoder[BanLogin]
  }

  val routes: Route =
    path("check" / "allData") {
      parameters("userName", "login", "gender") { (userName, login, gender) =>
        post {
          val allUser = AllUser(userName, login, gender)
          complete(allUser)

        }
      }
    } ~
      path("check" / "login") {
        parameters("login") { login =>
          post {
            val loginUser = LoginUser(login.toUpperCase())

            complete(loginUser)

          }
        }
      } ~
      path("check" / "banLogin") {
        parameters("login") { login =>
          post {
            val banLogin = BanLogin(login.toUpperCase())
           if ( forbidden.contains(banLogin.login) ) {
             val resp = HttpResponse(
               status = 403)
             complete(resp)
           }else {
             complete(banLogin.login)
           }
          }
        }
      }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}

object MainFormClient extends App {
  implicit val systemAllUser = ActorSystem()
  implicit val materializerAllUser = ActorMaterializer()
  implicit val executionContextAllUser = systemAllUser.dispatcher
  //-------------------------------------------AllUser-----------------------------------------------------------
  val requestAllUser = HttpRequest(
    method = HttpMethods.POST,
    uri = "http://localhost:8080/check/allData?userName=SexiKroshka2014&login=SexBomb&gender=woman"
  )

  val resultFutureAllUser: Future[HttpResponse] = Http().singleRequest(requestAllUser)
  val resultAllUser: HttpResponse = Await.result(resultFutureAllUser, Duration.Inf)
  val allUser = Await.result(Unmarshal(resultAllUser.entity).to[AllUser], Duration.Inf)
  //-------------------------------------------Login-----------------------------------------------------------

  val requestLogin = HttpRequest(
    method = HttpMethods.POST,
    uri = s"http://localhost:8080/check/login?login=${allUser.login}"
  )

  val resultFutureLogin: Future[HttpResponse] = Http().singleRequest(requestLogin)
  val resultLogin: HttpResponse = Await.result(resultFutureLogin, Duration.Inf)
  val login = Await.result(Unmarshal(resultLogin.entity).to[LoginUser], Duration.Inf)



  //-------------------------------------------BanLogin-----------------------------------------------------------

  val requestBanLogin = HttpRequest(
    method = HttpMethods.POST,
    uri = s"http://localhost:8080/check/banLogin?login=${login.login}"
  )

  val resultFutureBanLogin: Future[HttpResponse] = Http().singleRequest(requestBanLogin)
  val resultBanLogin: HttpResponse = Await.result(resultFutureBanLogin, Duration.Inf)
  println("получилось:" + resultBanLogin)

}