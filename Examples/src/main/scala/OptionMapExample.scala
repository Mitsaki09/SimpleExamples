object OptionMapExample {
  val optA: Option[Int] = Option(100)
  val optB: Option[Int] = Option(200)
  val optRes: Option[Int] = optA.flatMap(v => optB.map(u => v + u))


  val opt1: Option[Int] = Option(100) // Если тут None, то и в opt2 будет None
  val opt2: Option[Int] =
    opt1.map(toChtoLejitVSome => toChtoLejitVSome + 25) // достает то что лежит в Some(...)  и ложит в переменную toChtoLejitVSome
      .map(toChtoLejitVSome => toChtoLejitVSome + 25)
      .map(toChtoLejitVSome => toChtoLejitVSome + 25)

  println(opt2)


  val optInt: Option[Int] = Option(100)
  val optString: Option[String] = optInt.map { v =>
    "my number" + v.toString
  }


  case class MyClass(a: Int)
  val optInt2: Option[Int] = Option(100)
  val optClass: Option[MyClass] = optInt.map { v =>
    MyClass(v)
  }

  // .map() достает то что лежит в опшине и позволяет сделать с ним какую-то операцию
  // Например, мы можем увеличить число, поменять тип или даже сделать класс
  // Важно, Option[...] получит вместо ... тот тип, что будет на посл строчке мапа
  // Важно2, На последней строчке мапа не должен быть другой опшен.

}
