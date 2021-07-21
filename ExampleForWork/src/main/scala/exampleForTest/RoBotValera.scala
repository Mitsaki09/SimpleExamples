package exampleForTest

class RoBotValera {

  def name: String = "Valera"

  def doYouLike(v: String): Boolean = {
    v match {
      case "Сникерс" => false
      case "Баунти" => false
      case "Смазка" => true
      case "Шестеренка" => true
      case _ => false
    }
  }

  def isLexa(name: Option[String]): Boolean = {
    val nameNotOpt = name.getOrElse("имя по умолчанию")
    nameNotOpt.toUpperCase == "LEXA"
  }

  def doYouKnowMe(firstNameOpt: Option[String], lastNameOpt: Option[String], middleNameOpt: Option[String]): Option[String] = {
    for {
      firstName <- firstNameOpt
      lastName <- lastNameOpt
      middleName <- middleNameOpt
    } yield "Привет " + firstName + " " + lastName + " " + middleName
  }



}