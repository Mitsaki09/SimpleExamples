package exampleWithEntity.exampleSchool
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import akka.stream.ActorMaterializer
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.{Decoder, Encoder}

import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

object MainKurduplikServer extends App {
  case class Student(firstName:String,middleName:String,lastName:String,dickSm:Int)
  object Student {
    implicit val encoder: Encoder[Student] = deriveEncoder[Student]
    implicit val decoder: Decoder[Student] = deriveDecoder[Student]
  }
  case class ClassRoom(studentSeq:Seq[Student],numberClass:String)
  object ClassRoom {
    implicit val encoder: Encoder[ClassRoom] = deriveEncoder[ClassRoom]
    implicit val decoder: Decoder[ClassRoom] = deriveDecoder[ClassRoom]
  }

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val routes: Route =
    path("biggest" / "dick") {
      (post & entity(as[ClassRoom])) { myClassRoom =>

        val comp = myClassRoom.studentSeq.maxBy(v=> v.dickSm)
        complete(comp)

      }
    }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}
