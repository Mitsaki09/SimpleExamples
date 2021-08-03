package doctor


import doctor.dao.DoctorDAOImpl
import doctor.tables.Doctor
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App {

  val queryRunner = new QueryRunner(Database.forURL(
    url = "jdbc:postgresql://localhost:5432/doctor",
    user = "postgres",
    password = "1234",
    driver = "org.postgresql.Driver"))

  val doctorDAOImpl = new DoctorDAOImpl

while(true){
  println("введите номер")
  println("0 = создание табл")
  println("1 = показать всё")
  println("2 = добавить доктора")
  println("3 = поменять имя врачу")
  println("4 = поменять возраст врачу")
  println("5 = удалить врача по id")

  val read = scala.io.StdIn.readInt()

  read match {
    case 0 => queryRunner.run(doctorDAOImpl.init)
      println("табл создана")

    case 1 => println(queryRunner.run(doctorDAOImpl.all))

    case 2 => println("введите имя ")
      val readName = scala.io.StdIn.readLine()
      println("введите возраст")
      val readAge = scala.io.StdIn.readInt()
      println("введите направление")
      val readDirection = scala.io.StdIn.readLine()
      val doctor =  Doctor(None,readName,readAge,readDirection)
      queryRunner.run(doctorDAOImpl.create(doctor))
      println(s"вы добавили имя доктора $readName")

    case 3 => println("введите новое  имя ")
      val readrName = scala.io.StdIn.readLine()
      println("введите id врача")
      val readInt = scala.io.StdIn.readInt()
      queryRunner.run(doctorDAOImpl.doctorsName(readrName,readInt))
      println(s"вы поменяли имя врача на $readrName")


    case 4 => println("введите новый возраст ")
      val readAge = scala.io.StdIn.readInt()
      println("введите id врача")
      val readInt = scala.io.StdIn.readInt()
      queryRunner.run(doctorDAOImpl.doctorAge(readAge,readInt))
      println(s"вы поменяли возраст врача на $readAge")


    case 5 => println("введите id")
      val readId = scala.io.StdIn.readInt()
      queryRunner.run(doctorDAOImpl.dltById(readId))
      println(s"вы удалили по id $readId")

    case _ => println("не понял")
  }

}

}
