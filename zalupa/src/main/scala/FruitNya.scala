object FruitNya extends App {

  sealed class Taste1

  case object bitter extends Taste1

  case object sweet extends Taste1

  sealed class Size1

  case object big extends Size1

  case object little extends Size1

  // abstract говорит нам, что мы не можем создавать Fruit и должны исп. его только как родителя для других классов при помощи слова extends
  abstract class Fruit(val taste: Taste1, val price: Double, val color: String)

  class Apple(taste: Taste1, price: Double, color: String) extends Fruit(taste, price, color)

  class Banana(taste: Taste1, price: Double, color: String, val size: Size1) extends Fruit(taste, price, color)


  val RedApple = new Apple(sweet, 13, "red")
  val GreenApple = new Apple(sweet, 42, "green")


  val LittleBanana = new Banana(sweet, 14, "yellow", little)
  val BigBanana = new Banana(bitter, 12, "black", big)




}
