object SushnExample extends App{
  class Gamer(nick:String, victories:Int,range:Option[String]) {
    def getNick: String = {
      nick
    }

    def getVictories: Int = {
      victories
    }

    def getRange: Option[String] = {
      range
    }

  }
      def nickQustion1(): String = {
        println("ник")
        val nickQustion : String = scala.io.StdIn.readLine()
      println(nickQustion)
        nickQustion}


    def victoriesQustion1(): Int = {
      println("победы")
      val victoriesQustion : Int = scala.io.StdIn.readInt()
     println(victoriesQustion)
      victoriesQustion}


def rangeSum(victory:Int):Option [String]={
  val Victory  = victory
  Victory match {
    case  victoriesQustion if victoriesQustion  >= 10 => Some("нуб")
    case  victoriesQustion if victoriesQustion  >= 100 => Some("норм")
    case  victoriesQustion if victoriesQustion  >= 300 => Some("про")
    case  victoriesQustion if victoriesQustion  <= 10 => None

  }
     }


  val sgr = nickQustion1

  val egh = victoriesQustion1


val wg = rangeSum(egh)


val gamer = new Gamer(sgr,egh,wg)

println(gamer.getNick+gamer.getRange+gamer.getVictories)
}
