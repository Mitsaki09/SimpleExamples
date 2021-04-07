package anime.tables
import anime.model.{Anime, Author, Genre, Hero}
import slick.jdbc.PostgresProfile.api._
import slick.lifted.Tag


object AnimeModel {

  class AnimeTable(tag: Tag) extends Table[Anime](tag, "anime") {
    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)

    def firstName=column[String]("firstName")
    def middleName=column[Option[String]]("middleName")
    def lastName=column[String]("lastName")

    def name=column[String]("name")

    def quantity=column[String]("quantity")
    def nickName=column[String]("nickName")
    def force=column[Int]("force")

    def price=column[Int]("price")
    def time=column[Int]("time")


    def author =(firstName,middleName,lastName).mapTo[Author]
    def genre =(name).mapTo[Genre]
    def hero =(quantity,nickName,force).mapTo[Hero]
    override def * =(author,genre,hero,price,time).mapTo[Anime]
  }
  val animes= TableQuery[AnimeTable]
}