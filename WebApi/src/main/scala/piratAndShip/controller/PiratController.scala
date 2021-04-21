package piratAndShip.controller


import akka.http.scaladsl.marshalling.ToResponseMarshallable.apply
import akka.http.scaladsl.server.Route
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import piratAndShip.model.Pirat
import piratAndShip.service.PiratService
import utils.Controller

import scala.util.Success

class PiratController(piratService: PiratService) extends Controller {


  override def route: Route =
    getPirat ~
      createPirat ~
      updatePirat


  protected def getPirat: Route = pathPrefix("pirat") {
    path("view" / IntNumber) { id =>
      get {
        onComplete(piratService.getPirat(id)) {
          case Success(v) => complete(v)
        }
      }
    }
  }


  protected def createPirat: Route = pathPrefix("pirat") {
    path("sozdat") {
      (put & entity(as[Pirat])) { pirat =>
        onComplete(piratService.createPirat(pirat)) {
          case Success(_) => complete("создался")
        }
      }
    }
  }

  protected def updatePirat: Route = pathPrefix("pirat") {
    path("izmen") {
      (post & entity(as[Pirat])) { pirat =>
        onComplete(piratService.updatePirat(pirat)) {
          case Success(_) => complete("изменился")
        }
      }
    }
  }
  protected def init: Route = pathPrefix("pirat") {
    path("init") {
        onComplete(piratService.init) {
          case Success(_) => complete("инитнулся")
        }
      }
    }



}


