package car.carService

import car.carDAO.CarDAO
import slick.jdbc.PostgresProfile.api._


import scala.concurrent.{ExecutionContext, Future}

trait CarService{

  def init : Future[Unit]


}
class CarServiceImpl(carDAO:CarDAO)(implicit executionContext: ExecutionContext) extends CarService {


  val carDatabase = Database.forURL(
    url = "jdbc:postgresql://localhost:5432/carF",
    user = "postgres",
    password = "1234",
    driver = "org.postgresql.Driver")

  override def init: Future[Unit] = {
    carDatabase.run(carDAO.init)
  }

}