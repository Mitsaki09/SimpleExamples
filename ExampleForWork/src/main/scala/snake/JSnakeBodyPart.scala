package snake

import java.awt.{Color, Graphics}

import javax.swing.JComponent

case class JSnakeBodyPart(xAxis: Int, yAxis: Int, color: Color = Color.GREEN) extends JComponent {

  override def paint(g: Graphics): Unit = {
    g.setColor(color)
    g.fillRect(xAxis, yAxis, 10, 10)
    g.setColor(Color.BLACK)
    g.drawRect(xAxis, yAxis, 10, 10)
  }

}
