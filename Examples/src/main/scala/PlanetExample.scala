object PlanetExample extends App{
  abstract class Eco (weight:Int) {
    def getWeight: Int = {
      weight}

  }
  abstract class Planet(weight:Int)extends Eco(weight)
  class Earth(weight:Int) extends Planet(weight)
  class Venus(weight:Int) extends Planet(weight)
  class Jupiter(weight:Int) extends Planet(weight)
  class Saturn(weight:Int) extends Planet(weight)

abstract class Star(weight:Int) extends Eco(weight)
  class Sun(weight:Int) extends Star(weight)
  class Fekda(weight:Int) extends Star(weight)
  class Oruspugugu(weight:Int) extends Star(weight)
  class Nya(weight:Int) extends Star(weight)

object spawnall{
  def createEarth: Earth = new Earth(372637)
  def createVenus: Venus = new Venus(1661)
  def createJupiter: Jupiter = new Jupiter(1515)
  def createSaturn: Saturn = new Saturn(6153513)
}



val earth = spawnall.createEarth
val venus = spawnall.createVenus
val jupiter = spawnall.createJupiter
val saturn = spawnall.createSaturn

  def getPlanet(earthStr:String):Planet={
earthStr match{
  case "Earth" => earth
  case "Venus"=>venus
  case "Jupiter"=>jupiter
  case "Saturn"=>saturn
}
  }

  def allSum(planet:Planet,planet2:Planet):Int={
    planet.getWeight+planet2.getWeight}

try {
  println("какую планету сранивать будем? - Earth,Venus,Jupiter,Saturn,Sun,Fekda,Oruspugugu,Nya")

  val questionFirstPlanet: String = scala.io.StdIn.readLine()

  val spisok: Seq[String] = Seq("Earth", "Venus", "Jupiter", "Saturn")


  if (spisok.contains(questionFirstPlanet)){
    println("с какой?")
    val questionSecondPlanet: String = scala.io.StdIn.readLine()
    if(spisok.contains(questionSecondPlanet)) {
      val planet: Planet = getPlanet(questionFirstPlanet)
      val planet2: Planet = getPlanet(questionSecondPlanet)
      println(allSum(planet, planet2))
    }else{throw new Exception}



  }else{throw new Exception}






}
}
