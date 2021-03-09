object What extends App {
  def decorate(text: String, right: String, left: String) = {
    val newString: String = left + text + right
    println(newString)
  }
decorate(text="ня",right="!",left="===>")
decorate(right="!",text="ня",left="===>")





  def decorate2 (begin: String="2", text: String, and: String="5")= {
    val newString2: String = begin + text + and
    println(newString2)

  }
decorate2("begin", "text", "and")
decorate2(begin="begin", text="text", and="and")
decorate2(text="text",begin="begin", and="and")
decorate2(text="text")


}
