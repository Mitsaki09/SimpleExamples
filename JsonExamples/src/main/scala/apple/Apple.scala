package apple
import io.circe._
import io.circe.generic.auto._
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.parser._
import io.circe.syntax._

object AppleExample extends App{

case class Apple(color: String, weight: Double)

  val greenApple = Apple("green", 0.35)

  val json = greenApple.asJson.noSpaces
  println(json)

  val decodedAppleGreen = decode[Apple](json)
  println(decodedAppleGreen)


  val jsonInStr = "{\n  \"color\": \"Red\",\n  \"weight\": 0.431\n}"
  val decodedAppleRed = decode[Apple](jsonInStr)
  println(decodedAppleRed)


  implicit val decoder: Decoder[Apple] = deriveDecoder[Apple]
  implicit val encoder: Encoder[Apple] = deriveEncoder[Apple]



}
