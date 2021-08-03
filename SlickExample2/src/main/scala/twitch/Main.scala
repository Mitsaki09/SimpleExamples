package twitch

import slick.jdbc.PostgresProfile.api._
import twitch.dao.TwitchDAOImpl
import twitch.table.Twitch

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {

  val queryRunner = new QueryRunner(Database.forURL(
    url = "jdbc:postgresql://localhost:5432/twitch",
    user = "postgres",
    password = "1234",
    driver = "org.postgresql.Driver"))

  val twitchDAOImpl = new TwitchDAOImpl

  while(true) {
    println("добрый день, мы проведем опрос вашего любимого стримера")
    println("0 = создание табл")
    println("1 = показать всё")
    println("2 = добавить любимого стримера")
    println("3 =  желаете изменить решение по повду его жизин?  ")
    println("4 = поменять колличество ваших донатов ? ")
    println("5 = изменить его нормальность?")
    println("7 = изменить ник")
    println("6 = удалить стримера по id")


    val read = scala.io.StdIn.readInt()
    read match {

      case 0 => println("Вы создали таблицу стримера, которая имеет такие парамметры: " + queryRunner.run(twitchDAOImpl.init))

      case 1 => println(queryRunner.run(twitchDAOImpl.all))

      case 2 => println("введите ник ")
        val readName = scala.io.StdIn.readLine()
        println("введите сколько на твитче")
        val readInt = scala.io.StdIn.readInt()
        println("введите сколько вы ему донатили")
        val readInt2 = scala.io.StdIn.readInt()
        println("он нормальный?true/false")
        val readBol = scala.io.StdIn.readBoolean()
        println("убить его?true/false")
        val readBol2 = scala.io.StdIn.readBoolean()
        val twitch = Twitch(None, readName, readInt, readInt2, readBol, readBol2)
        queryRunner.run(twitchDAOImpl.create(twitch))
        println("Вы создали такого гавнотвитчера : " + queryRunner.run(twitchDAOImpl.create(twitch)))
      case 3 => println("введите будет ли он жить ")
        val readBol2 = scala.io.StdIn.readBoolean()
        println("введите id стримера")
        val readInt = scala.io.StdIn.readInt()
        queryRunner.run(twitchDAOImpl.killTwitch(readBol2, readInt))
        println(s"вы решили что стример под Id $readInt $readBol2 будет ")
      case 4 =>println("введите новый донат ")
        val readBol2 = scala.io.StdIn.readInt()
        println("введите id стримера")
        val readInt = scala.io.StdIn.readInt()
        queryRunner.run(twitchDAOImpl.donationsTwitch(readBol2, readInt))
        println(s"вы поменяли донаты стримера под Id $readInt на  $readBol2  ")
      case 5 => println("введите нормальный он или нет true false  ")
        val readBol2 = scala.io.StdIn.readBoolean()
        println("введите id стримера")
        val readInt = scala.io.StdIn.readInt()
        queryRunner.run(twitchDAOImpl.normalTwitch(readBol2, readInt))
        println(s"вы поменяли нормальность стримера под Id $readInt на  $readBol2  ")

      case 6 => println("введите id")
        val readId = scala.io.StdIn.readInt()
        queryRunner.run(twitchDAOImpl.dltById(readId))
        println(s"вы удалили по id $readId")
case 7 => println("введите новое  имя ")
  val readrName = scala.io.StdIn.readLine()
  println("введите id врача")
  val readInt = scala.io.StdIn.readInt()
  queryRunner.run(twitchDAOImpl.twitchNickName(readrName,readInt))
  println(s"вы поменяли имя стримера на $readrName")

  case _ => println("не понял")
    }

  }
}