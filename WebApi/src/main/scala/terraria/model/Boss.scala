package terraria.model

case class Boss(id: Option[Int], name: String, hp: Int, dmg: Int, canFly: Boolean) {

}
object BossImplicits {

  import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
  import io.circe.{Decoder, Encoder}

  implicit val decoder: Decoder[Boss] = deriveDecoder[Boss]
  implicit val encoder: Encoder[Boss] = deriveEncoder[Boss]
}