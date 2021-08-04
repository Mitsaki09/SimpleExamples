object AbstractClassExample extends App{
  //1)Создать абстрактный класс Драчун, поля  dmg. Унаследовать от Драчуна класс Игрок и абстрактныц Класс Моб. 2)  Создать Класс Волк, унаследованный от Моба.
  // Дать ему значения по умолчанию  урон 15.  3) Создать метод, который принимает игрока и моба и сравнивает чей урон больше.
  // Метод возвращает Either. Если урон больше у игрока то это лефт, если у моба - райт.  4)Необходимо признать, что Амина ученый
abstract class Drachun(val dmg:Int)
  class Player(dmg:Int) extends Drachun( dmg:Int)
  val player = new Player(32)
  abstract class Mob (dmg:Int) extends Drachun(dmg:Int)
class Wolf (dmg:Int) extends  Mob( dmg:Int)
  val wolf = new Wolf(15)
  def wolfPlayer( wolf: Wolf, player: Player):Either[Int,Int]={
    if (wolf.dmg >= player.dmg) {

    Left(wolf.dmg)
    }else{
      Right(player.dmg)
    }

  }

}
