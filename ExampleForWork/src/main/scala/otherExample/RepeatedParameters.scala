package otherExample

object RepeatedParameters extends App {

  def sum(args: Int*): Int = {
    val temp: Seq[Int] = args
    args.fold(0)(_ + _)
  }


  val sum1 = Seq(1, 2, 3, 4).foldLeft(0) { (acc, element) =>
    println("acc = " + acc)
    println("element = " + element)
    acc + element
  }
  println(sum1)


  val sum2 = Seq(1, 2, 3, 4).reduce { (elem, nextElem) =>
    println("elem = " + elem)
    println("nextElem = " + nextElem)
    elem + nextElem
  }
  println(sum2)


  /*  Seq(1, 2, 3, 4).reverse // получаем новый список задом на перед
    Seq(1, 2, 3, 4).foldRight() // под капотом вызывает reverse, по этому его лучше не использовать
    Seq(1, 2, 3, 4).fold() // юзает сранную магию и идет с двух сторон.*/


  // Дано здоровье героя HP = 100
  // Герой начинает схватку с противником и получает урон. Урон представлен шквалом ударов и храниться в Seq(5, 15, 25, 30, 7, 40, 45)
  // При получение урона герой теряет жизни. т.е. 100 - 5 = 95; 95 - 15 = 80 ...
  //  Получить HP героя после шквала ударов, если здоровье упало ниже 0 то выдать ошибку с сообщением о гибели героя.
  val hp = 100
  val dps = Seq(5, 15, 25, 30, 7, 40, 45)

  val a = dps.foldLeft(hp) {
    (newHp, dmg) =>
      val lastHp = newHp - dmg
      println(lastHp)
      lastHp
  }


  // Дано здоровье героя HP = 100
  // Герой начинает схватку с противником и получает урон. Иногда противник промахиваеться.
  // Урон и промахи храниться в Seq(Some(5), None, Some(15), Some(25), None, Some(30), Some(7), Some(40), Some(45))
  // При получение урона герой теряет жизни. т.е. 100 - 5 = 95; 95 - None = 95, 95 - 15 = 80 ...
  // Просчитать сколько ударов способен пережить герой


}
