package car.tables
import car.carModel.Car
import slick.jdbc.PostgresProfile.api._
import slick.lifted.Tag

object CarModel {

  class CarTable(tag:Tag) extends Table[Car](tag,"CarF") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def price = column[Double]("price")
    def model = column[String]("model")

    override def * = (id,price,model) <> ((Car.apply _).tupled, Car.unapply)
  }
  val cars = TableQuery[CarTable]
}