package clientServerExample.slickWithJsonAnimal.animalJson

import clientServerExample.slickWithJsonTrainer.QueryRunner
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import clientServerExample.slickWithJsonAnimal.dao.AnimalDAOImpl
import clientServerExample.slickWithJsonAnimal.tables.Animal
import slick.jdbc.PostgresProfile.api._

object MainAnimalServer extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val queryRunner = new QueryRunner(Database.forURL(
    url = "jdbc:postgresql://localhost:5432/animal",
    user = "postgres",
    password = "1234",
    driver = "org.postgresql.Driver"))

  val animalDAOImpl = new AnimalDAOImpl

  val routes: Route =
    path("init" / "animal") {
      post {
   val initAnimal = queryRunner.run(animalDAOImpl.init).toString

        complete(initAnimal)

      }
    }~
    path("create" / "animal") {
      parameters("name", "age".as[Int], "gender", "race", "weight".as[Int]) { (name, age, gender, race, weight) =>
        post {
          val animal = Animal(None, name, age, gender, race, weight)
          val resultCreate = queryRunner.run(animalDAOImpl.create(animal)).toString

          complete(resultCreate)

        }
      }
    } ~
      path("findById" / "animal") {
        parameters("id".as[Int]) { id =>
          post {
            val resultFindById = queryRunner.run(animalDAOImpl.findById(id)).toString

            complete(resultFindById)

          }
        }
      } ~
      path("dltById" / "animal") {
        parameters("id".as[Int]) { id =>
          post {
            val resultDltById = queryRunner.run(animalDAOImpl.dltById(id)).toString

            complete(resultDltById)

          }
        }
      } ~
      path("all" / "animal") {

        post {
          val resultAll = queryRunner.run(animalDAOImpl.all).toString

          complete(resultAll)

        }
      } ~
      path("allAnimalByRace" / "animal") {
        parameters("raceWithSearch") { raceWithSearch =>
          post {
            val resultRaceWithSearch = queryRunner.run(animalDAOImpl.allAnimalByRace(raceWithSearch)).toString

            complete(resultRaceWithSearch)

          }
        }
      } ~
      path("allAnimalWithRaceAndGender" / "animal") {
        parameters("raceWithSearch", "genderWithSearch") { (raceWithSearch, genderWithSearch) =>
          post {
            val allAnimalWithRaceAndGender = queryRunner.run(animalDAOImpl.allAnimalWithRaceAndGender(raceWithSearch, genderWithSearch)).toString

            complete(allAnimalWithRaceAndGender)

          }
        }
      } ~
      path("findByWeight" / "animal") {
        parameters("weightWithSearch".as[Int]) { weightWithSearch =>
          post {
            val findByWeight = queryRunner.run(animalDAOImpl.findByWeight(weightWithSearch)).toString

            complete(findByWeight)

          }
        }
      }
  path("overrideNameWithId" / "animal") {
    parameters("idSearch".as[Int], "name") { (idSearch, name) =>
      post {
        val overrideNameWithId = queryRunner.run(animalDAOImpl.overrideNameWithId(idSearch, name)).toString

        complete(overrideNameWithId)

      }
    }
  }~
    path("overrideWeightWithId" / "animal") {
      parameters("idSearch".as[Int], "weight".as[Int]) { (idSearch, weight) =>
        post {
          val overrideWeightWithId = queryRunner.run(animalDAOImpl.overrideWeightWithId(idSearch, weight)).toString

          complete(overrideWeightWithId)

        }
      }
    }
  Http().bindAndHandle(routes, "localhost", 8080)
  println("Сервер стартанул")

}

