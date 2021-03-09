object L2 extends App{
  val forArmor: Int = 20
  val forHp: Int = 20
  val forInt: Int = 14

  abstract class Effect(buffArmor: Int = forArmor,buffHp: Int = forHp,buffInt: Int = forInt ){
    def getBuffArmor:Int={
      buffArmor}
    def getBuffHp:Int={
      buffHp}
    def getBuffInt:Int={
      buffInt}
  }
  class Buff(buffArmor: Int = forArmor+15,buffHp: Int = forHp+2,buffInt: Int = forInt+9) extends Effect(buffArmor,buffHp,buffInt)
  class DeBuff(buffArmor: Int = forArmor-30,buffHp: Int = forHp-30,buffInt: Int = forInt-30) extends Effect(buffArmor,buffHp,buffInt)
  class Player(armor:Int = 12,hp:Int = 50,int: Int = 4){
    def getArmor:Int ={
      armor}
    def getHp:Int ={
      hp}
    def getInt:Int ={
      int}


  }

  object SpawnBuffAndDeBuff {
    def createBuff: Buff = new Buff
    def createDeBuff: DeBuff = new DeBuff
    def createPlayer: Player = new Player


  }

   val player:Player = SpawnBuffAndDeBuff.createPlayer
  val buff: Buff = SpawnBuffAndDeBuff.createBuff
  val deBuff: DeBuff = SpawnBuffAndDeBuff.createDeBuff

  println(player.getArmor+buff.getBuffArmor)
}
