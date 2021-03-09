object AssExamples extends App{
  implicit class BigAss(val s : String){
    def bigAssUpper(pr:String = "BIG ASS "):String = {
    pr + s.toUpperCase}

  }


println("hgfgyjyfghghyjm".bigAssUpper())


}
