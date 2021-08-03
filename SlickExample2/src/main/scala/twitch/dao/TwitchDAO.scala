package twitch.dao
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._
import twitch.table.Twitch

import scala.concurrent.ExecutionContext
trait TwitchDAO {

  def init: DBIO[Unit]

  def create(twitch: Twitch): DBIO[Int]

  def all :DBIO[Seq[Twitch]]

  def twitchNickName(nickName:String,idT:Int): DBIO[Int]

  def dltById (idT:Int): DBIO[Int]

  def killTwitch(kill:Boolean,idT:Int): DBIO[Int]

  def donationsTwitch(donations:Int,idT:Int): DBIO[Int]

  def normalTwitch(normal:Boolean,idT:Int): DBIO[Int]

}
class TwitchDAOImpl(implicit executionContext: ExecutionContext) extends TwitchDAO {

  import twitch.table.TwitchModel.twitchs
  override def init = twitchs.schema.create
  override def create(twitch: Twitch): DBIO[Int] = twitchs += twitch
  override def all :DBIO[Seq[Twitch]] = twitchs.result

  override  def twitchNickName(nickName:String,idT:Int): DBIO[Int] = {
    twitchs.filter(_.id === idT)
      .map(b => (b.nickName))
      .update(nickName)
  }
  override def dltById (idT:Int): DBIO[Int]= {
    twitchs.filter(_.id === idT).delete
  }
  override def killTwitch(kill:Boolean,idT:Int): DBIO[Int] = {
    twitchs.filter(_.id === idT)
      .map(b => (b.kill))
      .update(kill)
  }
  override def donationsTwitch(donations:Int,idT:Int): DBIO[Int] = {
    twitchs.filter(_.id === idT)
      .map(b => (b.donations))
      .update(donations)
  }
  override def normalTwitch(normal:Boolean,idT:Int): DBIO[Int] = {
    twitchs.filter(_.id === idT)
      .map(b => (b.normal))
      .update(normal)
  }
}
