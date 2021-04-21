package piratAndShip


import piratAndShip.dao.PiratDAOImpl
import piratAndShip.model.{Pirat, Ship}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global

object MainPirat extends App {

  val queryRunner = new QueryRunner(Database.forURL(
    url = "jdbc:postgresql://localhost:5432/pirat",
    user = "postgres",
    password = "1234",
    driver = "org.postgresql.Driver"))


  val myPirat1 = Pirat(
    id = None,
    namePirat = "Флюс",
    rank = "Матрос",
    age = 31,
    height = 13.25f,
    wounds = 1,
    parrotName = "Джоджо",
    nationality = "португалец")

  val myPirat2 = myPirat1.copy(namePirat = "Снюс", rank = "Капитан", nationality = "румын", parrotName = "Румыняшик")
  val myPirat3 = myPirat1.copy(namePirat = "Жид", rank = "Якорщик", nationality = "еврей", parrotName = "Шекель")
  val myPirat4 = myPirat1.copy(namePirat = "Снюс", rank = "Рулевой", nationality = "донбассовец", parrotName = "Румыняшик")

  val myShip = Ship(
    id = None,
    NameShip = "Великий свин",
    MaxCrew = 4,
    idPirat = None)


}


