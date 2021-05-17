package car.carController

import akka.http.scaladsl.server.Directives.{complete, headerValueByName, onComplete, parameters, path, pathPrefix, post}
import akka.http.scaladsl.server.{Directives, Route}
import car.CarProject.carService

import scala.util.Success


class CarController extends Controller {

  override def route: Route =
    queryParams


  protected def queryParams = pathPrefix("car") {
    parameters("queryParams") { (a) =>
      post {
        complete(s" Hello worlds from " + a)
      }
    }
  }


  protected def header = pathPrefix("car") {
    headerValueByName("header") { (b) =>
      get {
        complete(s"The user is " + b)
      }
    }
  }



}
trait Controller extends Directives {
  def route: Route
}