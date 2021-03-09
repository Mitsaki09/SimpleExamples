package TankExp

case class Tank(shells: Int, damage: Int) {
  def printTank(): Unit = {
    println(shells, damage)
  }

}
