object MessageExample extends App {


  while (true) {

    println("будете вводить текст?(да или нет,exit)")
    val osnov: String = scala.io.StdIn.readLine()
    osnov match {

      case "да" => println("нойс, введите текст")

        val osnovOtvet: String = scala.io.StdIn.readLine



    println("желаете ввести суфикс?(true/false)")
    val sufixQuestion: Boolean = scala.io.StdIn.readBoolean


    val sfx: String =
      if (sufixQuestion ) {
        println("введите суфикс ")
        val sufix: String = scala.io.StdIn.readLine
        sufix
      }
      else {
        val sufixNone: String = "ERROR "
        sufixNone




      }

    println("желаете ввести префикс?(true/false)")
    val prfxQuestion: Boolean = scala.io.StdIn.readBoolean

    val prfx: String =
      if (prfxQuestion) {
        println("введите префикс ")
        val prefix: String = scala.io.StdIn.readLine
        prefix
      }
      else {
        val prefixNone: String = " ERROR"
        prefixNone

      }
        def full: String = sfx + osnovOtvet + prfx

        println(full)


      case "нет" => println("напишите да ".stripMargin)
      case "exit" => println("жаль что вы уходите")
        System.exit(1)
      case _ => println("неккоректный ответ".stripMargin)






    }

  }
}
