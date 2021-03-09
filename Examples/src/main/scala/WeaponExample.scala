object WeaponExample extends App {

  object WeaponHaracter {

    def weaponWork(patron: Int, oboima: Int): Int = patron * oboima

    def bolsheornot(pushka1: GunDMG, pushka2: GunDMG): GunDMG = {

      println("Сравниваю " + pushka1.name + " и " + pushka2.name)
      if (pushka1.fullDmg <= pushka2.fullDmg) {
        println(pushka2.name + " болбше")
        pushka2
      } else {
        println(pushka1.name + " болбше")
        pushka1
      }
    }
  }

  class GunDMG(val name: String, val fullDmg: Int)

  val AK47: GunDMG = new GunDMG(name = "AK47", fullDmg = WeaponHaracter.weaponWork(30, 50))
  val M4: GunDMG = new GunDMG(name = "M4", fullDmg = WeaponHaracter.weaponWork(70, 300))
  val NEGEV: GunDMG = new GunDMG(name = "Negev", fullDmg = WeaponHaracter.weaponWork(150, 80))

  val biggerFromAkAndM4:GunDMG = WeaponHaracter.bolsheornot(AK47, M4)
  WeaponHaracter.bolsheornot(biggerFromAkAndM4, NEGEV)

}
