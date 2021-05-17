package piratAndShip.tables
import piratAndShip.model.Ship
import slick.jdbc.PostgresProfile.api._
import slick.lifted.Tag

object ShipModel {

  class ShipTable(tag: Tag) extends Table[Ship](tag, "ship") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def nameShip = column[String]("name_ship")
    def maxCrew = column[Int]("max_crew")
    def idPirat = column[Option[Int]]("id_pirat")


    override def * = (id, nameShip, maxCrew, idPirat).mapTo[Ship]
  }
val ships = TableQuery[ShipTable]
}


