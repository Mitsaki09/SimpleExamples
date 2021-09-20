package ClientServerExample

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpMethods, HttpRequest, HttpResponse}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}


object MainPigServer extends App {
  case class Pig(name:String,age:Int,weight:Int,children:Int,tits:Int)
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val routes: Route =
    path("create" / "pig") {
      parameters("name", "age".as[Int], "weight".as[Int],"children".as[Int],"tits".as[Int]) { (name, age, weight,children,tits) =>
        get {
val pig = Pig(name,age,weight,children,tits)
println(pig)
          complete(s"$name $age $weight $children $tits")
        }
      }
    }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}

object MainPigClient extends App {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val request = HttpRequest(
    method = HttpMethods.GET,
    uri = "http://localhost:8080/create/pig?name=Artem&age=19&weight=60&children=0&tits=6"
  )

  val resultFuture: Future[HttpResponse] = Http().singleRequest(request)
  val result: HttpResponse = Await.result(resultFuture, Duration.Inf)

  println("MainPigClient:" + Unmarshal(result.entity).to[String])
}