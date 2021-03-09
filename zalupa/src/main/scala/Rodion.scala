
object Rodion extends App {


  while (true) {

    println("Давай оценим родиончика?(давай или ну нафиг),если хотите выйти напишите exit")
    val rodionya: String = scala.io.StdIn.readLine()

    rodionya match {
      case "давай" => println("приятно слышать,первый вопрос - Родиончик красивый?( true или false)")
        val da: Boolean = scala.io.StdIn.readBoolean()


        da match {
          case true => println(
            """"это правда, ты теперь на 1 процент лучше, так как ты понимаешь
              |величие Родиончика ,переходим ко второму вопросу?(да или нет)"""".stripMargin)


            val rodionya2: String = scala.io.StdIn.readLine()
            rodionya2 match {
              case "да" => println("нойс,сколько см пенис у Родиончика?")
                val sm: Float = scala.io.StdIn.readFloat()

                sm match {
                  case sm if sm > 12.5 => println("угадал -_-,имя жены Родина?(Амина, Залупка, Евгений")



                    var name: String = scala.io.StdIn.readLine()

                    while (name != "Залупка") {
                      name match {
                        case "Амина" => println("почти")
                        case "Залупка" => println("молодец!")
                        case _ =>println("ты дебил?")

                      }
                    name = scala.io.StdIn.readLine()


                   }
                    println("последний вопрос, родион Пенисный?(да, нет)")
                    var penis: String = scala.io.StdIn.readLine()

                    while (penis != "да") {


                      penis match {
                        case "да" => println("очень верный ответ")
                        case _ => println("попробуй ещё раз")


                      }
                      penis = scala.io.StdIn.readLine()
                    }

                    {

                      println("КОНЕЦ")
                    }





                  case sm if sm < 12.4 => println("не угадал")
                }
              case _ =>


            }
          case false => println(
            """нахер иди,чма кусок
              |ответ не верный , вы вернулись в начало""".stripMargin)


        }


      case "exit" => println("жаль что вы уходите")
        System.exit(1)
      case _ => println("ответ не верный , вы вернулись в начало")


    }

  }
}

