package exampleForTest

class DayOfWeek {

  def week(day:Int):String={
    day match {
      case 1 => "Понедельник"
      case 2 => "Вторник"
      case 3 => "Среда"
      case 4 => "Четверг"
      case 5 => "Пятница"
      case 6 => "Суббота"
      case 7 => "Воскресенье"
      case _ => "Ошибка"
    }

  }
}
