package car.carDAO

import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.ExecutionContext

trait CarDAO {
  def init: DBIO[Unit]
}

class CarDAOImpl(implicit executionContext: ExecutionContext) extends CarDAO {

  import car.tables.CarModel.cars

  override def init = cars.schema.create
}
