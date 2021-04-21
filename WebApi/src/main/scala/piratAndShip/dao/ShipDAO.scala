package piratAndShip.dao

import piratAndShip.model.Ship
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.ExecutionContext

trait ShipDAO {

  def findById(id: Int): DBIO[Option[Ship]]

  def init: DBIO[Unit]

  def create(ship: Ship): DBIO[Int]

  def update(ship: Ship): DBIO[Int]

}

class ShipDAOImpl(implicit executionContext: ExecutionContext) extends ShipDAO {

  import piratAndShip.tables.ShipModel._

  override def init = ships.schema.create

  override def create(ship: Ship): DBIO[Int] = ships += ship

  override def findById(id: Int): DBIO[Option[Ship]] = {
    ships.filter(_.id === id).result.headOption
  }

  override def update(ship: Ship): DBIO[Int] = {
    ships.filter(_.id === ship.id).update(ship)
  }

}