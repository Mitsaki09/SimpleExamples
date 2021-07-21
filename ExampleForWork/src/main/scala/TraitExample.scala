object TraitExample extends App {
// trait - это как класс, без полей. trait используют для того, чтобы наследники могли брать метод от него.




  // trait - метод можно сделать полем
  trait MethodAsVal {
    def id: Long
  }



  class MethodAsValImpl extends MethodAsVal {
    override def id: Long = ??? // тут id это метод
  }
  class MethodAsValImpl2(val id: Long) extends MethodAsVal // а тут id превратили в поле, просто пример того, как мы можем сделать из метода поле




  // вместо того, чтобы писать class как на 14 строке, мы можем создать переменную и написать что она равняетсся trait
  val methodAsVal = new MethodAsVal {
    override def id: Long = ???
  }




  // self-type
  trait SelfTypeExampleWithMethod {
    def sum(a: Int, b: Int): Int
  }

  trait SelfTypeExample {
    this: SelfTypeExampleWithMethod =>   // У нас есть все методы из  этого трейта
    def sum3Numbers(a:Int, b: Int): Int = sum(a, b)
  }

  class SelfTypeExampleImpl extends SelfTypeExample with SelfTypeExampleWithMethod { // если мы используем трейт, внутри которого другой трейт, мы пишем with и название трейта с которым связан первый with
    override def sum(a: Int, b: Int): Int = a + b
  }

  abstract class AbstractSelfTypeExampleImpl extends SelfTypeExample with SelfTypeExampleWithMethod // у всех наследников будут методы sum и sum3Numbers





  // проблема трейта - ромбовидное наследоваение
  trait Sum {
    def doIt(a: Int, b: Int) = a + b
  }

  trait Minus {
    def doIt(a: Int, b: Int) = a - b
  }

  class SumAndMinusImpl extends Sum with Minus {
    override def doIt(a: Int, b: Int) = super[Sum].doIt(a, b)
  }

  val sumAndMinusImpl = new SumAndMinusImpl
  println(sumAndMinusImpl.doIt(5, 15))


/*--------------------------------------------------------------------------------------------------------Example--------------------------------------------------------------------------------------------------------*/


  trait Mujichnost{
    def nasrat:Unit={
      println("Я покакол")
    }
  }
  trait Jenstvinost{
    def orat:Unit={
      println("Ору вообще")
    }
  }

class Gomunkul extends Mujichnost with Jenstvinost {

}
  val gomunkul = new Gomunkul
  gomunkul.nasrat
  gomunkul.orat





  trait HomeAnimal{
    def dmg = 120
  }
  trait Human{
    this:HomeAnimal =>
    def otpizditHomeAnimal(hp:Int):Int = hp - dmg

  }

  class NyaNya extends Human with HomeAnimal {
  }
  val nyaNya = new NyaNya
  nyaNya.otpizditHomeAnimal(310)
}

