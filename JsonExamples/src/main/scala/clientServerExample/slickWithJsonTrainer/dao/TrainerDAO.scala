package clientServerExample.slickWithJsonTrainer.dao


import clientServerExample.slickWithJsonTrainer.tables.Trainer
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext

trait TrainerDAO {
  def init: DBIO[Unit]

  def create(trainer: Trainer): DBIO[Int]

  def findById(id: Int): DBIO[Option[Trainer]]

  def dltById(idD: Int): DBIO[Int]

  def findByName(name: String): DBIO[Option[Trainer]]

  def all: DBIO[Seq[Trainer]]

  def allTrainerByExp(exp:Int): DBIO[Seq[Trainer]]


}

class TrainerDAOImpl(implicit executionContext: ExecutionContext) extends TrainerDAO {

  import clientServerExample.slickWithJsonTrainer.tables.TrainerModel.trainers

  override def init = trainers.schema.create

  override def create(trainer: Trainer): DBIO[Int] = trainers += trainer

  override def findById(id: Int): DBIO[Option[Trainer]] = {
    trainers.filter(_.id === id).result.headOption
  }

  override def dltById(idD: Int): DBIO[Int] = {
    trainers.filter(_.id === idD).delete
  }

  override def findByName(name: String): DBIO[Option[Trainer]] = {
    trainers.filter(_.name === name).result.headOption
  }

  override def all = trainers.result

  override def allTrainerByExp(exp:Int): DBIO[Seq[Trainer]] = {
    trainers.filter(_.experience >= exp).result
  }

}
