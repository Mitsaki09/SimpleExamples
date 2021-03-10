import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
object AgeFutureExample extends App{


    def a: Future[Int] =  {
      println("введите возраст ")
      val age: Int = scala.io.StdIn.readInt()
      if (age >= 0) {
        Future.successful(age)
      } else {
        Future.failed(new Exception("no"))
      }
    }
    val result: Int = Await.result(a,Duration.Inf)
    println(result)

}
