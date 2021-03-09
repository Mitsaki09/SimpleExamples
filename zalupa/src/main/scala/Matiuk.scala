object MatiukExample extends App {

  abstract class Matuk(str: String) {

    def getStr: String = {


      str


    }

    def printStr(str: String): Unit = {

      println(str)


    }


    def sayMatuk(name: String): String = {

      "Ей " + name + ", ты " + str


    }


  }


  class EbliviiKot() extends Matuk("Ебливый кот")

  class MatukDeda(str: String, val nameDeda: String) extends Matuk(str: String) {


    def deda: String = {

      "тебе от " + nameDeda + " передают " + str


    }


  }
 val Ded = new MatukDeda("залупа","Дима")
 println(Ded.deda)

}

