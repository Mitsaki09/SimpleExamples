object MyList extends App {


  // List - это класс из классов. В этом классе есть поле, которое хранит значение и второе поле - которое хранит список.
  // Достоинста: быстрая вставка в начало списка, потому что для этого нужно сделать только 1 операцию.
  // Недостатки: для того чтобы посмотреть последний элемент в List то нужно пройти по всем пред идущим. Если у вас 100 элементов, то это надо сделать 100 операций

  // Seq - как бы табличка с значением и его порядком номером (начиная с 0).
  // Достоинста: быстрый поиск элементов, потому что порядковый номер как будто id и мы сразу можем получить по нему значение за 1 операцию
  // Недостатки: если надо добавить элемент (пофиг куда) то будет создаваться новая табличка и мы для каждого элемента пересчитаем его порядковый номер

  val numbers = List( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val res = numbers.foldLeft(0)((m, n) => m + n)     // numbers.sum  этот мтеод заменяет foldLeft , но , то , что мы ставим в (0) эта цифра изначально будем добавляться к первому числу в списке

  val nums: List[Int] = 1 :: (15 :: (151 :: (1 :: Nil)))

  val numsUsual: List[Int] = List(1, 2, 3, 4)


  val head: Int = numsUsual.head // если список пустой то ошибка

  val headOption: Option[Int] = numsUsual.headOption

  val tail: List[Int] = numsUsual.tail // возвращает список, состоящий из всех элементов, за исключением первого

  val isEmpty: Boolean = numsUsual.isEmpty //  возвращает true, если список пуст



  val stringsUsual: List[String] = numsUsual.map(elem => elem.toString)

 numsUsual.foreach(elem => println(elem.toString))

  numsUsual.find(elem => elem > 3)

  numsUsual.filter(elem => elem > 1).filter (elem => elem < 3)









  type Otdelenie = (String,String,String)
  case class Vzvod (name:Otdelenie,namber:Int)
  val soldat1 = Vzvod (("рядавой","Алексантр","Пупко"),1)
  val soldat2 = Vzvod (("рядавой","Семен","Карлов"),2)
  val soldat3 = Vzvod (("рядавой","Антон","Капустин"),3)
  val soldat4 = Vzvod (("рядавой","Павел","Андропов"),4)
  val soldat5 = Vzvod (("рядавой","Александр","Кукушкин"),5)


  val spisokVzvoda2 = Seq(soldat1,soldat2,soldat3,soldat4,soldat5).map(seqSoldat => seqSoldat.namber) // map - достаёт внутренности . В круглых скобочках мы даём название телам, которые лежат внутри
    // списка, ставим стрелочку, пишем имя тел, который внутри списка, ставим точку и вызываем что нам нужно
  println(spisokVzvoda2)


  val spisokVzvoda = Seq (soldat1,soldat2,soldat3,soldat4,soldat5)
  println(spisokVzvoda)



}