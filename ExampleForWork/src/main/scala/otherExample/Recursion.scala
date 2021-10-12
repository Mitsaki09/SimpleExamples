package otherExample

object Recursion extends App {
  //---------------------------------------------обычная рекурсия-------------------------------------------------------
  //обычная рекурсия доходит до заданной точки и возвращается обратно а начало (вспомни пример с коробками)
  //        блок 1                 блок 2             блок 3
  //       ------------          ------------       ------------
  //       |  n = 3     |       |  n = 2     |     |  n = 1     |
  //       |   sum = 3*_| ->    |   sum = 2*_| ->  |  1         |    после того, как дошло от 1 блока до 3, она возвращается до 2 блока и до 1 , по кругу
  //        ------------        -------------       -------------
  //              |                |       |              |
  //              ------------------      ----------------


  def factorial(n: Int): Int = {
    if (n == 1)
      1
    else {
      val sum = n * factorial(n - 1)
      sum
    }
  }

  println(factorial(5))
  //--------------------------------------------хвостовая рекурсия------------------------------------------------------
  //хвостовая рекурсия меньше затрат на память, доходит до заданой точки(которая указана - 1)
  //        блок 1                 блок 2             блок 3             бок 4
  //       ------------          ------------       ------------      ------------      вычисление идёт от 1 блока до 4 блока не возвращаясь.Останавливается на 4
  //       |  n = 3     |       |  n = 2     |     |  n = 1     |     |  n=1      |
  //       |   sum = 1  | ->    |   sum = 3  | ->  | sum = 6    |  -> | newsum=6  |
  //       |newsum =   _|       |newsum =   _|     |newsum =   _|     |           |
  //        ------------        -------------       -------------      ------------
  //              |                |       |          |      |              |
  //              ------------------      ---------------    ----------------

  def factorial2(n: Int, sum: Int = 1): Int = {
    if (n == 1)
      sum
    else {
      val newSum = factorial2(n - 1, sum * n)
      newSum
    }
  }

  println(factorial2(5))


  def getGovnuk(seq: Seq[String] = Seq.empty): Seq[String] = {
    println("Введите имя говнюка")
    val name = scala.io.StdIn.readLine()

    println("Будем вводить еще говнюков?")

    val bool = scala.io.StdIn.readBoolean()

    val newSeq: Seq[String] = seq :+ name
    if (bool) getGovnuk(newSeq) else newSeq
  }

  println(getGovnuk())
}
  object Recursion2 extends App {

    //-----------------------------------------
    def getZdarov(): Unit = {
      println(" Как дела?  ")
      val name = scala.io.StdIn.readLine().toUpperCase()

      if (name != "ПОТИХОНЬКУ САМ КАК?") getZdarov()
      else
        throw new Exception("ах ты говнюк")

    }

    //-----------------------------------------
    /*    getZdarov()
    def getZdarov2(): Unit = {
      println(" Как дела?  ")
      val name = scala.io.StdIn.readLine().toUpperCase()

      if (name == "ПОТИХОНЬКУ САМ КАК?") throw new Exception("ах ты говнюк")
      else
        getZdarov()

    }

    getZdarov2()*/
  }
    object Recursion3 extends App {

      def getZdarov3(str:String): Unit = {
        println(" Как дела?  ")
        val question1 = scala.io.StdIn.readLine().toUpperCase()

        if (str == question1) throw new Exception("ах ты говнюк")
        else
          getZdarov3(question1)

      }
      getZdarov3("")
  }

