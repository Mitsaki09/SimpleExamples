package terraria

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.{pathPrefix, _}
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import terraria.controller.BossController
import terraria.dao.BossDAOImpl
import terraria.service.BossServiceImpl

import scala.io.StdIn

object BossProject extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.dispatcher


  val bossDAOImpl = new BossDAOImpl
  val bossService = new BossServiceImpl(bossDAOImpl)
  val bossController = new BossController(bossService)


  private val routes: Route =
    pathPrefix("api" / "v2") {
      bossController.route
    }




  val bindingFuture = Http().bindAndHandle(routes, "localhost", 8081)

  println(s"Server online at http://localhost:8081/\nPress RETURN to stop...")
  StdIn.readLine()
  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())

}
