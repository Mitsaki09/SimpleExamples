package optionAminia

object AminyaExample extends App {

  println("start")
  val aminya = new Fighter(124, "Amina")

  println(aminya.powerMonster(Some(124)))
  println(aminya.powerMonster(Some(123)))
  println(aminya.powerMonster(Some(125)))
  println(aminya.powerMonster(None))

  val rodion = new Fighter(12, "Rodion")
  println(rodion.powerMonster(Some(0)))

}
