package twitch.table

import slick.lifted.Tag
import slick.jdbc.PostgresProfile.api._


case class Twitch(id: Option[Int],
                  nickName: String,
                  ageInTwitch: Int,
                  donations: Int,
                  normal:Boolean,
                  kill:Boolean)

object TwitchModel {
  class TwitchTable(tag: Tag) extends Table[Twitch](tag, "twitch") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def nickName = column[String]("nickName")
    def ageInTwitch = column[Int]("ageInTwitch")
    def donations = column[Int]("donations")
    def normal = column[Boolean]("normal")
    def kill = column[Boolean]("kill")


    // склелили поля бд с кейс классом.
    override def * = (id, nickName, ageInTwitch, donations,normal,kill).mapTo[Twitch]
  }
  val twitchs = TableQuery[TwitchTable]
}
