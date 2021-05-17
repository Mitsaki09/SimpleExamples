package anime.dao
import anime.model.{Anime, Author, Hero}
import anime.tables.AnimeModel.animes
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext

trait AnimeDAO {

  def findById(id: Int): DBIO[Option[Anime]]

  def create(anime: Anime): DBIO[Int]

  def update(anime: Anime): DBIO[Int]


  def findAuthorById(id: Int): DBIO[Option[Author]]

  def findHeroById(id: Int): DBIO[Option[Hero]]

  def updateAuthorById(id: Int, newAuthor: Author): DBIO[Int]

  def updateHeroById(id: Int, newHero: Hero): DBIO[Int]

}

class AnimeDAOImpl(implicit executionContext: ExecutionContext) extends AnimeDAO {

  override def create(anime: Anime): DBIO[Int] = animes += anime

  override def findById(id: Int): DBIO[Option[Anime]] = {
    animes.filter(_.id === id).result.headOption
  }

  override def update(anime: Anime): DBIO[Int] = {
    animes.filter(_.id === anime.id).update(anime)
  }

  override def findAuthorById(id: Int): DBIO[Option[Author]] =  {
    animes.filter(_.id === id)
      .map(_.author)
      .result.headOption
  }

  override def findHeroById(id: Int): DBIO[Option[Hero]] = {
    animes.filter(_.id === id)
      .map(_.hero)
      .result.headOption
}

  override def updateAuthorById(id: Int, newAuthor: Author): DBIO[Int] = {
    animes.filter(_.id === id)
      .map(_.author)
      .update(newAuthor)
  }

  override def updateHeroById(id: Int, newHero: Hero): DBIO[Int] = {
    animes.filter(_.id === id)
      .map(_.hero)
      .update(newHero)
  }

}


