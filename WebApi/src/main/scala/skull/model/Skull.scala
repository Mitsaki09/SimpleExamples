package skull.model

case class Skull(id:Option[Int],name:String,glow:Boolean)
object SkullImplicits {
  import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
  import io.circe.{Decoder, Encoder}

  implicit val decoder: Decoder[Skull] = deriveDecoder[Skull]
  implicit val encoder: Encoder[Skull] = deriveEncoder[Skull]
}

