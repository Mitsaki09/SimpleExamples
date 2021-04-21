package piratAndShip.service

import piratAndShip.dao.ShipDAO
import piratAndShip.model.Ship
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.{ExecutionContext, Future}

trait ShipService {

  def getShip(id: Int): Future[Ship]

  def createShip(ship: Ship): Future[Int]

  def updateShip(ship: Ship): Future[Int]

  def init : Future[Unit]

}
class ShipServiceImpl(shipDAO: ShipDAO)(implicit executionContext: ExecutionContext) extends ShipService {
  val shipDatabase = Database.forURL(
    url = "jdbc:postgresql://localhost:5432/ship",
    user = "postgres",
    password = "1234",
    driver = "org.postgresql.Driver")

  override def getShip(id: Int): Future[Ship] = {

    val optionShipInFuture: Future[Option[Ship]] = shipDatabase.run(shipDAO.findById(id))
    optionShipInFuture.map(shipOpt => shipOpt.getOrElse(throw new Exception("invalid id: " + id)))
  }

  override def createShip(ship: Ship): Future[Int] = {
    println("i was here")
    shipDatabase.run(shipDAO.create(ship))
  }

  override def updateShip(ship: Ship): Future[Int] = {
    shipDatabase.run(shipDAO.update(ship))
  }

  override def init: Future[Unit] = {
    shipDatabase.run(shipDAO.init)
  }
}

