package factorailExample

object Factorial1 extends App {

  def factorialRecursion(n: Int): Long = // обычная рекурсия
    if (n == 0) 1
    else n * factorialRecursion(n - 1)


  println(factorialRecursion(3))


  def factorialTailRecursion(n: Int, acc: Int = 1): Long = { // хвостовая рекурсия
    if (n == 0) acc
    else factorialTailRecursion(n - 1, n * acc)
  }

  println(factorialTailRecursion(3))
}



trait SelfTypeExample {
  this: {
    def iWontThisMethod(in: String): String
  } =>

  def someMethod: Unit = println("hi")
}

trait WithMethod {
  def iWontThisMethod(in: String): String = in
}

// class A() extends SelfTypeExample  будет ошибка, так как нету метода iWontThisMethod
class AB() extends SelfTypeExample with WithMethod

/*
В блоке this {} => мы требуем, что бы хоть у кого-то был этот
метод.  Если мы требуем чтобы метод был и без него
программа не работает, значит мы можем безопасно вызывать
этот метод. Выходит что в SelfTypeExample мы можем вызвать
метод iWontThisMethod, даже при том что его еще нет но мы
знаем что будет*/
