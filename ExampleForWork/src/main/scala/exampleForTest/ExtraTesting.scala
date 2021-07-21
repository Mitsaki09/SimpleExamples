package exampleForTest

class ForExtraTesting {

  type Name = String

  def ubratProbelu(str: String): String = str.trim // убирает пробелы  только сначала и в конце, а в середине не убирает

  def sBolsheiBUkvu(str: String): String = str.toUpperCase()

  def maxFromSeq(in: Seq[Int]): Option[Int] = in.maxOption // передаёт макс значение

  def givePoZubam(name: Name): String = {
    if (name.length >= 6 ){
      givePoZubamLongName(name)
    } else {
      givePoZubamShortName(name)
    }
  }

  // Приватные методы тестируют через публичные, т.е. что бы протестить эти надо вызывать givePoZubam
  private def givePoZubamLongName(name: Name): String = {
    name match {
      case "Джамшут" => "Джамшут, сейчас ты отгребешь и потеряешь все зубы"
      case "Мустафа" => "Мустафа, если у тебя нет денег то тебе капец"
      case _ => "Тебе повезло " + name + " , ты не Джамшут"
    }
  }

  private def givePoZubamShortName(name: Name): String = {
    if (name == "Родион") {
      "Родионов мы не бьем и даем вам 40 грн"
    } else {
      "Лови аптечку на - 67 dmg"
    }
  }


}
