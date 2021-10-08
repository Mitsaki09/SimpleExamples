package clientServerExample.exampleHuman.tables

import slick.lifted.Tag
import slick.jdbc.PostgresProfile.api._
import io.circe.{Decoder, Encoder}

import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}



case class HumanForSound(id: Option[Int],
                         idHuman: Option[Int],
                         name: String,
                         sound: String,
                         soundDescription: String,
                         cases: String)
object HumanForSound {
  implicit val encoder: Encoder[HumanForSound] = deriveEncoder[HumanForSound]
  implicit val decoder: Decoder[HumanForSound] = deriveDecoder[HumanForSound]
}

object HumanForSoundModel {
  class HumanForSoundTable(tag: Tag) extends Table[HumanForSound](tag, "humanForSound") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def idHuman = column[Option[Int]]("idHuman")

    def name = column[String]("name")

    def sound = column[String]("sound")

    def soundDescription = column[String]("soundDescription")

    def cases = column[String]("cases")

    // склелили поля бд с кейс классом.
    override def * = (id, name, sound, soundDescription, cases).mapTo[HumanForSound]
  }

  val humanForSounds = TableQuery[HumanForSoundTable]
}