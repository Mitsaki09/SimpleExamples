
object ProgExample extends App{

  println(Console.RED +"Ｗｅｌｃｏｍｅ     ｔｏ      ｏｕｒ       ｓｔｏｒｅ")
println(Console.YELLOW +"желаете провести регистрацию на нашем сайте?(да,нет)")
  val questionReg:String = scala.io.StdIn.readLine()
  questionReg match {
    case str: String if str.toUpperCase() == "ДА" =>println(Console.BLUE +"введите вашу почту")
    // выше тоже самое ! case "да"|"ДА"|"Да"|"дА"=>println(Console.BLUE +"введите вашу почту")
      val questionMail:String = scala.io.StdIn.readLine()
      val sob = questionMail.contains("@")
      if (sob) {
        println("введите свой возраст")
        val questionAge:Int = scala.io.StdIn.readInt()
        questionAge match {
          case age if age  <= 18 => println("извините, возраст не подходит")
          case age if age >= 18 => println("введите номер карты")
            val questionNumberCard:String = scala.io.StdIn.readLine()
            if(questionNumberCard.length == 16) {
              println("мы вам заказали товар на сумму 100000$ , напишите адресс")
              val questionAddress:String = scala.io.StdIn.readLine()
              println("высылаем на "+questionAddress +" все дилдо,пасиб")
            }else{
              println("не верный номер карты ")
            }

        }
      } else {

      }
    case str2:String if str2.toUpperCase() == "НЕТ" => println("желаете ознакомиться с нашим товаром?")
      val questionTovar:String = scala.io.StdIn.readLine()
      questionTovar match {
        case str3: String if str3.toUpperCase() == "ДА" =>println(Console.BLUE +"https://amurchik.ua")
        case str4:String if str4.toUpperCase() == "НЕТ" => println("всего хорошего           умрите      ")
        case _ => "не могу разобрать"
      }
    case _ => println("ШО?")
    }




}
