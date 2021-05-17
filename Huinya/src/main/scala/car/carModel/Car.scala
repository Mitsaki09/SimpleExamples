package car.carModel

case class Car(id: Option[Int], price: Double, model: String)

object Car {

  import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
  import io.circe.{Decoder, Encoder}

  implicit val decoderEngine: Decoder[Car] = deriveDecoder[Car]
  implicit val encoderEngine: Encoder[Car] = deriveEncoder[Car]
}
