import akka.actor.ActorSystem


object TestExample extends App {
  def kvadrat(in: Double): Double = in * in
  val kvadratFunction: Double => Double = in => in * in


  def method(inFun: Double => Double): Unit = { // Higher order functions/функции высшего порядка
    println(inFun(5))
  }


  Option(5.0).map((v: Double) => v * v) // анонимная функция, потому что нету описания и создания через val
  Option(5.0).map(v => v * v) // анонимная функция, потому что нету описания и создания через val
  Option(5.0).map(kvadratFunction)
}


