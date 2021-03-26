import ForComprehansion.try1

import scala.util.{Failure, Success, Try}
object ForComprehansion extends App {

  // у нас есть опциональное имя
  val nameOpt: Option[String] = Some("Amina")

  // мы хотим всделать имя капсом, если имени нет то оставляем None

  // вот так можем сделать по старому, через матч
  val nameOptCAPSWithMatch: Option[String] =
    nameOpt match {
      case Some(name) => Some(name.toUpperCase)
      case None => None
    }

  // вот так можем сделать по новому, через мап
  val nameOptCAPSWithMap: Option[String] = nameOpt.map(name => name.toUpperCase)

  // вот эта штука .map(name => name.toUpperCase) это как будто автоматически сгенерированый одноразовый метод
  // def temp(name: String): String = name.toUpperCase

  // синтаксический сахар, нужен только для более красивого вида. Тоже самое что и с мап
  val nameOptCAPSWithFor: Option[String] =
    for {
      name <- nameOpt
    } yield name.toUpperCase


  //---------------------------------------------------------------------------------------------------------------
  // у нас есть не только имя, а и возраст. Оба опциональные.

  val newNameOpt: Option[String] = Some("Amina")
  val agwOpt: Option[Int] = Some(18)

  // если есть имя и возраст то склеиваем в строку, если чего нет то это None

  val namePlusAgeMatch: Option[String] = newNameOpt match {
    case Some(name) =>
      agwOpt match {
        case Some(age) =>
          // вариант что нам нужен
          Some(name + " " + age)
        case None => None
      }
    case None => None
  }

  val namePlusAgeFlatMap: Option[String] = newNameOpt.flatMap(name => agwOpt.map(age => name + " " + age))

  val namePlusAgeFor: Option[String] =




    
    for {
      name <- newNameOpt
      age <- agwOpt
    } yield name + " " + age



  //---------------------------------------------------------------------------------------------------------------

  val try1: Try[Int] = ???
  val try2: Try[Int] = ???
  val try3: Try[Int] = ???
  val try4: Try[Int] = ???

  val tryResultMatch: Try[Int] = try1 match {
    case Success(a1) =>
      try2 match {
        case Success(a2)=>
          try3 match {
            case Success(a3)=>
              try4 match {
                case Success(a4) => Success(a1+a2+a3+a4)
                case Failure(e4) => Failure(e4)
              }
            case Failure(e3) => Failure(e3)
          }
        case Failure(e2) => Failure(e2)
      }
    case Failure(e) => Failure(e)
  }

  val SumFor: Try[Int] = for {
    a1<-try1
    a2<-try2
    a3<-try3
    a4<-try4

  }yield (a1+a2+a3+a4)


  val SumFor2: Try[Int] = try1.flatMap(a1 => try2.flatMap(a2 => try3.flatMap(a3 => try4.map(a4 => (a1 + a2 + a3 + a4)))))


  val Either1: Either[Int,Int] = ???
  val Either2: Either[Int,Int] = ???
  val Either3: Either[Int,Int] = ???
  val Either4: Either[Int,Int] = ???

  val tryResultMatch2: Either[Int,Int] = try1 match {
    case Left(a11) =>
      Either1 match {
        case Left(a22)=>
          Either2 match {
            case Left(a33)=>
              Either3 match {
                case Left(a44) => Left(a11+a22+a33+a44)
                case Right(e44) => Right(e44)
              }
            case Right(e33) => Right(e33)
          }
        case Right(e22) => Right(e22)
      }
    case Right(ee) => Right(ee)
  }

  val
  SumFor2: Either[Int] = for {
    a1<-Either1
    a2<-Either2
    a3<-Either3
    a4<-Either4

  }yield (a1+a2+a3+a4)


  val SumFor2: Either[Int,Int] = try1.flatMap(a1 => try2.flatMap(a2 => try3.flatMap(a3 => try4.map(a4 => (a1 + a2 + a3 + a4)))))

}
