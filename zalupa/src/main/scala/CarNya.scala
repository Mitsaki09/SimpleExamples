object CarNya extends App {

  class CarPart(val name: String)

  class Car(carPart1: CarPart, carPart2: CarPart, carPart3: CarPart, carPart4: CarPart, val color: String) {

    def printCarPart1: Unit = {

      println(carPart1.name + " " + color)


    }


    def printCarPart2: Unit = {
      println(carPart2.name + " " + color)

    }


    def printCarPartWithColor1(newColor: String): Unit = {
      println(carPart1.name + " " + newColor)

    }


    def checkColor(сolorForCheck: String): Unit = {

      val res2: Boolean = сolorForCheck == color
      println(res2)


    }

  }
    val Dvigatel = new CarPart("двигатель")
    val Okna = new CarPart("окна")
    val Dveri = new CarPart("двери")
    val Kolesa = new CarPart("колёса")


    val Car1 = new Car(Dvigatel, Okna, Dveri, Kolesa, "ГОЛУБОЙ")
    val Car2 = new Car(Dvigatel, Okna, Dveri, Kolesa, "синий")


    Car1.printCarPart1
    Car2.printCarPart1

    Car1.printCarPartWithColor1("green")
    Car2.printCarPartWithColor1("blue")


    Car1.checkColor("yellow")
    Car2.checkColor("red")




}
