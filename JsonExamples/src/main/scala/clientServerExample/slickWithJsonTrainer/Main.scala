package clientServerExample.slickWithJsonTrainer

import clientServerExample.slickWithJsonTrainer.dao.TrainerDAOImpl
import clientServerExample.slickWithJsonTrainer.tables.Trainer
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {

  val queryRunner = new QueryRunner(Database.forURL(
    url = "jdbc:postgresql://localhost:5432/trainer",
    user = "postgres",
    password = "1234",
    driver = "org.postgresql.Driver"))

  val trainerDAOImpl = new TrainerDAOImpl

  val myTrainer = Trainer(
    id = None,
    name = "Селёдка",
    age = 9,
    experience = 1
  )


  //queryRunner.run(trainerDAOImpl.init)  // init 1
 queryRunner.run(trainerDAOImpl.create(myTrainer)) // 2

}

