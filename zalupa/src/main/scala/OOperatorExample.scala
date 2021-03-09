object OOperatorExample extends App {

  val a: Int = 1
  val b: Int = 1 + 1

  def one: Int = {
    1
  }
  val c: Int = one

  def korenKvadratnui(in: Int): Int = {
    in * in
  }

  val d: Int = korenKvadratnui(2)
  val d2: Int = korenKvadratnui(3)



  class NalogHelp(nalogSize: Double) {
    
    def calculate(chislo: Int): Double = {
      val res = chislo * nalogSize
      res
    }
  }

  val nalogHelp = new NalogHelp(0.05)

  nalogHelp.calculate(100)
  nalogHelp.calculate(200)
  nalogHelp.calculate(300)
  nalogHelp.calculate(400)

  val nalogHelp2 = new NalogHelp(0.1)

  nalogHelp2.calculate(100)
  nalogHelp2.calculate(200)
  nalogHelp2.calculate(300)
  nalogHelp2.calculate(400)

}

