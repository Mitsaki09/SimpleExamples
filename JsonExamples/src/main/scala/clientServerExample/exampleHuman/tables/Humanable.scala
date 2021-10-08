package clientServerExample.exampleHuman.tables

import slick.lifted.Tag
import slick.jdbc.PostgresProfile.api._
import io.circe.{Decoder, Encoder}

import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}


case class Human(id: Option[Int],
                  name: String,
                   citizenship: String)

object Human {
  implicit val encoder: Encoder[Human] = deriveEncoder[Human]
  implicit val decoder: Decoder[Human] = deriveDecoder[Human]
}

object HumanModel {
  class HumanTable(tag: Tag) extends Table[Human](tag, "human") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def citizenship = column[String]("citizenship")

    // склелили поля бд с кейс классом.
    override def * = (id, name, citizenship).mapTo[Human]
  }
  val humans = TableQuery[HumanTable]
}