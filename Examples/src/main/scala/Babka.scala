object Babka1 extends App {

  val result: String = UtilsObject.strWithPrefix("---->", "hello, dno")
  println(result)


  val utilsClass = new UtilsClass
  val result2: String = utilsClass.strWithPrefix("---->", "hello, dno")
  println(result2)


}


object UtilsObject {

 def strWithPrefix(prefix: String, str: String): String =  prefix + " " + str

}

class UtilsClass {

  def strWithPrefix(prefix: String, str: String): String =  prefix + " " + str

}