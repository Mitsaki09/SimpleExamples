package turkish.dao

import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._
import turkish.tables.{Turkish,TurkishModel}

import scala.concurrent.ExecutionContext

trait TurkishDAO {

  def init: DBIO[Unit]

  def create(turkish: Turkish): DBIO[Int]

}

class TurkishDAOImpl(implicit executionContext: ExecutionContext) extends TurkishDAO {

import TurkishModel.turks
  override def init = turks.schema.create

  override def create(turkish: Turkish): DBIO[Int] = turks += turkish
  }