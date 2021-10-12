package otherExample

object DefWithAbstract extends App {
  abstract class DestinysCommand {
    def pr: Unit = {
      println()
    }
  }

  class Jopa extends DestinysCommand {
    override def pr(): Unit = {
      println("не повезло")
    }
  }

  class Udacha extends DestinysCommand {
    override def pr(): Unit = {
      println("повезло")
    }
  }

  def znachit(implicit destinysCommand: DestinysCommand): Unit = {
    println(destinysCommand.pr)
  }

  implicit val jopa = new Jopa
  znachit
}
