package otherExample

object ImplicitExample extends App {

  //---------ImplicitDef--------- Конвертация из одного типа в другой
  case class Fly(name: String)

  case class Elephant(name: String, horns: Boolean)

  def getElephant(elephant: Elephant): Unit = {
    println(elephant.name + elephant.horns)
  }


  implicit def GetElephantAndFly(fly: Fly): Elephant = {
    Elephant(fly.name, false)
  }

  val fly = Fly("Муха  ")
  val elephant = Elephant("слон", true)

  getElephant(fly)

  //---------ImplicitVal--------- Неявная передача параметров

  case class Plain(model: String)

  case class FlyingPastaMonster(name: String)

  trait FlyHelper[T] {
    def support(t: T): String
  }

  implicit val plainFlyHelp = new FlyHelper[Plain] {
    override def support(plain: Plain): String = s"some science for plain: ${plain.model}"
  }

  //---------ImplicitClass--------- Добавляет метод в класс


  implicit class IntWithTimes(x: Int) {
    def times[A](f: => A): Unit = {
      def loop(current: Int): Unit =
        if (current > 0) {
          f
          loop(current - 1)
        }

      loop(x)
    }
  }


  case class Beer(foam: Boolean)

  implicit val beer = Beer(true)

  case class Alcoholic(teeth: Boolean, beer: Beer)

  def createAlcoholic(teeth: Boolean)(implicit beer: Beer) = s"teeth Alcoholic is $teeth and foam Beer is $beer "

  println(createAlcoholic(true)(beer)) //явная передача
  println(createAlcoholic(true)) // неявная передача


  case class Engineer(teeth: Boolean)

  def getEngineer(engineer: Engineer): Unit = {
    println(engineer.teeth)
  }

  implicit def GetEngineerAndAlcoholic(alcoholic: Alcoholic): Engineer = {
    Engineer(alcoholic.teeth)
  }

  val alcoholic = Alcoholic(false, beer)
  val engineer = Engineer(true)


}
