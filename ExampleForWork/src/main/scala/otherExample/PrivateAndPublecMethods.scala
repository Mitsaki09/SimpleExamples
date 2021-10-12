package otherExample

object PrivateAndPublecMethods extends App {

  class Math {
    def sum(a: Int, b: Int): Int = sum_Private(a, b)

    private def sum_Private(a: Int, b: Int): Int = a + b // private чисто для этого класса и наследники не могут его использовать

    protected def sum_Protected(a: Int, b: Int): Int = a + b // protected тоже самое что private, только наследники его могут использовать
  }

  val math = new Math

  math.sum(2, 3)
  // math.sum_Private(2, 3) ошибка, нельзя вызывать
  // math.sum_Protected(2, 3) ошибка, нельзя вызывать


  class MathTurbo extends Math

  val mathTurbo = new MathTurbo {
    override def sum(a: Int, b: Int): Int = super.sum(a, b)

    // override def sum_Private(a: Int, b: Int): Int = super.sum_Private(a, b)
    override def sum_Protected(a: Int, b: Int): Int = super.sum_Protected(a, b)
  }

  println(mathTurbo.sum(2, 3))
  // mathTurbo.sum_Private(2, 3)  ошибка, нельзя вызывать
  // mathTurbo.sum_Protected(2, 3)    ошибка, нельзя вызывать


}
