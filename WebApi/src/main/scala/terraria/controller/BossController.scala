package terraria.controller

import akka.http.scaladsl.marshalling.ToResponseMarshaller
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import akka.http.scaladsl.model.{HttpEntity, HttpResponse, MediaTypes}
import akka.http.scaladsl.server.Route
import io.circe.{Encoder, Printer}
import utils.Controller
import scala.util.Success
import terraria.model.Boss
import terraria.service.BossService

class BossController(bossService: BossService) extends Controller {

  import terraria.model.BossImplicits._

  override def route: Route =
    getBoss ~
      createBoss ~
      updateBoss

  protected def getBoss: Route = pathPrefix("boss") {
    path("view" / IntNumber) { id =>
      get {
        onComplete(bossService.getBoss(id)) {
          case Success(v) => complete(v)
        }
      }
    }
  }

  protected def createBoss: Route = pathPrefix("boss") {
    path("sozdat") {
      (put & entity(as[Boss])) { boss =>
        onComplete(bossService.createBoss(boss)) {

          case Success(_) => complete("создался")
        }
      }
    }
  }

  protected def updateBoss: Route = pathPrefix("boss") {
    path("izmen") {
      (post & entity(as[Boss])) { boss =>
        onComplete(bossService.updateBoss(boss)) {
          case Success(_) => complete("изменился")
        }
      }
    }
  }

  implicit def jsonMarshaller[A](implicit encoder: Encoder[A], e: ToResponseMarshaller[HttpResponse]): ToResponseMarshaller[A] =
    e.compose(v =>
      HttpResponse(
        status = 200,
        entity = HttpEntity(MediaTypes.`application/json`, encoder.apply(v).printWith(Printer(true, " ")))
      ))
}




