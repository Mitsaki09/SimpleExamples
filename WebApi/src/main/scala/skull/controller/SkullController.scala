package skull.controller

import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import akka.http.scaladsl.server.Route
import skull.model.Skull
import skull.service.SkullService
import utils.Controller

import scala.util.Success

class SkullController(skullService: SkullService) extends Controller {

  import skull.model.SkullImplicits._

  override def route: Route =
    getSkull ~
      createSkull ~
      updateSkull

  protected def getSkull: Route = pathPrefix("skull") {
    path("view" / IntNumber) { id =>
      get {
        onComplete(skullService.getSkull(id)) {
          case Success(v) => complete(v)
        }
      }
    }
  }

  protected def createSkull: Route = pathPrefix("skull") {
    path("sozdat") {
      (put & entity(as[Skull])) { skull =>
        onComplete(skullService.createSkull(skull)) {
          case Success(_) => complete("создался")
        }
      }
    }
  }

  protected def updateSkull: Route = pathPrefix("skull") {
    path("izmen") {
      (post & entity(as[Skull])) { skull =>
        onComplete(skullService.updateSkull(skull)) {
          case Success(_) => complete("изменился")
        }
      }
    }
  }

}
