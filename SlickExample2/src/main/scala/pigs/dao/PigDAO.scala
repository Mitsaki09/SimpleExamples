package pigs.dao
import pigs.tables.{Pig, PigModel}
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext

// Этот файл нужен для формирования запроса. Можно сказать, вот тут слик генерил SQL код, который чет делает

// Такие файлы всегда называют по формату *название сущности* + DAO
// Используют трейт, потому что иногда надо ходить в несколько баз и наследники могут делать это по разному
trait PigDAO {

  // DBIO - это как Future, только для базы данных. Да БД захотела свой собстенный тип.

  def init: DBIO[Unit]

  def create(pig: Pig): DBIO[Int]

  def pigsyweight(pigId:Int,weight: Int): DBIO[Int]

  def pigsyweightAndPrice(pigId:Int,weight: Int, price:Double ): DBIO[Int]

  def updateAll(pig: Pig):DBIO[Int]

  def all :DBIO[Seq[Pig]]

}

// Файлы всегда называют по формату *название трейта* + Impl . (Impl = implementation = реализация)
class PigDAOImpl(implicit executionContext: ExecutionContext) extends PigDAO {

  import PigModel.pigs

  override def init = pigs.schema.create // создать базу данным самим

  override def create(pig: Pig): DBIO[Int] = pigs += pig

  override def pigsyweight(pigId:Int,weight: Int): DBIO[Int] = {
    pigs.filter(_.id === pigId)
      .map(b => (b.weight))
      .update(weight)
  }

  override def pigsyweightAndPrice(pigId:Int,newWeight: Int, newPrice:Double): DBIO[Int] = {
    pigs.filter(_.id === pigId)
      .map(b => (b.weight, b.price))
      .update(newWeight, newPrice)
  }

  override def updateAll(pig: Pig):DBIO[Int] = {
    pigs.filter(_.id   === pig.id)
      .update(pig)
  }
  override def all :DBIO[Seq[Pig]] = pigs.result

}