package clientServerExample.slickWithJsonAnimal.dao

import clientServerExample.slickWithJsonAnimal.tables.Animal
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext

trait AnimalDAO {
  def init: DBIO[Unit]

  def create(animal: Animal): DBIO[Int]

  def findById(id: Int): DBIO[Option[Animal]]

  def dltById(idD: Int): DBIO[Int]

  def all: DBIO[Seq[Animal]]

  def allAnimalByRace(raceWithSearch: String): DBIO[Seq[Animal]]

  def allAnimalWithRaceAndGender(raceWithSearch: String, genderWithSearch: String): DBIO[Seq[Animal]]

  def findByWeight(weightWithSearch: Int): DBIO[Seq[Animal]]

  def overrideNameWithId(idSearch: Int, name: String): DBIO[Int]

  def overrideWeightWithId(idSearch: Int, weight: Int): DBIO[Int]
}

  class AnimalDAOImpl(implicit executionContext: ExecutionContext) extends AnimalDAO {

    import clientServerExample.slickWithJsonAnimal.tables.AnimalModel.animals

    override def init = animals.schema.create

    override def create(animal: Animal): DBIO[Int] = animals += animal

    override def findById(id: Int): DBIO[Option[Animal]] = {
      animals.filter(_.id === id).result.headOption
    }
    override def dltById(idD: Int): DBIO[Int] = {
      animals.filter(_.id === idD).delete
    }
    override def all = animals.result

    override def allAnimalByRace(raceWithSearch:String): DBIO[Seq[Animal]] = {
      animals.filter(_.race === raceWithSearch).result
  }
    override  def allAnimalWithRaceAndGender(raceWithSearch:String,genderWithSearch:String): DBIO[Seq[Animal]] = {
      animals.filter(_.race === raceWithSearch)
        .filter(_.gender === genderWithSearch ).result
    }
    override def findByWeight(weightWithSearch: Int): DBIO[Seq[Animal]] = {
      animals.filter(_.weight === weightWithSearch).result
    }
    override def overrideNameWithId(idSearch:Int,name:String): DBIO[Int] = {
      animals.filter(_.id === idSearch )
        .map(n=>n.name)
        .update(name)
    }
    override def overrideWeightWithId(idSearch:Int,weight:Int): DBIO[Int] = {
      animals.filter(_.id === idSearch )
        .map(n=>n.weight)
        .update(weight)
    }


}
