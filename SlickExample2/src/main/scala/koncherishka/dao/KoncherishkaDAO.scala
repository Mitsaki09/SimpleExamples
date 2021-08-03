package koncherishka.dao

import koncherishka.tables.Koncherishka
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext

trait KoncherishkaDAO {

  def init: DBIO[Unit]
  def create(koncherishka: Koncherishka): DBIO[Int]
  def all: DBIO[Seq[Koncherishka]]
  def setKills(kills:Int,idk:Int): DBIO[Int]

}

class KoncherishkaDAOImpl(implicit executionContext: ExecutionContext) extends KoncherishkaDAO {

  import koncherishka.tables.KoncherishkaModel.koncherishkas

  override def init = koncherishkas.schema.create

  override def create(koncherishka: Koncherishka): DBIO[Int] = koncherishkas += koncherishka

  override def all = koncherishkas.result

  override def setKills(kills:Int,idK:Int): DBIO[Int] = {
    koncherishkas.filter(_.id === idK)
      .map(b => (b.kills))
      .update(kills)
  }


}