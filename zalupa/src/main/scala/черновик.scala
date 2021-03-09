class черновик {

  class A(val name: String)

  val myA = new A("stroka u A")

  println(myA.name)

}


object HzChto extends App {


  sealed class IsHave1

  case object yes extends IsHave1

  case object no extends IsHave1


  sealed class size1

  case object big extends size1

  case object low extends size1

  class Materinka(val price: Int, val isHave: IsHave1, val size: size1)

  class HardDisc(val price: Int, val isHave: IsHave1, val size: size1)

  class Proccesor(val price: Int, val isHave: IsHave1, val size: size1)


  class Pk(val materinka: Materinka, val harddisc: HardDisc, val proccesor: Proccesor)

  val materinka = new Materinka(12, yes, big)
  val hardDisc = new HardDisc(2134, no, low)
  val proccesor = new Proccesor(134, yes, big)


  val onePk = new Pk(materinka, hardDisc, proccesor)

  val pk2 = new Pk(materinka, hardDisc, proccesor)







  println("suma" + (onePk.materinka.price + onePk.harddisc.price + onePk.proccesor.price))

  println("сумма процессора" + (onePk.proccesor.price + pk2.proccesor.price))


}


