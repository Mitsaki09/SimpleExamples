package pigs.controller

import akka.http.scaladsl.marshalling.ToResponseMarshaller
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import akka.http.scaladsl.model.{HttpEntity, HttpResponse, MediaTypes}
import akka.http.scaladsl.server.Route
import io.circe.{Encoder, Printer}
import pigs.model.Pig
import pigs.service.PigService
import utils.Controller

import scala.util.Success

class PigController(pigService: PigService) extends Controller {

  import pigs.model.PigImplicits._

  override def route: Route =
    getPig ~
    createPig ~
    updatePig

  protected def getPig: Route = pathPrefix("pig") {
    path("view" / IntNumber) { id =>
      get {
        onComplete(pigService.getPig(id)) {
          case Success(v) => complete(v)
        }
      }
    }
  }
  protected def createPig: Route = pathPrefix("pig") {
    path("sozdat") {
      (put & entity(as[Pig]) ){ pig =>
        onComplete(pigService.createPig(pig)) {
          case Success(_) => complete("создался")
        }
      }
    }
  }
  protected def updatePig: Route = pathPrefix("pig") {
    path("izmen") {
      (post & entity(as[Pig]) ){ pig =>
        onComplete(pigService.updatePig(pig)) {
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
