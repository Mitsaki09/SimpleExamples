object Human1 extends App {


  abstract class BodyPart(val price: Float)

  class Hand(val price: Float)

  class Leg(val price: Float)

  class Torso(val price: Float)

  class Head(val price: Float)

  class Human(LeftHand: Hand, RightHand: Hand, LeftLeg: Leg, RightLeg: Leg, Torso: Torso, Head: Head) {

    def sum: Float = { // тип результата работы метода это тип того, что стоит на посл. строчке. Тут это число - сумма сложения
      (LeftHand.price + RightHand.price + LeftLeg.price + RightLeg.price + Torso.price + Head.price)
    }
    def sumWithPrint: Unit = { // тип результата работы метода это тип того, что стоит на посл. строчке.
      // Тут это пустота - потому что результат работы println - это тип пустота.
     println( (LeftHand.price + RightHand.price + LeftLeg.price + RightLeg.price + Torso.price + Head.price))
    }

    // def sum - только считает сумму и ничего не печатает в консоль. Зачем это нужно? Мы можем просуммировать сумму сумм у двух и более экземпляров
    // например val summaObshaia: Float = Marina.sum + Diana.sum
    // и уже потом напечатать summaObshaia или провести другие действия.


    // def sumWithPrint- считает сумму и печатает консоль.
    // Когда мы возвращаем Unit, означает что мы уже ничего не можем сделать с результатом метода - потому что получили пустоту

  }


  val LeftHand = new Hand(12)
  val RightHand = new Hand(12)
  val LeftLeg = new Leg(16)
  val RightLeg = new Leg(16)
  val Torso = new Torso(20)
  val Head = new Head(90)
  val Head2 = new Head(1)


  val Marina = new Human (LeftHand,RightHand,LeftLeg,RightLeg,Torso,Head)

  println(Marina.sum)//можно ещё и так , вариант 1
  Marina.sumWithPrint//можно ещё и так , вариант 2

  val Diana = new Human (LeftHand,RightHand,LeftLeg,RightLeg,Torso,Head2)

  println(Diana.sum)//можно ещё и так , вариант 1
  Diana.sumWithPrint//можно ещё и так , вариант 2
}
