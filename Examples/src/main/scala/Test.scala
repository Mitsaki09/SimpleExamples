import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
object Test extends App{

  def getName:Future[String] = {
    Thread.sleep(3000)
    println("Name(напиши Валера)")
    val questionName: String = scala.io.StdIn.readLine.toUpperCase()
    if (questionName == "ВАЛЕРА"){
      Future.successful(questionName)
    }else{
      Future.failed(throw new Exception("No"))
    }

  }



def getAge:Future[Int] = {
  Thread.sleep(3000)
  println("Age")
  val questionAge:Int = scala.io.StdIn.readInt()
  if ( questionAge>=0){
    Future.successful(questionAge)
  }else{
    Future.failed(new Exception("NOO") )
  }
}
  // вариант , где не нужно писать Future.successful . Разница в том, что ищет само где что нужно , а в варианте выше я указываю что как и где
  def getAge2:Future[Int] = Future {
    Thread.sleep(3000)
    println("Age")
    val questionAge:Int = scala.io.StdIn.readInt()
    if ( questionAge>=0){
      questionAge
    }else{
      throw new Exception("NOO")
    }
  }

  val result2: String = Await.result(getName,Duration.Inf)
  println(result2)

  val result: Int = Await.result(getAge,Duration.Inf)
  println(result)





}

