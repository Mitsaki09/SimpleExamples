package clientServerExample.otherExample

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}



object MainFoodServer extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  case class Ingredient(name:String,taste:String,weight:Int,price:Int)

  object Ingredient {
    implicit val encoder: Encoder[Ingredient] = deriveEncoder[Ingredient]
    implicit val decoder: Decoder[Ingredient] = deriveDecoder[Ingredient]
  }
  case class Food(name:String,seqIngredient:Seq[Ingredient])

  object Food {
    implicit val encoder: Encoder[Food] = deriveEncoder[Food]
    implicit val decoder: Decoder[Food] = deriveDecoder[Food]
  }


  val routes: Route =
    path("food" / "price") {
      parameters("discount".as[Int].?) { discount =>
        (post & entity(as[Food])) { myFood =>
          val countAllPrice = myFood.seqIngredient.map(_.price).sum
          val countDiscount = countAllPrice * discount.getOrElse(0) / 100
          complete(countAllPrice - countDiscount)

        }
      }
    }

  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}

