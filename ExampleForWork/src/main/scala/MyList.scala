object MyList extends App {


  // List - это класс из классов. В этом классе есть поле, которое хранит значение и второе поле - которое хранит список.
  // Достоинста: быстрая вставка в начало списка, потому что для этого нужно сделать только 1 операцию.
  // Недостатки: для того чтобы посмотреть последний элемент в List то нужно пройти по всем пред идущим. Если у вас 100 элементов, то это надо сделать 100 операций

  // Seq - как бы табличка с значением и его порядком номером (начиная с 0).
  // Достоинста: быстрый поиск элементов, потому что порядковый номер как будто id и мы сразу можем получить по нему значение за 1 операцию
  // Недостатки: если надо добавить элемент (пофиг куда) то будет создаваться новая табличка и мы для каждого элемента пересчитаем его порядковый номер


  val nums: List[Int] = 1 :: (2 :: (3 :: (4 :: Nil)))
  val numsUsual: List[Int] = List(1, 2, 3, 4)


  val head: Int = numsUsual.head // если список пустой то ошибка

  val headOption: Option[Int] = numsUsual.headOption

  val tail: List[Int] = numsUsual.tail // возвращает список, состоящий из всех элементов, за исключением первого

  val isEmpty: Boolean = numsUsual.isEmpty //  возвращает true, если список пуст



  val stringsUsual: List[String] = numsUsual.map(elem => elem.toString)

 numsUsual.foreach(elem => println(elem.toString))

  numsUsual.find(elem => elem > 3)

  numsUsual.filter(elem => elem > 1).filter (elem => elem < 3)


}