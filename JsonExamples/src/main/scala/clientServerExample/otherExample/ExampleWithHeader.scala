package clientServerExample.otherExample

import akka.actor.ActorSystem
import akka.http.scaladsl.Http

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import akka.stream.ActorMaterializer


object MainExampleWithHeaderServer extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val routes: Route =
    path("example" / "header") {
      post {
        parameters("str") { str =>
          optionalHeaderValueByName("Str") { strOpt =>
            complete(s"$str , $strOpt  ")
          }
        }
      }
    }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}
