package doctor.dao
import doctor.tables.Doctor
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext
trait DoctorDAO {

  def init: DBIO[Unit]

  def create(doctor: Doctor): DBIO[Int]


  def doctorsName(name:String,idD:Int): DBIO[Int]

  def doctorAge(age:Int,idD:Int): DBIO[Int]

  def all :DBIO[Seq[Doctor]]

  def dltById (idD:Int): DBIO[Int]
}
class DoctorDAOImpl(implicit executionContext: ExecutionContext) extends DoctorDAO {

  import doctor.tables.DoctorModel.doctors
  override def init = doctors.schema.create
  override def create(doctor: Doctor): DBIO[Int] = doctors += doctor

  override  def doctorsName(name:String,idD:Int): DBIO[Int] = {
    doctors.filter(_.id === idD)
      .map(b => (b.name))
      .update(name)
  }
  override def doctorAge(age:Int,idD:Int): DBIO[Int] = {
    doctors.filter(_.id === idD)
      .map(b => (b.age))
      .update(age)
  }
  override def all :DBIO[Seq[Doctor]] = doctors.result
  override def dltById (idD:Int): DBIO[Int]= {
    doctors.filter(_.id === idD).delete
  }

}
