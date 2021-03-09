object Plant extends App {

  abstract class Plant(val baseWater: Double) {

    def addWater(water: Double): Unit = {
      if (water > baseWater) {
        println("Растение сгнило")


      } else {
        println("Ок")


      }

    }
  }

  class RoomPlant(water: Double) extends Plant(water)

  class WildPlant(water: Double) extends Plant(water)


  val RoomPlant = new RoomPlant(12)
  val WildPlant = new WildPlant(52)

    RoomPlant.addWater(7)
    WildPlant.addWater(31)


}

