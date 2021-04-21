package piratAndShip.model

case class Pirat(id: Option[Int],
                 namePirat: String,
                 rank: String,
                 age: Int,
                 height: Float,
                 wounds: Int = 0,
                 parrotName: String,
                 nationality: String)
object Pirat {

  import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
  import io.circe.{Decoder, Encoder}

  implicit val decoderEngine: Decoder[Pirat] = deriveDecoder[Pirat]
  implicit val encoderEngine: Encoder[Pirat] = deriveEncoder[Pirat]
}