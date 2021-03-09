class DialogHelper {

  def getName(nomer: Int): String = {
    println("ведите имя игрока- " + nomer)
    val NameForLine: String = scala.io.StdIn.readLine
    NameForLine
  }
def lovegame(game:String): String={

  println("ваша любимая игра " + game)
  println("какую еще игру ты любишь")

  val Game: String = scala.io.StdIn.readLine
  Game
}
}
