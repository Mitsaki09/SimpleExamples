package otherExample

import com.example.SwordMasterServiceProto.HumanRequest

object Proto extends App {
  /*println(Sword("Kz",3,4))
  println(Eat(1,"п","п"))

/*  println(Jopa(Some(Kakashka(150)), "коричневый"))*/
 println(Toilet(Some(Jopa(Some(Kakashka(150)),"ddd")), "коричневый"))

val wheel11 = Wheel(3,4,"Yes")
val wheel22 = Wheel(3,4,"Yes")
val wheel33 = Wheel(3,4,"Yes")
val wheel44 = Wheel(3,4,"Yes")
val cart = Cart(Some(wheel11),Some(wheel22),Some(wheel33),Some(wheel44))
  println(cart)*/
  val human = HumanRequest("Я", 18, 45)

}
