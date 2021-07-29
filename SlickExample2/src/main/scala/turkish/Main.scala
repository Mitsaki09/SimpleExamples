package turkish
import slick.jdbc.PostgresProfile.api._
import turkish.dao.TurkishDAOImpl
import turkish.tables.Turkish

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App{
  val queryRunner = new QueryRunner(Database.forURL(
    url = "jdbc:postgresql://localhost:5432/pig", // путь к БД. Он всегда стандартный, порт выбираем при установке
    user = "postgres", // стандартное имя пользователя при установке БД
    password = "1234", // пароль к БД
    driver = "org.postgresql.Driver")) // указываем, что мы используем базу данных postgresql
val turkishDAOImpl = new TurkishDAOImpl
  val myBadTurkish = Turkish(
    id = None,
    name = "Faruk",
    rank = "Global",
    age = 9,
    oruspugugu = true)
  val myGoodTurkish = Turkish(
    id = None,
    name = "Dilyal",
    rank = "Silver",
    age = 21,
    oruspugugu = false)

 // queryRunner.run(turkishDAOImpl.create(myBadTurkish))
  queryRunner.run(turkishDAOImpl.create(myGoodTurkish)) // 2
 // queryRunner.run(turkishDAOImpl.init)       // init 1
}
