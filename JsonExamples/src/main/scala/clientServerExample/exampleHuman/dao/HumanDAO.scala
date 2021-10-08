package clientServerExample.exampleHuman.dao


import clientServerExample.exampleHuman.tables.HumanForSoundModel.humanForSounds
import clientServerExample.exampleHuman.tables.{Human, HumanForSound}
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext

trait HumanDAO {
  def initHuman: DBIO[Unit]

  def createHuman(human: Human): DBIO[Int]

  def allHuman: DBIO[Seq[Human]]

  def findByIdHuman(id: Int): DBIO[Option[Human]]

  def createHumanForSound(humanForSound: HumanForSound): DBIO[Int]

  def initHumanForSound: DBIO[Unit]

}

class HumanDAOImpl(implicit executionContext: ExecutionContext) extends HumanDAO {

  import clientServerExample.exampleHuman.tables.HumanModel.humans


  override def initHuman = humans.schema.create

  override def createHuman(human: Human): DBIO[Int] = humans += human

  override def allHuman = humans.result

  override def findByIdHuman(id: Int): DBIO[Option[Human]] = {
    humans.filter(_.id === id).result.headOption
  }



}


trait HumanForSoundDAO {

  def createHumanForSound(humanForSound: HumanForSound): DBIO[Int]

  def initHumanForSound: DBIO[Unit]

  def setHumanById(humanId: Int): DBIO[Seq[HumanForSound]]

}
import clientServerExample.exampleHuman.tables.HumanForSoundModel.humanForSounds

class HumanForSoundDAOImpl(implicit executionContext: ExecutionContext) extends HumanForSoundDAO {

  override def createHumanForSound(humanForSound: HumanForSound): DBIO[Int] = humanForSounds += humanForSound

  override def initHumanForSound = humanForSounds.schema.create

  override def setHumanById(humanId: Int): DBIO[Seq[HumanForSound]] = {
    humanForSounds.filter(_.idHuman === humanId).result

  }
}
