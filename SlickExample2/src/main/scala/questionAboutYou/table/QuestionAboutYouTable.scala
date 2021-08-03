package questionAboutYou.table

import slick.lifted.Tag
import slick.jdbc.PostgresProfile.api._


case class QuestionAboutYou(id: Option[Int],
                            name: String,
                            age: Int,
                            loveGame: Boolean,
                            normal:Boolean,
                            kill:Boolean,
                            watchAnime:Boolean,
                            likeScala:Boolean,
                            questionAboutYou: String)

object QuestionAboutYouModel {
  class QuestionAboutYouTable(tag: Tag) extends Table[QuestionAboutYou](tag, "questionAboutYou") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def age = column[Int]("age")
    def loveGame = column[Boolean]("loveGame")
    def normal = column[Boolean]("normal")
    def kill = column[Boolean]("kill")
    def watchAnime = column[Boolean]("watchAnime")
    def likeScala = column[Boolean]("likeScala")
    def questionAboutYou = column[String]("questionAboutYou")

    // склелили поля бд с кейс классом.
    override def * = (id, name, age, loveGame,normal,kill,watchAnime,likeScala,questionAboutYou).mapTo[QuestionAboutYou]
  }
  val questionAboutYours = TableQuery[QuestionAboutYouTable]
}
