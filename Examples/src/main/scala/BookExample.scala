object BookExample extends App {

  class Book(name: String, pages: Int, author: String, age: Option[String]) {


    def getname: String = {

      name


    }

    def getpages: Int = {


      pages
    }

    def getauthor: String = {


      author

    }

    def getage: Option[String] = {

      age

    }

  }

  class BookFactory {

    def createBook: Book = {


      println("введите название")
      val NameBook: String = scala.io.StdIn.readLine

      println("кол. стр")
      val PagesKol: Int = scala.io.StdIn.readInt

      println("автор")
      val NameAuthor: String = scala.io.StdIn.readLine

      println("Хотите вводить год ?")
      val hochu: Boolean = scala.io.StdIn.readBoolean()

      val yearOpt: Option[String] =
        if (hochu == true) {
          val year: String = scala.io.StdIn.readLine
          Some(year)
        }
      else
      {
        None
      }

      val newBook = new Book(NameBook, PagesKol, NameAuthor, yearOpt)
      newBook
    }

  }


  val bookFactory = new BookFactory()
  val book1: Book = bookFactory.createBook
  val book2: Book = bookFactory.createBook
  val book3: Book = bookFactory.createBook

}




