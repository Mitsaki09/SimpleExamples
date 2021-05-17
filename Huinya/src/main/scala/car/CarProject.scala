package car

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.{pathPrefix, _}
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import car.carController.CarController
import car.carDAO.CarDAOImpl
import car.carService.CarServiceImpl

import scala.io.StdIn

object CarProject extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher


  val carDAOImpl = new CarDAOImpl
  val carService = new CarServiceImpl(carDAOImpl)
  val carController = new CarController


  private val routes: Route =
    pathPrefix("api" / "v2") {
      carController.route
    }




  val bindingFuture = Http().bindAndHandle(routes, "localhost", 8081)

  println(s"Server online at http://localhost:8081/\nPress RETURN to stop...")
  StdIn.readLine()
  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())


}
