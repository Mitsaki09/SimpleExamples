object WorkWithFile extends App {

/*
  println("Считать - true  или сохранить - false?")
  val bool = scala.io.StdIn.readBoolean()

  if (bool) {
    println("Введите имя")
    val name = scala.io.StdIn.readLine()

    println("Введите возраст")
    val age = scala.io.StdIn.readInt()

    import java.io.PrintWriter
    new PrintWriter("D:\\example.txt") {
      write(name)
      write("\n")
      write(age.toString)
      close }

  } else {
    val source = scala.io.Source.fromFile("D:\\example.txt")
    val lines: List[String] = try source.getLines().toList finally source.close()

    println("Имя - " + lines(0))
    println("Возраст - " + lines(1))
  }*/

  /*Создать программу, которая считывает из файла одну первую строчку и если там "Аниме" то попросить пользователя ввести  название любимого аниме
  и сохранить его в тот же файлик. Если там не "Аниме" то напечатать "Ваше любимое аниме" - $anime*/

  println("Считать - true  или сохранить - false?")
  val source = scala.io.Source.fromFile("D:\\example.txt")       // считывает именно с файла а не с консольки scala.io.StdIn.readLine()
  val lines: List[String] = try source.getLines().toList finally source.close() // считывает именно с файла а не с консольки scala.io.StdIn.readLine()

  if (lines(0) == "Аниме") {
    println("Введите название любимого аниме")
    val anime = scala.io.StdIn.readLine()



    import java.io.PrintWriter
    new PrintWriter("D:\\example.txt") {
      write(anime)
      write("\n")
      close }

  } else {
    val source = scala.io.Source.fromFile("D:\\example.txt")
    val lines: List[String] = try source.getLines().toList finally source.close()

    println("аниме - " + lines(0))
  }


}