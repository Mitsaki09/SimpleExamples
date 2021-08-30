package snake

import java.awt.event.KeyEvent.{VK_A, VK_D, VK_Q, VK_S, VK_W}
import java.awt.event.{KeyEvent, KeyListener}

  object Main extends App {
    val jFrame = JFrameFactory.create

    val part = JSnakeBodyPart(0,0)
    val part2 = JSnakeBodyPart(10,0)
    val part3 = JSnakeBodyPart(20,0)
    var snakeParts = Seq(part, part2, part3)

    val keyListener = new KeyListener {
      override def keyPressed(e: KeyEvent): Unit = {
        val key = e.getKeyCode

        println("key = " + key)
        key match {
          case VK_W =>
          case VK_A =>
          case VK_S =>
          case VK_D =>
            snakeParts = snakeParts.map(v => v.copy(xAxis = v.xAxis + 10))
            println("пошли право")
          case VK_Q =>
          case _ =>
        }


        jFrame.getContentPane.removeAll()
        snakeParts.foreach { p =>
          jFrame.add(p)
          jFrame.revalidate()
        }


      }
      override def keyTyped(e: KeyEvent): Unit = () // если надо ловить печатанье
      override def keyReleased(e: KeyEvent): Unit = () // а тут на отпускание кнопки
    }

    jFrame.getKeyListeners.foreach(jFrame.removeKeyListener)
    jFrame.addKeyListener(keyListener) // прикрепляем к форме обработчик кнопок
  }


