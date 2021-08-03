package questionAboutYou.dao

import questionAboutYou.table.QuestionAboutYou
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._


import scala.concurrent.ExecutionContext
trait QuestionAboutYouDAO {

  def init: DBIO[Unit]

  def create(questionAboutYou: QuestionAboutYou): DBIO[Int]

  def all :DBIO[Seq[QuestionAboutYou]]

  def name(name:String,idT:Int): DBIO[Int]

  def dltById (idT:Int): DBIO[Int]

  def kill(kill:Boolean,idT:Int): DBIO[Int]

  def normal(normal:Boolean,idT:Int): DBIO[Int]

  def watchAnime(watchAnime:Boolean,idT:Int): DBIO[Int]

  def likeScala(likeScala:Boolean,idT:Int): DBIO[Int]

  def questionAboutYouDef(questionAboutYou:String,idT:Int): DBIO[Int]

  def age(age:Int,idT:Int): DBIO[Int]

  def loveGame(loveGame:Boolean,idT:Int): DBIO[Int]

}
class QuestionAboutYouDAOImpl(implicit executionContext: ExecutionContext) extends QuestionAboutYouDAO {

import questionAboutYou.table.QuestionAboutYouModel.questionAboutYours

  override def init = questionAboutYours.schema.create
  override def create(questionAboutYou: QuestionAboutYou): DBIO[Int] = questionAboutYours += questionAboutYou
  override def all :DBIO[Seq[QuestionAboutYou]] = questionAboutYours.result

  override  def name(name:String,idT:Int): DBIO[Int] = {
    questionAboutYours.filter(_.id === idT)
      .map(b => (b.name))
      .update(name)
  }
  override def dltById (idT:Int): DBIO[Int]= {
    questionAboutYours.filter(_.id === idT).delete
  }
  override def kill(kill:Boolean,idT:Int): DBIO[Int] = {
    questionAboutYours.filter(_.id === idT)
      .map(b => (b.kill))
      .update(kill)
  }

  override def normal(normal:Boolean,idT:Int): DBIO[Int] = {
    questionAboutYours.filter(_.id === idT)
      .map(b => (b.normal))
      .update(normal)
  }

  override def watchAnime(watchAnime:Boolean,idT:Int): DBIO[Int] = {
    questionAboutYours.filter(_.id === idT)
      .map(b => (b.watchAnime))
      .update(watchAnime)
  }
  override def likeScala(likeScala:Boolean,idT:Int): DBIO[Int] = {
    questionAboutYours.filter(_.id === idT)
      .map(b => (b.likeScala))
      .update(likeScala)
  }
  override def questionAboutYouDef(questionAboutYou:String,idT:Int): DBIO[Int] = {
    questionAboutYours.filter(_.id === idT)
      .map(b => (b.questionAboutYou))
      .update(questionAboutYou)
  }
  override def age(age:Int,idT:Int): DBIO[Int] = {
    questionAboutYours.filter(_.id === idT)
      .map(b => (b.age))
      .update(age)
  }
  override def loveGame(loveGame:Boolean,idT:Int): DBIO[Int] = {
    questionAboutYours.filter(_.id === idT)
      .map(b => (b.loveGame))
      .update(loveGame)
  }


}
