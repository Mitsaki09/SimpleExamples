package skull.dao

import skull.model.Skull
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext


trait SkullDAO {

  def findById(id: Int): DBIO[Option[Skull]]

  def init: DBIO[Unit]

  def create(skull: Skull): DBIO[Int]

  def update(skull: Skull): DBIO[Int]
}

class SkullDAOImpl(implicit executionContext: ExecutionContext) extends SkullDAO {

  import skull.tables.SkullModel.skulls

  override def init = skulls.schema.create

  override def create(skull: Skull): DBIO[Int] = skulls += skull

  override def findById(id: Int): DBIO[Option[Skull]] = {
    skulls.filter(_.id === id).result.headOption
  }

  override def update(skull: Skull): DBIO[Int] = {
    skulls.filter(_.id === skull.id).update(skull)
  }

}


