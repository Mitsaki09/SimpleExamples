object MethodExample extends App {

  val dialogHelper = new DialogHelper

 /* val player1 = new Player(dialogHelper.getName(1))
  println("привет,братан , " + player1.getnickname)*/

  val player2 = new Player(dialogHelper.getName(2))
  println("привет,братан , " + player2.getnickname + " который любит "  + dialogHelper.lovegame("witcher"))
}