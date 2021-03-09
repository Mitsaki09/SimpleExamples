package optionAminia

class Fighter(power: Int, name: String) {
  println("create fighter " + name)

  def strPower: Int = {
    power
  }

  def powerMonster(powerMstr: Option[Int]): String = {
    println("fight")
    powerMstr match {
      case None => "Залупа"
      case Some(mPower) if mPower > power => "Паражение"
      case Some(mPower) if mPower == power => "Ничья"
      case Some(mPower) if mPower < power => "Победа"

    }
  }

}
