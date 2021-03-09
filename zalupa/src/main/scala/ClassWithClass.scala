object ClassWithClass extends App {

  class Gun(val gunName: String, val price: Short)
  class Pistol(val pistolName: String, val price: Short)
  class Grenade(val `type`: String, val price: Short)

  class Zakup(val gun: Gun, val pistol: Pistol, val grenade: Grenade)

  val mp7 = new Gun("мп7", 1500)
  val ak_47 = new Gun("ak 47", 2700)
  val m4 = new Gun("m4", 3100)

  val usp = new Pistol("usp", 200 )
  val p250 = new Pistol("p250", 300 )
  val deagle = new Pistol("deagle or desert", 700)

  val smoke = new Grenade("smoke", 300)
  val molly = new Grenade("molly", 400)
  val decoy = new Grenade("decoy", 50)



  val myZakupRound1 = new Zakup(mp7, p250, smoke)

  println("основная пушка " + myZakupRound1.gun.gunName)
  println("пистолет " + myZakupRound1.pistol.pistolName)
  println("граната " + myZakupRound1.grenade.`type`)


  val sumZakup1: Int = myZakupRound1.gun.price + myZakupRound1.pistol.price + myZakupRound1.grenade.price
  println(sumZakup1)



  val myZakupRound2 = new Zakup(ak_47, deagle, decoy)


  class Game(val zakup1: Zakup, val zakup2: Zakup)


  val ourGame = new Game(myZakupRound1,myZakupRound2)


}
