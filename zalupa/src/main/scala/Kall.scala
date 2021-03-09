object Kall extends App {

  class Kall {

    def plus(a:Int, b:Int): Unit = {
      val plusChisel:Int = a + b
      println("plusChisel = " + plusChisel)
    }

    def minus(a:Int, b:Int): Unit = {
      val minusChisel:Int = a - b
      println("minusChisel = " + minusChisel)
    }

    def dilenie(a:Int , b:Int): Unit = {
      val dilenieChisel: Int = a / b
      println("dilenieChisel = " + dilenieChisel)
    }

    def multiply(a:Int, b:Int): Unit={
      val multiplyChisel: Int = a * b
      println("dmultiplyChisel = " + multiplyChisel)
    }

  }
val dilenieChisel = new Kall
  dilenieChisel.dilenie(100,5)
  dilenieChisel.dilenie(90,5)
  dilenieChisel.multiply(90,5)



}