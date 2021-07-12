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

  val fly = Fly("Муха")
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
        if(current > 0) {
          f
          loop(current - 1)
        }
      loop(x)
    }
  }
}
