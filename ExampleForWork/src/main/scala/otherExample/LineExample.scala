package otherExample

import scala.util.Random

object LineExample extends App {

  //Дана строка. Вывести ее три раза через запятую и показать количество символов в ней.
  val line: String = "ILIKEANIME"
  val newStr = (1 to 3).toSeq.map(_ => line).mkString(",")
  println(newStr)
  println(newStr.length)

  //Дана строка. Вывести первый, последний и средний (если он есть)) символы.


  val character = line(0)
  val character2 = line(line.length / 2)
  val character3 = line(line.length - 1)
  println(character)
  println(character2)
  println(character3)

  // Дана строка. Вывести первые три символа и последний три символа, если длина строки больше 5. Иначе вывести первый символ столько раз, какова длина строки.
  val a = if (line.length > 5) {
    println(line(0), line(1), line(2), line(line.length - 3), line(line.length - 2), line(line.length - 1))
  } else {
    line.map(_ => println(line(0)))
  }

  println(a)
  //Сформировать строку из 10 символов. На четных позициях должны находится четные цифры, на нечетных позициях - буквы.


  val n10 = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).map(n => if (n % 2 == 0) s"$n" else Random.nextString(1).mkString)
  println(n10)

  //Дана строка. Показать номера символов, совпадающих с последним символом строки.

  val lineLast = line(line.length - 1)


  val lineMap = line.map(v => if (lineLast == v) println(v) else ())

  //Дана строка. Показать третий, шестой, девятый и так далее символы
  /*  val arrayLine = line.map(v=> if(v%3 == 0 ) s"$v" else())*/
  // toCharArray - хранит номер элемента
  /*  println(arrayLine.mkString("Array(", ", ", ")"))*/
  val lineSS = line.grouped(3)
  println(lineSS)


}
