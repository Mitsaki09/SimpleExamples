object ImpDefExamples extends App {

  case class Fly(name: String)
  case class Elephant(name: String, horns: Boolean)

  def getElephant(elephant: Elephant): Unit = {
    println(elephant.name + elephant.horns)
  }

  implicit def GetElephantAndFly(fly: Fly): Elephant = {
    Elephant(fly.name, false)
  }

  val fly = Fly("Муха")
  val elephant = Elephant("слон", true)

  getElephant(fly)
}
