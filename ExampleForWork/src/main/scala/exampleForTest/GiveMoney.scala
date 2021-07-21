package exampleForTest

class GiveMoney {

  def isReadyForMoney(name: String): Boolean = {
    name match {
      case "Jojo" => true
      case "Sakura" => true
      case _ => false
    }
  }

  def getDmgToHero(heroHp: Int, dmgs: Seq[Int]): Int = {
    dmgs.foldLeft(heroHp) {
      (currentHp, nextDmg) =>
      currentHp - nextDmg
    }
  }

  def getDmgToAliveHero(heroHp: Int, dmgs: Seq[Int]): Int = {
    if (heroHp <= 0 ) {
      heroHp
    } else {
      dmgs.foldLeft(heroHp) { (currentHp, nextDmg) =>
        currentHp - nextDmg
      }
    }
  }

}
