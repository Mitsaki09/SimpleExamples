package questionAboutYou
import questionAboutYou.dao.QuestionAboutYouDAOImpl
import questionAboutYou.table.QuestionAboutYou
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
object Main extends App {
  val queryRunner = new QueryRunner(Database.forURL(
    url = "jdbc:postgresql://localhost:5432/questionAboutYou",
    user = "postgres",
    password = "1234",
    driver = "org.postgresql.Driver"))
  val questionAboutYouDAOImpl = new QuestionAboutYouDAOImpl

  while(true) {
    println("0 = создание табл")
    println("1 = показать всё")
    println("2 = добавить описание о себе ")
    println("3 =  желаете изменить имя?  ")
    println("4 =  желаете изменить решение про убйства?  ")
    println("5 =  желаете изменить решение про нормальность?Всё осознали?  ")
    println("6 =  желаете изменить решение про просмотр аниме ?  ")
    println("7 =  желаете изменить решение про любовь к Scala?  ")
    println("8 =  желаете изменить решение про возраст?  ")
    println("9 =  желаете изменить решение про игры?  ")
    println("10 =  желаете изменить инфй о себе?  ")
    println("11 = удалить чувака по id ")

    val read = scala.io.StdIn.readInt()
    read match {
      case 0 => println("вы создали таблицу с такими параметрами " + queryRunner.run(questionAboutYouDAOImpl.init))
      case 1=> println( queryRunner.run(questionAboutYouDAOImpl.all))
      case 2 => println("введите имя ")
        val questionName = scala.io.StdIn.readLine().toUpperCase
        questionName match  {
          case "РОДИОН" => println("введите возраст")
            val questionAge = scala.io.StdIn.readInt()
            questionAge match {
              case n if n <= 10  => println("врешь, иди в начало")
              case a if a >= 25 => println("похоже на правду")
                println("любишь ли ты игры?")
                val questionGame = scala.io.StdIn.readBoolean()

                println("считаешь ли ты себя нормальным?")
                val questionNormal= scala.io.StdIn.readBoolean()
                questionNormal match {
                  case true => println("убивал ли ты людей? ")
                    val questionKill = scala.io.StdIn.readBoolean()
                    println("лол")
                    println("ты смотришь аниме?")
                    val questionAnime = scala.io.StdIn.readBoolean()
                    questionAnime match {
                      case true =>println("ты любишь Scala?")
                        val questionScala = scala.io.StdIn.readBoolean()
                        println("напиши пару слов в общем о себе")
                        val questionAboutYou = scala.io.StdIn.readLine().toUpperCase
                        val questionAboutYou1 = QuestionAboutYou(None,questionName, questionAge,questionGame,questionNormal,questionKill,questionAnime,questionScala,questionAboutYou)
                        queryRunner.run(questionAboutYouDAOImpl.create(questionAboutYou1))
                      case false => println("иди в начало , фу")
                    }

                  case false => println("не правда, иди в начало")
                }

              case b if b <= 24 => println("не не, почти, но не то , иди в начало ")
            }

          case "АМИНА" => println("со свинками не работаем")
          case "ДИМА" => println("введите возраст")
            val questionAge2 = scala.io.StdIn.readInt()
            questionAge2 match {
              case n if n <= 10  => println("врешь, иди в начало")
              case a if a >= 30 => println("похоже на правду")

                println("любишь ли ты игры?")

                val questionGame2 = scala.io.StdIn.readBoolean()
                println("считаешь ли ты себя нормальным?")
                val questionNormal2= scala.io.StdIn.readBoolean()
                questionNormal2 match {
                  case true => println("убивал ли ты людей? ")
                    val questionKill2 = scala.io.StdIn.readBoolean()
                    println("лол")
                    println("ты смотришь аниме?")
                    val questionAnime2 = scala.io.StdIn.readBoolean()
                    questionAnime2 match {
                      case true =>println("ты любишь Scala?")
                        val questionScala2 = scala.io.StdIn.readBoolean()
                        println("напиши пару слов в общем о себе")
                        val questionAboutYou2 = scala.io.StdIn.readLine().toUpperCase
                        val questionAboutYou22 = QuestionAboutYou(None,questionName, questionAge2,questionGame2,questionNormal2,questionKill2,questionAnime2,questionScala2,questionAboutYou2)
                        queryRunner.run(questionAboutYouDAOImpl.create(questionAboutYou22))
                      case false => println("иди в начало , фу")
                    }

                  case false => println("не правда, иди в начало")
                }

              case b if b <= 29=> println("не не, почти, но не то , иди в начало ")
            }

        }
      case 3  => println("введите новое  имя ")
        val readrName = scala.io.StdIn.readLine()
        println("введите id чувака")
        val readInt = scala.io.StdIn.readInt()
        queryRunner.run(questionAboutYouDAOImpl.name(readrName,readInt))
        println(s"вы поменяли имя чувака на $readrName")
      case 4 => println("введите новую инфу по убийствам  ")
        val readrKill = scala.io.StdIn.readBoolean()
        println("введите id чувака")
        val readInt = scala.io.StdIn.readInt()
        queryRunner.run(questionAboutYouDAOImpl.kill(readrKill,readInt))
        println(s"вы поменяли решение про убийства на  $readrKill")
      case 5 => println("введите новую инфу про нормальность  ")
        val readrNormal = scala.io.StdIn.readBoolean()
        println("введите id чувака")
        val readInt = scala.io.StdIn.readInt()
        queryRunner.run(questionAboutYouDAOImpl.normal(readrNormal,readInt))
        println(s"вы поменяли решение про нормальность на  $readrNormal")
      case 6 => println("введите новую инфу про аниме ")
        val readAnime = scala.io.StdIn.readBoolean()
        println("введите id чувака")
        val readInt = scala.io.StdIn.readInt()
        queryRunner.run(questionAboutYouDAOImpl.watchAnime(readAnime,readInt))
        println(s"вы поменяли решение про аниме на  $readAnime")
      case 7 => println("введите новую инфу про любовь к Scala   ")
        val readScala = scala.io.StdIn.readBoolean()
        println("введите id чувака")
        val readInt = scala.io.StdIn.readInt()
        queryRunner.run(questionAboutYouDAOImpl.likeScala(readScala,readInt))
        println(s"вы поменяли решение про про любовь к Scala на  $readScala")
      case 8 => println("введите новую инфу про возраст  ")
        val readAge = scala.io.StdIn.readInt()
        println("введите id чувака")
        val readInt = scala.io.StdIn.readInt()
        queryRunner.run(questionAboutYouDAOImpl.age(readAge,readInt))
        println(s"вы поменяли решение про возраст на  $readAge")
      case 9 => println("введите новую инфу про любовь к играм  ")
        val readGame = scala.io.StdIn.readBoolean()
        println("введите id чувака")
        val readInt = scala.io.StdIn.readInt()
        queryRunner.run(questionAboutYouDAOImpl.loveGame(readGame,readInt))
        println(s"вы поменяли решение про игры на  $readGame")
      case 10 => println("введите новую инфу о себе  ")
        val readAbout = scala.io.StdIn.readLine()
        println("введите id чувака")
        val readInt = scala.io.StdIn.readInt()
        queryRunner.run(questionAboutYouDAOImpl.questionAboutYouDef(readAbout,readInt))
        println(s"вы поменяли решение о себе на  $readAbout")

      case 11 =>  println("введите id")
        val readId = scala.io.StdIn.readInt()
        queryRunner.run(questionAboutYouDAOImpl.dltById(readId))
        println(s"вы удалили по id $readId")

      case _ => println("не понял")
    }

  }

}


