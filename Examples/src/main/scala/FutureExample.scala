import java.lang.Thread.currentThread
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

object FutureExample extends App {

  println("Я тут: " + currentThread().getName)

  val resultFuture: Future[Int] = Future {
    println("Я другой: " + currentThread().getName)
    Thread.sleep(3000)
    println("Я другой2: " + currentThread().getName)
    throw new Exception("go to ass")
  }

  println("Я тоже тут " + currentThread().getName)


  resultFuture.onComplete {
    case Success(value) => println("Success" + value)
    case Failure(exception) =>println("Failure" + exception)
  }

  val result: Int = Await.result(resultFuture, Duration.Inf)
  println(result)

  val a: Future[Int] = Future.successful(1)
  val b: Future[Int] = Future.failed(new Exception())
}
//когда создаёшь несколько с Future , то результаты должны быть отдельными , нельзя в один реузльтат помешать два действия


