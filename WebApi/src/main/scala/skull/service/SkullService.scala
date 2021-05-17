package skull.service

import skull.dao.SkullDAO
import skull.model.Skull
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.{ExecutionContext, Future}

trait SkullService {
  def getSkull(id: Int): Future[Skull]
  def createSkull(skull: Skull):Future[Int]
  def updateSkull(skull: Skull):Future[Int]
}

class SkullServiceImpl(skullDAO: SkullDAO)(implicit executionContext: ExecutionContext) extends SkullService {

  val skullDatabase = Database.forURL(
    url = "jdbc:postgresql://localhost:5432/skull",
    user = "postgres",
    password = "1234",
    driver = "org.postgresql.Driver")

  override def getSkull(id: Int): Future[Skull] = {
    val optionSkullInFuture: Future[Option[Skull]] = skullDatabase.run(skullDAO.findById(id))
    optionSkullInFuture.map(skullOpt => skullOpt.getOrElse(throw new Exception("no pig for id " + id)))
  }

  override def createSkull(skull: Skull): Future[Int] = {
    skullDatabase.run(skullDAO.create(skull))
  }

  override def updateSkull(skull: Skull): Future[Int] = {
    skullDatabase.run(skullDAO.update(skull))
  }
}