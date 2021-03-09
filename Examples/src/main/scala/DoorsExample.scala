object DoorsExample extends App {


  class Door(glass: String, material: String, color: String, size: String) {


    def getglass: String = {

      glass


    }

    def getmaterials: String = {


      material
    }

    def getcolor: String = {


      color

    }

    def getsize: String = {

      size

    }

  }

  class DoorFactory {

    def createDoor: Door = {


      println("витраж?(оставьте пустую строку если ничего")
      val Vitraj: String = scala.io.StdIn.readLine

      println("материал ")
      val Material: String = scala.io.StdIn.readLine

      println("цвет ")
      val Color: String = scala.io.StdIn.readLine

      println("размер ")
      val Size: String = scala.io.StdIn.readLine()

      val dooooor = new Door(Vitraj, Material, Color, Size)
      dooooor
    }

  }
    val doorFactory = new DoorFactory()
    val door1: Door = doorFactory.createDoor
    val door2: Door = doorFactory.createDoor
    val door3: Door = doorFactory.createDoor

println(door1)

}

