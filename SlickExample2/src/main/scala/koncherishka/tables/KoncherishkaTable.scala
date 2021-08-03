package koncherishka.tables

import slick.lifted.Tag
import slick.jdbc.PostgresProfile.api._

case class Koncherishka(id: Option[Int],
                        nameInCSGo: String,
                        kills: Int,
                        dead: Int)

object KoncherishkaModel {

  class KoncherishkaTable(tag: Tag) extends Table[Koncherishka](tag, "koncherishka") {


    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def nameInCSGo = column[String]("nameInCSGo")
    def kills = column[Int]("kills")
    def dead = column[Int]("dead")

    override def * = (id, nameInCSGo, kills, dead).mapTo[Koncherishka]
  }
  val koncherishkas = TableQuery[KoncherishkaTable]
}