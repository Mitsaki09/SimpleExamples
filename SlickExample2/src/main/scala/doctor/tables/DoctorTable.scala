package doctor.tables

import slick.lifted.Tag
import slick.jdbc.PostgresProfile.api._


case class Doctor(id: Option[Int],
                  name: String,
                  age: Int,
                  direction: String)

object DoctorModel {
  class DoctorTable(tag: Tag) extends Table[Doctor](tag, "doctor") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def age = column[Int]("age")
    def direction = column[String]("direction")

    // склелили поля бд с кейс классом.
    override def * = (id, name, age, direction).mapTo[Doctor]
  }
  val doctors = TableQuery[DoctorTable]
}