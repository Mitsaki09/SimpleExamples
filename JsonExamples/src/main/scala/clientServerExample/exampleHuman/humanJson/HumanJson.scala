package clientServerExample.exampleHuman.humanJson

import clientServerExample.slickWithJsonTrainer.QueryRunner
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import clientServerExample.exampleHuman.dao.{HumanDAOImpl, HumanForSoundDAOImpl}
import clientServerExample.exampleHuman.tables.{Human, HumanForSound}
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
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

  val humanDAOImpl = new HumanDAOImpl
  val humanForSoundDAOImpl = new HumanForSoundDAOImpl



  val routes: Route =
    path("man" / "create") {
      (put & entity(as[Human])) { myHuman =>
        val resultCreate = queryRunner.run(humanDAOImpl.createHuman(myHuman)).toString

        complete(resultCreate)

      }
    } ~
      path("man" / "all") {
        get {
          val resultAll = queryRunner.run(humanDAOImpl.allHuman).toString
          complete(resultAll)

        }
      } ~
      path("man" / "one") {
        parameters("id".as[Int]) { id =>
          get {
            val resultFindById = queryRunner.run(humanDAOImpl.findByIdHuman(id)).toString
            complete(resultFindById)

          }
        }
      }~
      path("man" / "create") {
        (put & entity(as[HumanForSound])) { myHumanForSound =>
          get {
            val resultFindById = queryRunner.run(humanForSoundDAOImpl.createHumanForSound(myHumanForSound)).toString
            complete(resultFindById)

          }
        }
      }~
      path("sound" / "all" / "byId") {
        parameters("id".as[Int]) { id =>
          get {
            val resultFindById = queryRunner.run(humanForSoundDAOImpl.setHumanById(id)).toString
            complete(resultFindById)

          }
        }
      }

        Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")
}