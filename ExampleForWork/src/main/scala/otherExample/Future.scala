import FutureEx1.result

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

object FutureEx1 extends App {

  println(Thread.currentThread().getName())

  implicit val ec = ExecutionContext.global // Биг решала, который захватывает все потоки, которые может
  //import scala.concurrent.ExecutionContext.Implicits.global


  val result: Future[Int] = Future.apply {

    println(Thread.currentThread().getName())
    1 + 1
  }

  //Thread.sleep(1000) // стопаем на секунду главный поток

  result.map { r => // .map сюда поподет результат работы фьючи и если вам нужно что-то сделать с результатом, то делаем это в .map
    println("Фуьюча закончилась")
    println(r)
  }

  //Await.result(result, Duration.Inf)// Блокирующая операция. Блокирует основной поток, пока фьюча не выполниться
  //println(result)


  // --------------------------------------------------------------------------------------------
  // Ошибка, как результат работы фьючи


  val futureError: Future[Int] = Future {
    throw new Exception("Капец")
  }


  futureError.map { r => // .map только для Success(...)
    // никогда не наступит, потому что сюда попадают только успешные результаты
  }
  futureError.recover { e => // для ловли ошибок
    println("ошибка" + e)
  }

  /*  futureError.transform { // ловит ошибки и результат
      case Success(res) =>
      case Failure(exception) =>
    }*/


  futureError.map { r =>
    r + 1
  }.recover { e => // для ловли ошибок
    0
  }


  for { // футурки можно обьединять в for comprehation и получать результаты работы
    v1 <- result
    v2 <- futureError
        } yield v1 + v2


  Thread.sleep(10000)
}

///-------------------------------------------------EXAMPLE-----------------------------------------------------------
object Future2 extends App {
  implicit val ec = ExecutionContext.global

  def exampleFutureWithDef1(number1: Future[Int], number2: Future[Int], number3: Future[Int]): Future[Int] = {
    val a = number1.flatMap(n => number2.flatMap(nn => number3.map(nnn => n + nn + nnn)))
    a
  }

  def exampleFutureWithDef2(number1: Future[Int], number2: Future[Int], number3: Future[Int]): Future[Int] = {
    val sumFor = for {
      n1 <- number1
      n2 <- number2
      n3 <- number3

    } yield n1 + n2 + n3

    println("введите число")
    val readInt = scala.io.StdIn.readInt()
    sumFor.map(sum => sum + readInt)
  }

  // Future - Success - правильно,Failure - неправильно
  // val a:Future[Int] = Success(12),обычно когда мы даём значения переменным мы пишем так , в случае с Future как ниже

  println( Await.result( exampleFutureWithDef2(Future.successful(1), Future.successful(2), Future.successful(3)),Duration.Inf))
}
object Future3 extends App {
  implicit val ec = ExecutionContext.global
  case class Human(timeForLife:Future[Int]){
    val b = timeForLife.map(n=>println(n))

  }
  val human = Human(Future.successful(1))
  Await.result(human.timeForLife,Duration.Inf)
}
object Future4 extends App {
  implicit val ec = ExecutionContext.global
trait MethodWithFuture{
  def timeForLife(time:Future[Int]):Future[Unit]={
    val forTime = for{
      timeF <- time
    }yield println(timeF)
    forTime
  }
}
  class ClassWithTraitAndFuture extends MethodWithFuture{

  }
  val classWithTraitAndFuture = new ClassWithTraitAndFuture
  Await.result(classWithTraitAndFuture.timeForLife(Future.successful(1)),Duration.Inf)
}


object Future5 extends App {
  implicit val ec = ExecutionContext.global
  abstract class AbstractClass ( val life:Future[Int] ,val nacia:String)

  case class Class (life2:Future[Int], nacia2:String, name:String)extends AbstractClass(life2,nacia2)

  val human1 = Class(Future.successful(2),"UA","Dima")

  Await.result(human1.life,Duration.Inf) // мы пишем Await.result(тут мы пишем к какому именно полю типа Future это относится (human1.life)
  println(human1)
}
object Future6 extends App{

}