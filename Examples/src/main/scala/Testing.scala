object Testing {
  // Не правильное применение. Перегоняем из одного типа в другой. Используй другие методы для конвертации
  // Появилось в 2004 году
  object ImplicitConversion extends App {

    case class Elefant(size: Int)

    case class Fly(size: Int)

    private def addToPride(elefant: Elefant): Unit = {
      println("Got it")
    }

    implicit def flyToElefant(fly: Fly) = Elefant(fly.size) // конверсия из мухи в слона

    addToPride(Fly(5))
  }

  // Правильное применение. Расширяем класс при помощи имплисита. Подмешивает к уже существующему обьекту новое поведение.
  // Появилось в 2004 году
  object ImplicitConversion2 extends App {

    trait ICanFly {
      def fly: Unit
    }

    case class Elefant(size: Int)

    case class Fly(size: Int) extends ICanFly {
      override def fly: Unit = println("I can fly")
    }

    private def startFly(iCanFly: ICanFly*): Unit = {
      iCanFly.foreach(_.fly)
    }

    implicit def flyForElefant(elefant: Elefant): ICanFly =
      new Elefant(elefant.size) with ICanFly {
        override def fly: Unit = println("I can fly, too")
      }

    startFly(Fly(7), Elefant(500))
  }

  // Типизированный метод ожидает получение неявного тайп класса. В данном случае, мы ожидаем у класса типа Т наличие штуки помогающей летать
  // Появилось в 2006 году
  object ImplicitParams extends App {

    case class Plain(model: String)

    case class FlyingPastaMonster(name: String)

    trait FlyHelper[T] {
      def support(t: T): String
    }

    implicit val plainFlyHelp = new FlyHelper[Plain] {
      override def support(plain: Plain): String = s"some science for plain: ${plain.model}"
    }

    implicit val flyingPastaMonsterFlyHelp = new FlyHelper[FlyingPastaMonster] {
      override def support(monster: FlyingPastaMonster): String = s"some magic for FlyingPastaMonster: ${monster.name}"
    }

    def startFly[T](whoIsThis: T)(implicit flyHelper: FlyHelper[T]) = {
      println(flyHelper.support(whoIsThis))
    }

    startFly(Plain("Мрія"))
    startFly(FlyingPastaMonster("John"))
  }

  // Тупо сахар над имплистным методом из ImplicitConversion2. Под капотом будет тоже самое
  // Появилось в 2010 году
  object ImplicitClasses extends App {

    trait ICanFly {
      def fly: Unit
    }

    case class Elefant(size: Int)

    case class Fly(size: Int) extends ICanFly {
      override def fly: Unit = println("I can fly")
    }

    private def startFly(iCanFly: ICanFly*): Unit = {
      iCanFly.foreach(_.fly)
    }

    implicit class FlyElefant(elefant: Elefant) extends ICanFly {
      override def fly: Unit = println("I can fly, too")
    }

    startFly(Fly(7), Elefant(500))
  }

}
