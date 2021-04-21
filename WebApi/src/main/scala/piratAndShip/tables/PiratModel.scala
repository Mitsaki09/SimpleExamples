package piratAndShip.tables
import piratAndShip.model.Pirat
import slick.jdbc.PostgresProfile.api._
import slick.lifted.Tag

object PiratModel {

  class PiratTable(tag: Tag) extends Table[Pirat](tag, "piratAndShip") {

  def idPirats = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def namePirat = column[String]("name_pirat")
    def rank = column[String]("rank")
    def age = column[Int]("age")
    def height = column[Float]("height")
    def wounds = column[Int]("wounds")
    def parrotName = column[String]("parrot_name")
    def nationality = column[String]("nationality")

    override def * = (idPirats, namePirat, rank, age, height, wounds, parrotName, nationality).mapTo[Pirat]
}
  val pirats = TableQuery[PiratTable]
}