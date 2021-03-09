object CaseClassExample extends App{

  class Valera(name:String,lastName:String){// не указали val, по этому надо реализовывать методы
    def getName:String ={ // для того чтобы получить поле
      name}
    def getLastName:String ={// для того чтобы получить поле
      lastName}
  }
  object Valera {// Обьект компаньен, с методом для спавна валерки
    def createValera(name:String,lastName:String) = new Valera(name,lastName)
  }
  val v = Valera.createValera("Valera","Pizda") // спавним валерку через метод обьекта компаньена



  case class Valera2(name:String,lastName:String)
  // Если указать case то
  // 1) будут автоматитчески созданы методы для доступа к полям
  // 2) будет автоматически сгенерирован обьект компаньем с методом для спавна apply
  // 3) теперь можно печатать экземпляры кейс класса в консоли и они будут понятными
  // 4) у всех классов есть метод .copy() позволяющий создавать обновленный класс


  val v2 = Valera2.apply("Valera","Pizda") // спавним валерку2 через метод обьекта компаньена
  val v22 = Valera2("Valera","Pizda") // в случае с кейс классом, скала уже знает что вызываеться метод apply и его можно не указывать
  v22.lastName // кажеться, что мы вызываем поле, но на самом деле мы вызываем автоматически сгененрированный метод, который просто назв. так же само
  v22.name


}
