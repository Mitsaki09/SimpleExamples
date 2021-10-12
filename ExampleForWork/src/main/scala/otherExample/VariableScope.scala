package otherExample

object VariableScope extends App {

  // поля класса доступны только в середине класса
  // scope name - это только его класс

  class Test(name: String) {
    def getName = {
      name
    }
  }

  val test = new Test("John")

  test.getName


  // переменные, созданные внутри метода есть только в методе
  // когда метод отработает, то все переменные внутри него пропадут.
  // Нужно вернуть все переменные, которые хочеться исп. в дальнейшем
  // scope temp - это только его метод

  def foo: Unit = {
    val temp = 15 // значение temp пропадет после работы метода
    println("foo")
  }




  //new braces - new scope; after leaving it's scope variable defined in it's scope is no longer accessible
  {
    val str: String = ""
  }
  {
    val str: String = ""
  }


}
