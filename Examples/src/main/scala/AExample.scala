object AExample extends App {

  class A{
    def getvalerka:String={

      "Валерка"}
   def str(str1:String): String = {

    str1 + "!"}


  }
 val a = new A

  val f: String = a.getvalerka

  val l: String = "mr" + f

  val u: String = a.str(l)
  val u2: String = a.str(u)
  val u3: String = a.str(u)

println(u3)
  }


