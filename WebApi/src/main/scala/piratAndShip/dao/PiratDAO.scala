package piratAndShip.dao

import piratAndShip.model.Pirat
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext

trait PiratDAO {

  def findById(id: Int): DBIO[Option[Pirat]]

  def init: DBIO[Unit]

  def create(pirat: Pirat): DBIO[Int]

  def update(pirat: Pirat): DBIO[Int]

}

class PiratDAOImpl(implicit executionContext: ExecutionContext) extends PiratDAO {

  import piratAndShip.tables.PiratModel._

  override def init = pirats.schema.create

  override def create(pirat: Pirat): DBIO[Int] = pirats += pirat

  override def findById(id: Int): DBIO[Option[Pirat]] = {
    pirats.filter(_.idPirats === id).result.headOption
  }

  override def update(pirat: Pirat): DBIO[Int] = {
    pirats.filter(_.idPirats === pirat.id).update(pirat)
  }

}
