object PSImplicitExample extends App {

//  case class Prefix(p: String)
//  case class Sufix(s: String)
//
// def printRed(str: String)(implicit prefix: Prefix, sufix: Sufix): Unit = {
//   println(Console.RED + prefix.p + str  + sufix.s)
// }
//
//  def printBlue(str: String)(implicit prefix: Prefix, sufix: Sufix): Unit = {
//    println(Console.BLUE + prefix.p + str  + sufix.s)
//  }
//
//  def printYellow(str: String)(implicit prefix: Prefix, sufix: Sufix): Unit = {
//    println(Console.YELLOW + prefix.p + str  + sufix.s)
//  }
//
//
//  implicit val a = Prefix("--->")
//  implicit val b = Sufix("<---")
//
//
//
//  printRed("1")
//  printBlue("1")
//  printYellow("1")


abstract case class Weapon(name:String)
  class Pistol( name:String) extends Weapon(name)
  class Heavy( name:String) extends Weapon(name)
  def spawnPistol(hv:Heavy)(implicit ps:Pistol):Unit={
    println(hv.name+ps.name)}
   val Hw = new Heavy("Heavy")
  implicit val Ps = new  Pistol("Pistol")

  spawnPistol(Hw)
}

