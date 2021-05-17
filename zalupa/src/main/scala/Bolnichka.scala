object Bolnichka extends App {
  abstract class MedRabotnik(val zarplata:Int)
  class Medsestra(zarplata:Int) extends MedRabotnik(zarplata)

  abstract class Vrach(zarplata:Int) extends MedRabotnik(zarplata)
  class Stomatolog(zarplata:Int) extends Vrach(zarplata)
  class Hirurg(zarplata:Int) extends Vrach(zarplata)
  class Ortoped(zarplata:Int) extends Vrach(zarplata)

  val medsestra = new Medsestra(4000)
  val medsestra2 = new Medsestra(40500)
  val stomatolog = new Stomatolog(12000)
  val hirurg = new Hirurg(20000)
  val ortoped = new Ortoped(12)




class Bolnica(medsestra:Medsestra,medsestra2:Medsestra,stomatolog: Stomatolog,hirurg: Hirurg,ortoped: Ortoped){


  def sumWithPrint1: Float ={

    medsestra.zarplata+medsestra2.zarplata


  }
    def sumWithPrint2: Float ={

stomatolog.zarplata+hirurg.zarplata+ortoped.zarplata

    }

 def sumWithPrint3: Float ={

   medsestra.zarplata+medsestra2.zarplata+stomatolog.zarplata+hirurg.zarplata+ortoped.zarplata

 }
}
val bolnica = new Bolnica(medsestra,medsestra2,stomatolog,hirurg,ortoped)
  println(bolnica.sumWithPrint1)
  println(bolnica.sumWithPrint2)
  println(bolnica.sumWithPrint3)


  def seyHello(name: String): Unit = {
    println("Hello " + name)
  }

  val sayHelllo:String => Unit = name => println("Hello" + name )

}