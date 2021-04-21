package piratAndShip.controller


import akka.http.scaladsl.server.Route
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._

import piratAndShip.model.Ship
import piratAndShip.service.ShipService
import utils.Controller

import scala.util.Success

class ShipController(shipService: ShipService) extends Controller {


  override def route: Route =
    getShip ~
      createShip ~
      updateShip


  protected def getShip: Route = pathPrefix("ship") {
    path("view" / IntNumber) { id =>
      get {
        onComplete(shipService.getShip(id)) {
          case Success(v) => complete(v)
        }
      }
    }
  }


  protected def createShip: Route = pathPrefix("ship") {
    path("sozdat") {
      (put & entity(as[Ship])) { pirat =>
        onComplete(shipService.createShip(pirat)) {
          case Success(_) => complete("создался")
        }
      }
    }
  }

  protected def updateShip: Route = pathPrefix("ship") {
    path("izmen") {
      (post & entity(as[Ship])) { pirat =>
        onComplete(shipService.updateShip(pirat)) {
          case Success(_) => complete("изменился")
        }
      }
    }
  }
  protected def init: Route = pathPrefix("ship") {
    path("init") {
      onComplete(shipService.init) {
        case Success(_) => complete("инитнулся")
      }
    }
  }

}


