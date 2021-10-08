package clientServerExample.slickWithJsonTrainer.trainerJson


import clientServerExample.slickWithJsonTrainer.QueryRunner
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import clientServerExample.slickWithJsonTrainer.dao.TrainerDAOImpl
import clientServerExample.slickWithJsonTrainer.tables.Trainer
import slick.jdbc.PostgresProfile.api._



object MainTrainerServer extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val queryRunner = new QueryRunner(Database.forURL(
    url = "jdbc:postgresql://localhost:5432/trainer",
    user = "postgres",
    password = "1234",
    driver = "org.postgresql.Driver"))

  val trainerDAOImpl = new TrainerDAOImpl


  val routes: Route =
    path("create" / "trainer") {
      parameters("name", "age".as[Int], "exp".as[Int]) { (name, age, exp) =>
        post {
          val trainer = Trainer(None, name, age, exp)
          val resultCreate = queryRunner.run(trainerDAOImpl.create(trainer)).toString

          complete(resultCreate)

        }
      }
    } ~
      path("findById" / "trainer") {
        parameters("id".as[Int]) { id =>
          post {
            val resultFindById = queryRunner.run(trainerDAOImpl.findById(id)).toString
            complete(resultFindById)

          }
        }
      } ~
      path("dltById" / "trainer") {
        parameters("id".as[Int]) { id =>
          post {
            val resultdDltById = queryRunner.run(trainerDAOImpl.dltById(id)).toString
            complete(resultdDltById)

          }
        }
      } ~
      path("findByName" / "trainer") {
        parameters("name") { name =>
          post {
            val resultdDltById = queryRunner.run(trainerDAOImpl.findByName(name)).toString
            complete(resultdDltById)

          }
        }
      } ~
      path("all" / "trainer") {
        post {
          val resultAll = queryRunner.run(trainerDAOImpl.all).toString
          complete(resultAll)
        }
      } ~
      path("allTrainerByExp" / "trainer") {
        parameters("experience".as[Int]) { experience =>
          post {
            val resultAll = queryRunner.run(trainerDAOImpl.allTrainerByExp(experience)).toString
            complete(resultAll)
          }
        }
      }


  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}