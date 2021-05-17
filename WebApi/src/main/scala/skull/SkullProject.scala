package skull

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.{pathPrefix, _}
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import skull.controller.SkullController
import skull.dao.SkullDAOImpl
import skull.service.SkullServiceImpl

import scala.io.StdIn

object SkullProject extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher


  val skullDAOImpl = new SkullDAOImpl
  val skullService = new SkullServiceImpl(skullDAOImpl)
  val skullController = new SkullController(skullService)


  private val routes: Route =
    pathPrefix("api" / "v1") {
      skullController.route
    }




  val bindingFuture = Http().bindAndHandle(routes, "localhost", 8081)

  println(s"Server online at http://localhost:8081/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done

}
