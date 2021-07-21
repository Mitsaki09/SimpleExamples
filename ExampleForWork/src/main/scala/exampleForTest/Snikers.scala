package exampleForTest

class ForTesting {

  def stepenVKvadrate(a: Int): Int = a * a

  def idToName(id: Long): Option[String] = {
    id match {
      case 1 => Some("Bob")
      case 200 => Some("John")
      case 700 => Some("Kate")
      case _ => None
    }
  }

  def eatOneCandyFromSnikers(snikers: Snikers): Snikers = {
    if (snikers.count_konfet > 0){
      snikers.copy(count_konfet = snikers.count_konfet - 1)
    } else {
      snikers
    }
  }

}

case class Snikers(count_konfet: Int)