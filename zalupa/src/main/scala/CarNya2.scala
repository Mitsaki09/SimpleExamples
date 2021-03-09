object CarNya2 extends App{

  class CarPart(val name: String)

  class Car(CarPart1: CarPart, CarPart2: CarPart, CarPart3: CarPart, CarPart4: CarPart, val color: String) {

    def printCarPart1: Unit = {

      println(CarPart1.name + color)


    }

    def printCarPartWithColor(newColor: Boolean): Unit = {

      println(CarPart1.name + newColor)

    }

    def checkColor(сolorForCheck: String): Unit = {

      if (color == сolorForCheck) {
        println("сходится")

      } else {

        println("не сходится")
      }

    }


  }
    val Dvigatel = new CarPart("двигатель")
    val Okna = new CarPart("окна")
    val Dveri = new CarPart("двери")
    val Kolesa = new CarPart("колёса")


    val Car1 = new Car(Dvigatel, Okna, Dveri, Kolesa, "yellow")
    val Car2 = new Car(Dvigatel, Okna, Dveri, Kolesa, "blue")


  Car1.checkColor("yellow")
  Car2.checkColor("green")


  Car1.printCarPart1
   Car2.printCarPart1


  }
