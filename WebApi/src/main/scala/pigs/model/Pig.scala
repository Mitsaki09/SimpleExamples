package pigs.model

case class Pig(id: Option[Int], name: String, weight:Int)

object PigImplicits {
  import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
  import io.circe.{Decoder, Encoder}

  implicit val decoder: Decoder[Pig] = deriveDecoder[Pig]
  implicit val encoder: Encoder[Pig] = deriveEncoder[Pig]
}