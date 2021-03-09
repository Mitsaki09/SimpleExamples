object Tovarchik extends App {

  abstract class Tovar(val name: String, val price: Double, val quantity: Short)

  abstract class ProduktTovar(name: String, price: Double, quantity: Short, val shelFlife: Short) extends Tovar(name, price: Double, quantity: Short)

  abstract class BitTovar(name: String, price: Double, quantity: Short) extends Tovar(name: String, price: Double, quantity: Short)


  class Powder(name: String, price: Double, quantity: Short) extends BitTovar(name, price, quantity)

  class Soap(name: String, price: Double, quantity: Short) extends BitTovar(name: String, price: Double, quantity: Short)

  class Zhumaysynba() extends BitTovar("zalupa", 12, 5)

  class Cheese(name: String, price: Double, quantity: Short, weight: Double, srokGodnosti: Short) extends ProduktTovar(name, price, quantity,srokGodnosti)

  class Meat(name: String, price: Double, quantity: Short, weight: Double,shelFlife: Short) extends ProduktTovar(name: String, price: Double, quantity: Short,shelFlife: Short)

  class Milk(name: String, price: Double, quantity: Short, volume: Double,shelFlife: Short) extends ProduktTovar(name: String, price: Double, quantity: Short,shelFlife: Short)


  val zhumaysynba = new Zhumaysynba()
  zhumaysynba.name
}
