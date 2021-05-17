package skull.tables

import skull.model.Skull
import slick.jdbc.PostgresProfile.api._
import slick.lifted.Tag

object SkullModel {

  class SkullTable(tag: Tag) extends Table[Skull](tag, "pig") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def glow = column[Boolean]("glow")

    def * = (id, name, glow) <> (Skull.tupled, Skull.unapply)
  }
  val skulls = TableQuery[SkullTable]
}