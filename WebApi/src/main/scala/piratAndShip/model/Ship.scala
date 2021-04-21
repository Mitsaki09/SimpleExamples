package piratAndShip.model

case class Ship(id: Option[Int],
                NameShip: String,
                MaxCrew: Int,
                idPirat: Option[Int]
                    )
object Ship {

  import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
  import io.circe.{Decoder, Encoder}


  implicit val decoderEngine: Decoder[Ship] = deriveDecoder[Ship]
  implicit val encoderEngine: Encoder[Ship] = deriveEncoder[Ship]
}