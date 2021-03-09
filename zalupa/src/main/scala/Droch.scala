object Droch extends App {


  class Car(val colour: String, val brand: String, val kg: Int, val armchair: Int, val window: Int)

  val car = new Car("blaci", "bme", 2009, 8, 6)
  val car2 = new Car("black", "bmq", 2008, 4, 2)
  val car3 = new Car("blact", "bmw", 2007, 7, 1)


  class airplane(val colour: String, val brand: String, val engine: Int, val armchair: Int, val window: Int)

  val airplane = new airplane("pink", "samoletik", 2, 1873, 135315)
  val airplane2 = new airplane("black", "hz", 23, 352, 35253153)
  val airplane3 = new airplane("blue", "da", 27, 6262, 6525235)


  class human(val colour: String, val hair: String, val kg: Int, val boobs: Int, val dick: Int)

  val human = new human("black", "long", 209, 2, 4)
  val human2 = new human("white", "short", 20, 2, 65)
  val human3 = new human("blue", "none", 45, 65, 673)


  class computer(val monitor: Int ,val mouse: Int, val power: Int, val klava: Char ,val dick: Boolean )

  val computer = new computer ( 2,1,525,1,true )
  val computer2 = new computer ( 4,0,4141,2,false)
  val computer3 = new computer ( 6,2,626,5,true )


  sealed class vkus
  case object sweet extends vkus
  case object bitter extends vkus

  class fruit(val name: String,val drec: vkus , val size: Int , val dick : Boolean, val quantity: Int )

  val fruit = new fruit ("apple",drec = sweet ,4, false, 25 )
  val fruit2 = new fruit("pear", drec = bitter,7,false,81  )
  val fruit3 = new fruit("Pines",drec = sweet , 9, true, 75)


  class game(val size:Int, val genre:String , val price:Int, val weight:String, val complexity: Int )

  val game = new game(141,"shooter",135,"yes", 13515 )
  val game2 = new game(15,"shooter" ,73573,"no" ,245)
  val game3 = new game( 91857,"sims",246,"dfdg",62462)

  class GeometricFigure( val coal: Int,val name:String, val size: Int ,val circle: String , val complexity: Int )
  val GeometricFigure = new GeometricFigure(23,"da",24,"no",42)
  val GeometricFigure2 = new GeometricFigure( 24,"gr",421,"no",23435)
  val GeometricFigure3 = new GeometricFigure( 2346,"wekfj",213,"yes",14)




  sealed class sotrudnik
  case object smart extends sotrudnik
  case object stupid extends sotrudnik


  sealed class sotrudnik2
  case object programmer extends sotrudnik2
  case object woman extends sotrudnik2

  class Employee(val old: Boolean, val smart: sotrudnik, val gender:Char , val sphere: sotrudnik2,val long: Short )
  val Employee = new Employee(true,  smart,'w',woman, 150)
  val Employee2 = new Employee(false,stupid,'w', woman, 235)
  val Employee3 = new Employee(true, smart,'m',programmer,35)


  sealed class doctora
  case object have extends doctora
  case object dont extends doctora

  sealed class console2
  case object yes extends console2
  case object  no extends console2


  class doctor ( val age : Int, val working : Boolean, val gender: Char , val goodDoctor: Boolean, val children: doctora )
  val doctor = new doctor (14, true, 'w', true, have)
  val doctor2 = new doctor ( 60,false,'m',true,dont)
  val doctor3 = new doctor ( 98, true, 'm', true ,have )

  class Console( val `type`: String , val color:String , val size: Int, val brand: String , val dick: console2 )
  val console = new Console ("switch", "black" , 25, "nintendo", no )
  val console2 = new Console ("playStation", "white", 34, "sony", yes)
  val consile3 = new Console ( "gameBoy ", "blue", 42, "pines", no)


  class dress ( val size : Int , val color: String,  val price : Double, val material: String , val brand: String)
  val dress = new dress ( 24, "black", 22.3, "da", "net")
  val dress1 = new dress (12, "white",22.6, "dgt","gew")
  val dress3 = new dress ( 25, "blue", 98.3, "hf", "yhfg")


  class home (mydress: dress,val size: Int , val color: String , val price: Int, val material: String, val brand: String)

  val home = new home ( dress, 134, "black", 3241,"est", "wegt")
  val home2= new home  ( dress, 2141,"white", 134, "gf", "grkhjes")
  val home3 = new home (dress,  2134, "her", 1541,"gmn","пвк")






  while(true){

    println("da/net")

    val vapros: String = scala.io.StdIn.readLine()
    if (vapros == "da") {

      println("vu vveli da, nazovi imia - ")
      val name: String = scala.io.StdIn.readLine()
      println(s"vashe imia $name")

    } else {



    }

}














  







}
