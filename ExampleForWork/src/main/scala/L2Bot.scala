import java.awt.Robot
import java.awt.event.KeyEvent

object L2Bot extends App {

  val bot = new Robot()

  Thread.sleep(7000)


  while(true) {
    println("F1")
    bot.keyPress(KeyEvent.VK_F1)
    bot.delay(350)
    bot.keyRelease(KeyEvent.VK_F1)
    bot.delay(350)

    println("F2")
    bot.keyPress(KeyEvent.VK_F2)
    bot.delay(350)
    bot.keyRelease(KeyEvent.VK_F2)
    bot.delay(350)

    println("F3")
    bot.keyPress(KeyEvent.VK_F3)
    bot.delay(350)
    bot.keyRelease(KeyEvent.VK_F3)
    bot.delay(2000)
  }
}
