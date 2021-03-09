
object Telefon extends App {


  abstract class Telephone(val name: String, val number: Short, val price: Double)

  class KnopTelephone(name: String, number: Short, price: Double) extends Telephone(name, number, price)

  class Nokia(name: String, number: Short, price: Double) extends KnopTelephone(name, number, price)

  class Siemens(name: String, number: Short, price: Double) extends KnopTelephone(name, number, price)


  class Smartphone(name: String, number: Short, price: Double) extends Telephone(name, number, price)

  class Samsung(name: String, number: Short, price: Double) extends Smartphone(name, number, price)

  class Xiaomi(name: String, number: Short, price: Double) extends Smartphone(name, number, price)


  class Store(telephone1: Telephone, telephone2: Telephone, telephone3: Telephone, telephone4: Telephone) {


    def allPrice: Unit = {
      println(telephone1.price+telephone2.price+telephone3.price+telephone4.price)


    }
  }

    val nokia = new Nokia("НОКИА", 137, 500)
    val samsung = new Samsung("САМСУНГ", 12, 12000)
    val xiaomi = new Xiaomi("КСЯОМИ", 14, 14141)
    val siemens = new Siemens("СИМЕНС", 167, 1265)


    val store = new Store(nokia,samsung,xiaomi,siemens)


  store.allPrice




  }

