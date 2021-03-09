object GameExample extends App {

  val baseHp: Int = 100
  val baseLvl: Int = 15
  val baseDmg: Int = 150


  abstract class Person(hp: Int = baseHp, lvl: Int = baseLvl, dmg: Int = baseDmg) {
    def gethp: Int = {
      hp}
    def getlvl: Int = {
      lvl}
    def getdmg: Int = {
      dmg}
  }
  abstract class Npc(hp: Int, lvl: Int, dmg: Int) extends Person(hp, lvl, dmg)
  abstract class Goblin(hp: Int = 60, lvl: Int = 6, dmg: Int = 15) extends Npc(hp, lvl, dmg)
  class AngryGoblin() extends Goblin()
  class LowGoblin() extends Goblin()
  class BigGoblin(hp: Int = 180, lvl: Int = 13, dmg: Int = 145) extends Goblin(hp, lvl, dmg) {


  }

  abstract class Elf(hp: Int = 40, lvl: Int = 8, dmg: Int = 18) extends Npc(hp, lvl, dmg)
  class AngryElf() extends Goblin()
  class LowElf() extends Goblin()
  class BigElf(hp: Int = 120, lvl: Int = 8, dmg: Int = 130) extends Goblin(hp, lvl, dmg)

  abstract class Pig(hp: Int, lvl: Int, dmg: Int) extends Npc(hp, lvl, dmg)
  class AngryPig() extends Goblin()
  class LowPig() extends Goblin()
  class BigPig(hp: Int = 121, lvl: Int = 4, dmg: Int = 320) extends Goblin(hp, lvl, dmg)


  class Player(hp: Int = baseHp * 2, lvl: Int = baseLvl - 20, dmg: Int = baseDmg + 20) extends Person(hp, lvl, dmg)


  object Spawn {
    def createGoblin1: AngryGoblin = new AngryGoblin()
    def createGoblin2: LowGoblin = new LowGoblin()
    def createGoblin3: BigGoblin = new BigGoblin()
    def createElf1: AngryElf = new AngryElf()
    def createElf2: LowElf = new LowElf()
    def createElf3: BigElf = new BigElf()
    def createPig1: AngryPig = new AngryPig()
    def createPig2: LowPig = new LowPig()
    def createPig3: BigPig = new BigPig()
    def player: Player = new Player()

  }


  val angryGoblin: AngryGoblin = Spawn.createGoblin1
  val lowGoblin: LowGoblin = Spawn.createGoblin2
  val bigGoblin: BigGoblin = Spawn.createGoblin3

  val angryElf: AngryElf = Spawn.createElf1
  val lowElf: LowElf = Spawn.createElf2
  val bigElf: BigElf = Spawn.createElf3

  val angryPig: AngryPig = Spawn.createPig1
  val lowPig: LowPig = Spawn.createPig2
  val bigPig: BigPig = Spawn.createPig3

  val player: Player = Spawn.player

  println(Console.WHITE+ " =======")
  println(Console.BLUE + " ======")
  println(Console.RED + " =====")

  println("сражаемся с гоблином?")
  val isGoblin: String = scala.io.StdIn.readLine
  isGoblin match {
    case "Да" =>
      println("с каким? - AngryGoblin,LowGoblin,BigGoblin")

      val gublinType: String = scala.io.StdIn.readLine
      gublinType match {
        case "AngryGoblin" =>

          if (player.getdmg >= angryGoblin.getdmg) {
            println("победил Player")
          } else {
            println("победил AngryGoblin")
          }

        case "LowGoblin" =>
          if (player.getdmg >= lowGoblin.getdmg) {
            println("победил Player")
          } else {
            println("победил lowGoblin")
          }

        case "BigGoblin" =>
          if (player.getdmg >= bigGoblin.getdmg) {
            println("победил Player")
          } else {
            println("победил BigGoblin")
          }
      }
    case _ =>

  }
  println("сражаемся с Elf?")
  val isElf: String = scala.io.StdIn.readLine
  isElf match {
    case "Да" =>
      println("с каким? - AngryElf,LowElf,BigElf")

      val ElfType: String = scala.io.StdIn.readLine
      ElfType match {
        case "AngryElf" =>

          if (player.getdmg >= angryElf.getdmg) {
            println("победил Player")
          } else {
            println("победил AngryElf")
          }

        case "LowElf" =>
          if (player.getdmg >= lowElf.getdmg) {
            println("победил Player")
          } else {
            println("победил lowElf")
          }

        case "BigElf" =>
          if (player.getdmg >= bigElf.getdmg) {
            println("победил Player")
          } else {
            println("победил BigElf")
          }
        case _ =>


      }
      println("сражаемся с Pig?")
      val isPig: String = scala.io.StdIn.readLine
      isPig match {
        case "Да" =>
          println("с каким? - AngryPig,LowPig,BigPig")

          val PigType: String = scala.io.StdIn.readLine
          PigType match {
            case "AngryPig" =>

              if (player.getdmg >= angryPig.getdmg) {
                println("победил Player")
              } else {
                println("победил AngryPig")
              }

            case "LowElf" =>
              if (player.getdmg >= lowPig.getdmg) {
                println("победил Player")
              } else {
                println("победил lowPig")
              }

            case "BigPig" =>
              if (player.getdmg >= bigPig.getdmg) {
                println("победил Player")
              } else {
                println("победил BigPig")
              }
          }
      }
  }

}