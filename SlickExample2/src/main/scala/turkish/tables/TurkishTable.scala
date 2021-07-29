package turkish.tables

import slick.lifted.Tag
import slick.jdbc.PostgresProfile.api._

case class Turkish(id:Option[Int],
                   name:String,
                   rank:String,
                   age:Int,
                   oruspugugu:Boolean)
object TurkishModel  {

  class TurkishTable(tag:Tag) extends Table[Turkish](tag, "turkish"){

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def rank = column[String]("rank")
    def age = column[Int]("age")
    def oruspugugu = column[Boolean]("oruspugugu")

    override def * = (id, name, rank, age, oruspugugu).mapTo[Turkish]
  }
val turks = TableQuery[TurkishTable]
}
