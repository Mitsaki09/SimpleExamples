object OptionExample extends App{


  val middleName: String = "Valerevich"

  class Human(val name: String, val lastName: String, val middleName: String)

  val ihor = new Human("Ihor", "Zalupka", "")


  val middleNameOpt1: Option[String] = Some("Valerevich") // если мы хоти заполнить опциональность то пишем Some( )
  val middleNameOpt2: Option[String] = None // если не хотим заполнять то None


  class Human2(val name: String, val lastName: String, val middleName: Option[String])

  val a = new Human2("Ihor", "Zalupka", None)
  val b = new Human2("Ihor", "Zalupka", Some("Otchestvo"))


  //  готовые методы на Option

  val optionStringExample: Option[String] = None
  //val optionStringExample: Option[String] = Some("vbcf")

  // 1) метод .get
  //val simpleStr: String = optionStringExample.get // не безопасный, если None то ошибка

  // 2) метод .getOrElse( )
  val simpleStrWithDefault: String = optionStringExample.getOrElse("default строка") //  если None то подставит значение по умолчанию

  // 3)
  optionStringExample match {
    case Some(myStr) => println("нашли:" +myStr)  // сюда мы попадем если в опциональной переменной есть значение, это значение будет в myStr
    case None => println("Нефига") // сюда попадем если в опциональной переменной пусто - None
  }

}
