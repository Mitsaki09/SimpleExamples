package piratAndShip.service

import piratAndShip.dao.PiratDAO
import piratAndShip.model.Pirat
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.{ExecutionContext, Future}

trait PiratService {

  def getPirat(id: Int): Future[Pirat]

  def createPirat(pirat: Pirat): Future[Int]

  def updatePirat(pirat: Pirat): Future[Int]

  def init : Future[Unit]
}
class PiratServiceImpl(piratDAO: PiratDAO)(implicit executionContext: ExecutionContext) extends PiratService {
  val piratDatabase = Database.forURL(
    url = "jdbc:postgresql://localhost:5432/pirat",
    user = "postgres",
    password = "1234",
    driver = "org.postgresql.Driver")

  override def getPirat(id: Int): Future[Pirat] = {

    val optionPiratInFuture: Future[Option[Pirat]] = piratDatabase.run(piratDAO.findById(id))
    optionPiratInFuture.map(piratOpt => piratOpt.getOrElse(throw new Exception("invalid id: " + id)))
  }

  override def createPirat(pirat: Pirat): Future[Int] = {
    println("i was here")
    piratDatabase.run(piratDAO.create(pirat))
  }

  override def updatePirat(pirat: Pirat): Future[Int] = {
    piratDatabase.run(piratDAO.update(pirat))
  }

  override def init: Future[Unit] = {
    piratDatabase.run(piratDAO.init)
  }
}

