package clientServerExample.slickWithJsonTrainer.tables

import slick.lifted.Tag
import slick.jdbc.PostgresProfile.api._


case class Trainer(id: Option[Int],
                  name: String,
                  age: Int,
                  experience: Int)

object TrainerModel {
  class TrainerTable(tag: Tag) extends Table[Trainer](tag, "trainer") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def age = column[Int]("age")
    def experience = column[Int]("experience")

    // склелили поля бд с кейс классом.
    override def * = (id, name, age, experience).mapTo[Trainer]
  }
  val trainers = TableQuery[TrainerTable]
}