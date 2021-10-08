package clientServerExample.slickWithJsonAnimal.tables
import slick.lifted.Tag
import slick.jdbc.PostgresProfile.api._
case class Animal (id:Option[Int],
                    name:String,
                   age:Int,
                   gender:String,
                   race:String,
                   weight:Int)
object AnimalModel {
  class AnimalTable(tag:Tag) extends Table[Animal](tag,"animal"){

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def age = column[Int]("age")
    def gender = column[String]("gender")
    def race = column[String]("race")
    def weight = column[Int]("weight")

    override def * = (id, name, age, gender,race,weight).mapTo[Animal]

  }
  val animals = TableQuery[AnimalTable]
}

