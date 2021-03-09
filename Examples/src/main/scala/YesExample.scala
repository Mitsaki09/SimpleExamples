class YesExample extends App{

  class Question(name:String,age: Int,gay:Option[String]){

  def getname:String={
    name}
    def getage:Int={
      age}

    def getgay(strOpt: Option[String]):String = {
        if(strOpt == None) "бл" else strOpt.get

      }
    }


}
