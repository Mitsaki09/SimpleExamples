package animeTyans.dao

import animeTyans.tables.AnimeTyan
import slick.dbio.DBIO
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext

trait AnimeTyanDAO {


  def init: DBIO[Unit]

  def create(animeTyan: AnimeTyan): DBIO[Int]

}

class AnimeTyanDAOImpl(implicit executionContext: ExecutionContext) extends AnimeTyanDAO {

import animeTyans.tables.AnimeTyanModel.animeTyans

  override def init = animeTyans.schema.create

  override def create(animeTyan: AnimeTyan): DBIO[Int] = animeTyans += animeTyan

}