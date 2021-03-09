package TankExp

object Cont{
implicit class ImpTank(tank: Tank) {
  def sumDMG: Int = {
    tank.damage * tank.shells
  }
}
  }

