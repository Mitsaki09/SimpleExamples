package koncherishka
import koncherishka.dao.KoncherishkaDAOImpl
import koncherishka.tables.Koncherishka
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {

  val queryRunner = new QueryRunner(Database.forURL(
    url = "jdbc:postgresql://localhost:5432/koncherishka",
    user = "postgres",
    password = "1234",
    driver = "org.postgresql.Driver"))

  val koncherishkaDAOImpl = new KoncherishkaDAOImpl


  val myKoncherishka = Koncherishka(
    id = None,
    nameInCSGo = "Аграфина Куцепердык",
    kills = 12,
    dead = 97
  )



  //queryRunner.run(KoncherishkaDAOImpl.create(myKoncherishka))


  queryRunner.run(koncherishkaDAOImpl.setKills(kills = 1, idK = 1))


//  queryRunner.run(KoncherishkaDAOImpl.init)


}
